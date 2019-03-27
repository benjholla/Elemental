package com.benjholla.elemental.ide.eclipse.core;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.filesystem.URIUtil;
import org.eclipse.core.internal.events.BuildCommand;
import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.core.ClasspathEntry;

import com.benjholla.elemental.ide.eclipse.Activator;
import com.benjholla.elemental.ide.eclipse.builder.ElementalBuilder;
import com.benjholla.elemental.ide.eclipse.builder.ElementalNature;
import com.benjholla.elemental.ide.eclipse.log.Log;

@SuppressWarnings("restriction")
public class ElementalProjects {
	
	public static final long ELEMENTAL_MAJOR_VERSION = 1;
	public static final long ELEMENTAL_MINOR_VERSION = 0;
	public static final long ELEMENTAL_PATCH_VERSION = 0;
	public static final String ELEMENTAL_VERSION = String.format("%d.%d.%d", ELEMENTAL_MAJOR_VERSION, ELEMENTAL_MINOR_VERSION, ELEMENTAL_PATCH_VERSION);
	
	public static final String SOURCE_DIRECTORY = "src";
	public static final String GENERATED_SOURCE_DIRECTORY = "src-gen";
	public static final String BINARY_DIRECTORY = "bin";
	public static final String ELEMENTAL_JAR = "elemental-" + ELEMENTAL_VERSION + ".jar";
	public static final String ELEMENTAL_JAR_PATH = "export" + "/" + ELEMENTAL_JAR;
	public static final String ELEMENTAL_PROJECT_RESOURCE_DIRECTORY = ".elemental"; // hidden directory
	
	public static List<IJavaProject> getElementalProjects(){
		ArrayList<IJavaProject> projects = new ArrayList<IJavaProject>();
		for(IProject project : ResourcesPlugin.getWorkspace().getRoot().getProjects()){
			try {
				if(project.isOpen() && project.hasNature(ElementalNature.NATURE_ID) && project.hasNature(JavaCore.NATURE_ID)){
					IJavaProject jProject = JavaCore.create(project);
					if(jProject.exists()){
						projects.add(jProject);
					}
				}
			} catch (CoreException e) {}
		}
		return projects;
	}
	
	public static IStatus deleteProject(IProject project) {
		if (project != null && project.exists())
			try {
				project.delete(true, true, new NullProgressMonitor());
			} catch (CoreException e) {
				Log.error("Could not delete project", e);
				return new Status(Status.ERROR, Activator.PLUGIN_ID, "Could not delete project", e);
			}
		return Status.OK_STATUS;
	}
	
	// references: 
	// https://sdqweb.ipd.kit.edu/wiki/JDT_Tutorial:_Creating_Eclipse_Java_Projects_Programmatically
	// https://eclipse.org/articles/Article-Builders/builders.html
	// http://www.programcreek.com/java-api-examples/index.php?api=org.eclipse.core.internal.events.BuildCommand
	public static IStatus createProject(String projectName, IPath projectPath, IProgressMonitor monitor) throws CoreException, IOException, URISyntaxException {
		IProject project = null;
		
		try {
			monitor.beginTask("Create Elemental Project", 2);
			
			// create the empty eclipse project
			monitor.setTaskName("Creating Eclipse project...");
			project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
			
			IJavaProject jProject = createProject(projectName, projectPath, project, monitor);
			monitor.worked(1);
			if (monitor.isCanceled()){
				return Status.CANCEL_STATUS;
			}
			
			// copy runtimes and configure project classpath
			monitor.setTaskName("Configuring project classpath...");
			configureProjectClasspath(jProject);
			monitor.worked(1);
			if (monitor.isCanceled()){
				return Status.CANCEL_STATUS;
			}
			
			return Status.OK_STATUS;
		} finally {
			if (project != null && project.exists()){
				project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			}
			monitor.done();
		}
	}

