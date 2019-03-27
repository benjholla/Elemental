package com.benjholla.elemental.ide.eclipse.builder;

import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import com.benjholla.elemental.ide.eclipse.log.Log;

public class AddRemoveElementalNatureHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection) {
			for (Iterator<?> it = ((IStructuredSelection) selection).iterator(); it.hasNext();) {
				Object element = it.next();
				IProject project = null;
				if (element instanceof IProject) {
					project = (IProject) element;
				} else if (element instanceof IAdaptable) {
					project = (IProject) ((IAdaptable) element).getAdapter(IProject.class);
				}
				if (project != null) {
					try {
						toggleNature(project);
					} catch (CoreException e) {
						ExecutionException e2 =  new ExecutionException("Failed to toggle nature", e);
						Log.error(e2.getMessage(), e2);
						throw e2;
					}
				}
			}
		}

		return null;
	}

	/**
	 * Toggles elemental nature on a project
	 *
	 * @param project to have sample nature added or removed
	 */
	private void toggleNature(IProject project) throws CoreException {
		IProjectDescription description = project.getDescription();
		String[] natures = description.getNatureIds();

		for (int i = 0; i < natures.length; ++i) {
			if (ElementalNature.NATURE_ID.equals(natures[i])) {
				// Remove the nature
				String[] newNatures = new String[natures.length - 1];
				System.arraycopy(natures, 0, newNatures, 0, i);
				System.arraycopy(natures, i + 1, newNatures, i, natures.length - i - 1);
				description.setNatureIds(newNatures);
				project.setDescription(description, null);
				return;
			}
		}

		// add the nature
		String[] newNatures = new String[natures.length + 1];
		newNatures[0] = ElementalNature.NATURE_ID;
		System.arraycopy(natures, 0, newNatures, 1, natures.length);
		description.setNatureIds(newNatures);
		project.setDescription(description, null);
	}
	
}
