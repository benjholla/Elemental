package com.benjholla.elemental.ide.eclipse.builder;

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

public class ElementalBuilder extends IncrementalProjectBuilder {
	
	public static final String BUILDER_ID = "com.benjholla.elemental.ide.eclipse.nature.builder";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.internal.events.InternalBuilder#build(int,java.util.Map,
	 * org.eclipse.core.runtime.IProgressMonitor)
	 */
	@SuppressWarnings("rawtypes")
	protected IProject[] build(int kind, Map args, IProgressMonitor monitor) throws CoreException {
		return null;
	}

	protected void clean(IProgressMonitor monitor) throws CoreException {}

	protected void fullBuild(final IProgressMonitor monitor) throws CoreException {}

	/**
	 * Incrementally builds the project given a set of file changes
	 * 
	 * Reference:
	 * http://help.eclipse.org/mars/index.jsp?topic=%2Forg.eclipse.platform.doc.isv%2Fguide%2FresAdv_builders.htm
	 * 
	 * @param delta
	 * @param monitor
	 * @throws CoreException
	 */
	protected void incrementalBuild(IResourceDelta delta, IProgressMonitor monitor) throws CoreException {}

}
