package com.benjholla.elemental.atlas.indexer;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.benjholla.elemental.ElementalStandaloneSetup;
import com.benjholla.elemental.atlas.log.Log;
import com.benjholla.elemental.elemental.Program;
import com.benjholla.elemental.ide.eclipse.core.ElementalProject;
import com.google.inject.Injector;


public class ElementalProjectAST {

	private ElementalProject project;
	private Map<IFile,Program> astForest = new HashMap<IFile,Program>();
	
	public ElementalProjectAST(ElementalProject project) throws IOException {
		this.project = project;
		for(File sourceFile : project.getSourceFiles()) {
			try {
				// TODO: how should the parser be invoked? https://www.eclipse.org/forums/index.php/t/1069267/
				Injector injector = new ElementalStandaloneSetup().createInjectorAndDoEMFRegistration();
				ResourceSet resourceSet = injector.getInstance(ResourceSet.class);
				IFile file = WorkspaceUtils.getFile(sourceFile);
				URI uri = URI.createURI(file.getFullPath().toString());
				Resource resource = resourceSet.getResource(uri, true);
				resource.load(null);
				Program ast = (Program) resource.getContents().get(0);
				astForest.put(file, ast);
			} catch (Throwable t) {
				Log.error("Error parsing source file: " + sourceFile.getName(), t);
			}
		}
	}
	
	public ElementalProject getElementalProject() {
		return project;
	}

	public Map<IFile,Program> getASTForest() {
		return astForest;
	}
	
}
