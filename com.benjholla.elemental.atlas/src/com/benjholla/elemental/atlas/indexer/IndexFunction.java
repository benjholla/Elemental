package com.benjholla.elemental.atlas.indexer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.SubMonitor;

import com.benjholla.elemental.atlas.common.XCSG;
import com.benjholla.elemental.atlas.indexer.IndexInstruction.IndexLabel;
import com.benjholla.elemental.elemental.Block;
import com.benjholla.elemental.elemental.Function;
import com.ensoftcorp.atlas.core.db.graph.EditableGraph;
import com.ensoftcorp.atlas.core.db.graph.Node;

public class IndexFunction {
	
	private Byte name;
	private IndexProgram program;
	private List<IndexInstruction> body = new ArrayList<IndexInstruction>();
	private Map<Byte,IndexLabel> labels = new HashMap<Byte,IndexLabel>();
	private EMFSourceCorrespondence sc;
	
	@Override
	public String toString() {
		return body.toString();
	}
	
	public IndexFunction(IndexProgram program, Byte name, IFile sourceFile, Block implicitFunction) {
		this.program = program;
		this.name = name;
		this.sc = new EMFSourceCorrespondence(sourceFile, implicitFunction);
	}
	
	public IndexFunction(IndexProgram program, Byte name, IFile sourceFile, Function explicitFunction) {
		this.program = program;
		this.name = name;
		this.sc = new EMFSourceCorrespondence(sourceFile, explicitFunction);
	}
	
	public List<IndexInstruction> getInstructions() {
		return body;
	}
	
	public void addInstruction(IndexInstruction instruction) {
		if(instruction !=  null) {
			body.add(instruction);
			if(instruction instanceof IndexLabel) {
				IndexLabel label = (IndexLabel) instruction;
				labels.put(label.getName(), label);
			}
		} else {
			throw new IllegalStateException("Instruction cannot be null");
		}
	}
	
	public IndexLabel getLabel(Byte name) {
		return labels.get(name);
	}
	
	public IndexProgram getProgram() {
		return program;
	}
	
	public Byte getName() {
		return name;
	}
	
	public EMFSourceCorrespondence getSourceCorrespondence() {
		return sc;
	}

	public Node index(EditableGraph graph, SubMonitor monitor) {
		Node functionNode = graph.createNode();
		functionNode.tag(XCSG.Function);
		return functionNode;
	}
	
}
