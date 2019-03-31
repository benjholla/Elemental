package com.benjholla.elemental.atlas.indexer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;

import com.benjholla.elemental.ElementalStandaloneSetup;
import com.benjholla.elemental.atlas.log.Log;
import com.benjholla.elemental.elemental.Model;
import com.benjholla.elemental.ide.eclipse.core.ElementalProject;
import com.benjholla.elemental.parser.antlr.ElementalParser;
import com.google.inject.Injector;


public class ElementalProjectAST {

	private ElementalProject project;
	private List<Model> astForest = new ArrayList<Model>();
	
	public ElementalProjectAST(ElementalProject project) throws IOException {
		this.project = project;
		for(File sourceFile : project.getSourceFiles()) {
			try {
				Injector injector = new ElementalStandaloneSetup().createInjectorAndDoEMFRegistration();
				ResourceSet resourceSet = injector.getInstance(ResourceSet.class);
				IFile file = WorkspaceUtils.getFile(sourceFile);
				URI uri = URI.createURI(file.getFullPath().toString());
				Resource r = resourceSet.getResource(uri, true);
				r.load(null);
				InMemoryFileSystemAccess fsa = injector.getInstance(InMemoryFileSystemAccess.class);
				for (CharSequence s : fsa.getTextFiles().values()) {
					ElementalParser parser = new ElementalParser();
					Model model = (Model) parser.doParse(s).getRootASTElement();
					astForest.add(model);
				}
			} catch (Throwable t) {
				Log.error("Error parsing source file: " + sourceFile.getName(), t);
			}
		}
	}
	
	public ElementalProject getElementalProject() {
		return project;
	}

	public List<Model> getASTForest() {
		return astForest;
	}
	
}
