package com.benjholla.elemental.atlas.indexer;

import java.io.File;
import java.net.URI;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;

/**
 * Helper class for dealing with Eclipse workspaces
 * 
 * @author Ben Holland
 */
public class WorkspaceUtils {

	private WorkspaceUtils() {}
	
	/**
	 * Returns a project in the workspace for the given project name
	 * @param projectName
	 * @return
	 */
	public static IProject getProject(String projectName){
		return ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
	}
	
	/**
	 * Converts a File to an Eclipse IFile 
	 * Source: http://stackoverflow.com/questions/960746/how-to-convert-from-file-to-ifile-in-java-for-files-outside-the-project
	 * 
	 * @param file
	 * @return
	 */
	public static IFile getFile(File file) {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IPath location = Path.fromOSString(file.getAbsolutePath());
		IFile iFile = workspace.getRoot().getFileForLocation(location);
		return iFile;
	}
	
	/**
	 * Converts an IFile to a Java File
	 * 
	 * @param file
	 * @return
	 * @throws CoreException 
	 */
	public static File getFile(IFile iFile) throws CoreException {
		URI uri; 

		// get the file uri, accound for symbolic links
		if(!iFile.isLinked()){
			uri = iFile.getLocationURI();
		} else {
			uri = iFile.getRawLocationURI();
		}

		// get the native file using Eclipse File System
		File file;
		if(uri != null){
			file = EFS.getStore(uri).toLocalFile(0, new NullProgressMonitor());
		} else {
			// Eclipse is weird...this last resort should work
			file = new File(iFile.getFullPath().toOSString());
		}
		
		return file;
	}
	
}