	private static void configureProjectClasspath(IJavaProject jProject) throws CoreException, JavaModelException, IOException, URISyntaxException {
		// create bin folder
		try {
			IFolder binFolder = jProject.getProject().getFolder(BINARY_DIRECTORY);
			if(!binFolder.exists()) {
				binFolder.create(false, true, null);
			}
			jProject.setOutputLocation(binFolder.getFullPath(), null);
		} catch (Throwable t){
			Log.warning("Could not create bin folder.", t);
		}
		
		// create a set of classpath entries
		List<IClasspathEntry> entries = new ArrayList<IClasspathEntry>(); 
		
		// adds classpath entry of: <classpathentry kind="con" path="org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.8"/>
		String jvmPath = org.eclipse.jdt.launching.JavaRuntime.JRE_CONTAINER + "/" + org.eclipse.jdt.internal.launching.StandardVMType.ID_STANDARD_VM_TYPE + "/" + "JavaSE-1.8";
		entries.add(JavaCore.newContainerEntry(new Path(jvmPath)));
		
		// create source folder and add it to the classpath
		IFolder sourceFolder = jProject.getProject().getFolder(SOURCE_DIRECTORY);
		sourceFolder.create(false, true, null);
		IPackageFragmentRoot sourceFolderRoot = jProject.getPackageFragmentRoot(sourceFolder);
		entries.add(JavaCore.newSourceEntry(sourceFolderRoot.getPath()));
		
		// create generated source folder and add it to the classpath
		IFolder generatedSourceFolder = jProject.getProject().getFolder(GENERATED_SOURCE_DIRECTORY);
		generatedSourceFolder.create(false, true, null);
		IPackageFragmentRoot generatedSourceFolderRoot = jProject.getPackageFragmentRoot(generatedSourceFolder);
		entries.add(JavaCore.newSourceEntry(generatedSourceFolderRoot.getPath()));
		
		//  add the elemental jar 
		addElementalRuntime(jProject);

		// have to create this manually instead of using JavaCore.newLibraryEntry because JavaCore insists the path be absolute
		IClasspathEntry relativeElementalRuntimeEntry = new ClasspathEntry(IPackageFragmentRoot.K_BINARY,
				IClasspathEntry.CPE_LIBRARY, new Path(ELEMENTAL_PROJECT_RESOURCE_DIRECTORY + "/" + ELEMENTAL_JAR), ClasspathEntry.INCLUDE_ALL, // inclusion patterns
				ClasspathEntry.EXCLUDE_NONE, // exclusion patterns
				null, null, null, // specific output folder
				false, // exported
				ClasspathEntry.NO_ACCESS_RULES, false, // no access rules to combine
				ClasspathEntry.NO_EXTRA_ATTRIBUTES);
		entries.add(relativeElementalRuntimeEntry);
		
//		// adds classpath entry of: <classpathentry kind="con" path="org.eclipse.xtend.XTEND_CONTAINER"/>
//		// TODO: find and use constant for org.eclipse.xtend.XTEND_CONTAINER
//		String xtextPath = "org.eclipse.xtend.XTEND_CONTAINER";
//		entries.add(JavaCore.newContainerEntry(new Path(xtextPath)));
		
		// set the class path
		jProject.setRawClasspath(entries.toArray(new IClasspathEntry[entries.size()]), null);
		
		Log.info("Successfully created elemental project: " + jProject.getProject().getName());
	}

	private static IJavaProject createProject(String projectName, IPath projectPath, IProject project, IProgressMonitor monitor) throws CoreException {
		IProjectDescription projectDescription = project.getWorkspace().newProjectDescription(project.getName());
		URI location = getProjectLocation(projectName, projectPath);
		projectDescription.setLocationURI(location);
		
		// make this a elemental project
		// TODO: find and use constant for org.eclipse.xtext.ui.shared.xtextNature
		projectDescription.setNatureIds(new String[] { ElementalNature.NATURE_ID, "org.eclipse.xtext.ui.shared.xtextNature", JavaCore.NATURE_ID });

		// build first with Java compiler then xtext and then the Elemental builder
		BuildCommand javaBuildCommand = new BuildCommand();
		javaBuildCommand.setBuilderName(JavaCore.BUILDER_ID);
		// TODO: find and use constant for org.eclipse.xtext.ui.shared.xtextBuilder
		BuildCommand xtextBuildCommand = new BuildCommand();
		xtextBuildCommand.setBuilderName("org.eclipse.xtext.ui.shared.xtextBuilder");
		BuildCommand elementalBuildCommand = new BuildCommand();
		elementalBuildCommand.setBuilderName(ElementalBuilder.BUILDER_ID);
		projectDescription.setBuildSpec(new ICommand[]{ javaBuildCommand, xtextBuildCommand, elementalBuildCommand});

		// create and open the Eclipse project
		project.create(projectDescription, null);
		IJavaProject jProject = JavaCore.create(project);
		project.open(new NullProgressMonitor());
		return jProject;
	}

	private static File addElementalRuntime(IJavaProject jProject) throws IOException, URISyntaxException, MalformedURLException {
		// see http://stackoverflow.com/q/23825933/475329 for logic of getting bundle resource
		URL fileURL = Activator.getDefault().getBundle().getEntry(ELEMENTAL_JAR_PATH);
		URL resolvedFileURL = FileLocator.toFileURL(fileURL);
		// need to use the 3-arg constructor of URI in order to properly escape file system chars
		URI resolvedURI = new URI(resolvedFileURL.getProtocol(), resolvedFileURL.getPath(), null);
		InputStream elementalJarInputStream = resolvedURI.toURL().openConnection().getInputStream();
		if(elementalJarInputStream == null){
			throw new RuntimeException("Could not locate: " + ELEMENTAL_JAR_PATH);
		}
		File elementalLibDirectory = new File(jProject.getProject().getLocation().toFile().getCanonicalPath() + File.separatorChar + ELEMENTAL_PROJECT_RESOURCE_DIRECTORY);
		elementalLibDirectory.mkdirs();
		File elementalJar = new File(elementalLibDirectory.getCanonicalPath() + File.separatorChar + ELEMENTAL_JAR);
		Files.copy(elementalJarInputStream, elementalJar.toPath());
		return elementalJar;
	}

	private static URI getProjectLocation(String projectName, IPath projectPath) {
		URI location = null;
		if (projectPath != null){
			location = URIUtil.toURI(projectPath);
		}
		if (location != null && ResourcesPlugin.getWorkspace().getRoot().getLocationURI().equals(location)) {
			location = null;
		} else {
			location = URIUtil.toURI(URIUtil.toPath(location) + File.separator + projectName);
		}
		return location;
	}
}
