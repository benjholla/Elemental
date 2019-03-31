package com.benjholla.elemental.ide.eclipse.core;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedList;

import org.eclipse.core.filesystem.URIUtil;
import org.eclipse.core.internal.events.BuildCommand;
import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;

import com.benjholla.elemental.ide.eclipse.Activator;
import com.benjholla.elemental.ide.eclipse.builder.ElementalBuilder;
import com.benjholla.elemental.ide.eclipse.builder.ElementalNature;
import com.benjholla.elemental.ide.eclipse.log.Log;

@SuppressWarnings("restriction")
public class ElementalProject {

	public static final String ELEMENTAL_EXTENSION = ".e";
	public static final String SOURCE_DIRECTORY = "src";
	
	private IProject project;
	
	public ElementalProject(IProject project) {
		this.project = project;
	}

	public IProject getProject(){
		return project;
	}
	
	public File getSourceDirectory(){
		return new File(project.getFolder(SOURCE_DIRECTORY).getLocation().toOSString());
	}
	
	public File[] getSourceFiles(){
		ArrayList<File> sources = new ArrayList<File>();
		for(File source : findSourceFiles(getSourceDirectory())){
			sources.add(source);
		}
		File[] result = new File[sources.size()];
		sources.toArray(result);
		return result;
	}
	
	// helper method for recursively finding Elemental files in a given directory
	private static LinkedList<File> findSourceFiles(File directory){
		LinkedList<File> jimple = new LinkedList<File>();
		if(directory.exists()){
			if (directory.isDirectory()) {
				for (File f : directory.listFiles()) {
					jimple.addAll(findSourceFiles(f));
				}
			}
			File file = directory;
			if(file.getName().toLowerCase().endsWith(ELEMENTAL_EXTENSION)){
				jimple.add(file);
			}
		}
		return jimple;
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

	public static IProject createProject(String projectName, IPath projectPath, IProgressMonitor monitor) throws CoreException {
		
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		if(project.exists()){
			return project;
		}
		
		IProjectDescription projectDescription = project.getWorkspace().newProjectDescription(project.getName());
		URI location = getProjectLocation(projectName, projectPath);
		projectDescription.setLocationURI(location);
		
		// make this a Elemental project
		projectDescription.setNatureIds(new String[] { ElementalNature.NATURE_ID });

		// build with the Elemental compiler builder
		BuildCommand elementalBuildCommand = new BuildCommand();
		elementalBuildCommand.setBuilderName(ElementalBuilder.BUILDER_ID);
		projectDescription.setBuildSpec(new ICommand[]{ elementalBuildCommand});

		// create and open the Eclipse project
		project.create(projectDescription, null);
		project.open(monitor);
		
		// create a Elemental source folder
		IFolder sourceFolder = project.getFolder("src");
		sourceFolder.create(false, true, monitor);
		
		return project;
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
