package com.benjholla.elemental.atlas.selections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPart;

import com.benjholla.elemental.atlas.common.XCSG;
import com.benjholla.elemental.atlas.indexer.ElementalIndexer;
import com.ensoftcorp.atlas.core.db.graph.Node;
import com.ensoftcorp.atlas.core.db.set.AtlasHashSet;
import com.ensoftcorp.atlas.core.db.set.AtlasSet;
import com.ensoftcorp.atlas.core.index.common.SourceCorrespondence;
import com.ensoftcorp.atlas.core.query.Q;
import com.ensoftcorp.atlas.core.script.Common;
import com.ensoftcorp.atlas.core.script.CommonQueries;
import com.ensoftcorp.atlas.ui.selection.ISelectionContext;
import com.ensoftcorp.atlas.ui.selection.converter.ISelectionConverter;
import com.ensoftcorp.atlas.ui.selection.event.AbstractSelectionEvent;
import com.ensoftcorp.atlas.ui.selection.event.IAtlasSelectionEvent;

@SuppressWarnings("rawtypes")
public class ElementalSelectionConverter implements ISelectionConverter {

	@Override
	public boolean canConvertSelection(ISelectionContext selectionContext) {
		if (selectionContext.getSelection() instanceof IStructuredSelection) {
			Iterator iterator = ((IStructuredSelection) selectionContext.getSelection()).iterator();
			while (iterator.hasNext()) {
				Object selection = iterator.next();
				return isElementalProject(selection) || isElementalFile(selection);
			}
			return false;
		} else if(selectionContext.getSelection() instanceof ITextSelection) {
			IWorkbenchPart workbenchPart = selectionContext.getWorkbenchPart();
			if(workbenchPart instanceof IEditorPart) {
				IEditorPart editor = (IEditorPart) workbenchPart;
				IEditorInput input = editor.getEditorInput();
				if(input instanceof IFileEditorInput) {
					return isElementalFile(((IFileEditorInput) input).getFile());
				}
			}
		}
		return false;
	}

	@Override
	public IAtlasSelectionEvent convertSelection(ISelectionContext selectionContext) {
		if (!canConvertSelection(selectionContext)) {
			throw new IllegalArgumentException("argument 'selection' must be of type IStructuredSelection or ITextSelection, and must contain at least one Elemental file");
		}
		
		if(selectionContext.getSelection() instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selectionContext.getSelection();
			Iterator localIterator = structuredSelection.iterator();
			ArrayList<IProject> projects = new ArrayList<IProject>();
			ArrayList<IFile> files = new ArrayList<IFile>();
			while (localIterator.hasNext()) {
				Object selection = localIterator.next();
				if(isElementalProject(selection)) {
					IProject project = (IProject) selection;
					projects.add(project);
				} else if(isElementalFile(selection)) {
					IFile file = (IFile) selection;
					files.add(file);
				}
			}
			if(!projects.isEmpty()) {
				return new ElementalProjectSelectionEvent(selectionContext.getWorkbenchPart(), selectionContext.getSelection(), projects);
			} else {
				return new ElementalFileSelectionEvent(selectionContext.getWorkbenchPart(), selectionContext.getSelection(), files);
			}
		} else {
			ITextSelection textSelection = (ITextSelection) selectionContext.getSelection();
			ArrayList<SourceSelection> sourceSelections = new ArrayList<SourceSelection>();
			IWorkbenchPart workbenchPart = selectionContext.getWorkbenchPart();
			if(workbenchPart instanceof IEditorPart) {
				IEditorPart editor = (IEditorPart) workbenchPart;
				IEditorInput input = editor.getEditorInput();
				if(input instanceof IFileEditorInput) {
					IFile sourceFile = ((IFileEditorInput) input).getFile();
					sourceSelections.add(new SourceSelection(sourceFile, textSelection));
				}
			}
			return new ElementalSourceSelectionEvent(selectionContext.getWorkbenchPart(), selectionContext.getSelection(), sourceSelections);
		}
	}

	private static class SourceSelection {
		private IFile file;
		private ITextSelection selection;
		public SourceSelection(IFile file, ITextSelection selection) {
			this.file = file;
			this.selection = selection;
		}
		public IFile getFile() {
			return file;
		}
		public ITextSelection getSelection() {
			return selection;
		}
	}
	
	private boolean isElementalProject(Object selection) {
		if (selection instanceof IProject) {
			try {
				return ElementalIndexer.isIndexableElementalProject((IProject) selection);
			} catch (Exception e) {
				return false;
			}
		}
		return false;
	}
	
	private boolean isElementalFile(Object selection) {
		if (selection instanceof IFile) {
			IFile file = (IFile) selection;
			return "bf".equals(file.getFileExtension());
		}
		return false;
	}

	private static final class ElementalProjectSelectionEvent extends AbstractSelectionEvent {

		private Collection<IProject> projects;
		
		private ElementalProjectSelectionEvent(IWorkbenchPart workbenchPart, ISelection selection, Collection<IProject> projects) {
			super(workbenchPart, selection);
			this.projects = projects;
		}

		protected Q calculateApproximateSelection() {
			AtlasSet<Node> result = new AtlasHashSet<Node>();
			for(IProject project : projects) {
				String projectName = project.getName();
				Q proj = Common.universe().nodes(XCSG.Project).selectNode(XCSG.name, projectName);
				result.addAll(proj.eval().nodes());
			}
			return Common.toQ(result);
		}
		
	}
	
	private static final class ElementalFileSelectionEvent extends AbstractSelectionEvent {

		Collection<IFile> files;
		
		private ElementalFileSelectionEvent(IWorkbenchPart workbenchPart, ISelection selection, Collection<IFile> files) {
			super(workbenchPart, selection);
			this.files = files;
		}

		protected Q calculateApproximateSelection() {
			AtlasSet<Node> result = new AtlasHashSet<Node>();
			for(IFile file : files) {
				String projectName = file.getProject().getName();
				Q project = Common.universe().nodes(XCSG.Project).selectNode(XCSG.name, projectName);
				Q namespaces = project.children().nodes(XCSG.Namespace).selectNode(XCSG.name, file.getName());
				result.addAll(namespaces.eval().nodes());
				result.addAll(namespaces.children().nodes(XCSG.Elemental.ImplictFunction).eval().nodes());
			}
			return Common.toQ(result);
		}
		
	}
	
	private static final class ElementalSourceSelectionEvent extends AbstractSelectionEvent {

		 Collection<SourceSelection> sourceSelections;
		
		private ElementalSourceSelectionEvent(IWorkbenchPart workbenchPart, ISelection selection, Collection<SourceSelection> sourceSelections) {
			super(workbenchPart, selection);
			this.sourceSelections = sourceSelections;
		}

		protected Q calculateApproximateSelection() {
			AtlasSet<Node> result = new AtlasHashSet<Node>();
			for(SourceSelection sourceSelection : sourceSelections) {
				IFile file = sourceSelection.getFile();
				String projectName = file.getProject().getName();
				Q project = Common.universe().nodes(XCSG.Project).selectNode(XCSG.name, projectName);
				Q namespaces = project.children().nodes(XCSG.Namespace).selectNode(XCSG.name, file.getName());
				Q implicitFunctions = namespaces.children().nodes(XCSG.Elemental.ImplictFunction);
				Q cfgs = CommonQueries.cfg(implicitFunctions);
				Q cfgNodes = cfgs.selectEdge(XCSG.name, sourceSelection.getSelection().getText());
				cfgNodes = Common.toQ(cfgNodes.eval());
				if(cfgNodes.eval().nodes().size() == 1) {
					return cfgNodes;
				} else {
					// return first match by character offset
					ArrayList<Node> sortedCFGNodes = new ArrayList<Node>();
					for(Node cfgNode : cfgNodes.eval().nodes()) {
						sortedCFGNodes.add(cfgNode);
					}
					Collections.sort(sortedCFGNodes, new NodeSourceCorrespondenceSorter());
					int searchOffset = sourceSelection.getSelection().getOffset();
					for(Node cfgNode : sortedCFGNodes) {
						// loop header SC's are kind of greedy, so we exclude them from the search unless its an exact match
						SourceCorrespondence sc = (SourceCorrespondence) cfgNode.getAttr(XCSG.sourceCorrespondence);
						if(cfgNode.taggedWith(XCSG.Loop)) {
							if(searchOffset == sc.offset) {
								return Common.toQ(cfgNode);
							}
						} else {
							if(!cfgNode.taggedWith(XCSG.Loop)) {
								if(searchOffset <= (sc.offset + sc.length)) {
									return Common.toQ(cfgNode);
								}
							}
						}
					}
				}
			}
			return Common.toQ(result);
		}
		
	}

}
