package com.benjholla.elemental.atlas.indexer;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.SubMonitor;

import com.benjholla.elemental.atlas.common.XCSG;
import com.ensoftcorp.atlas.core.db.graph.EditableGraph;
import com.ensoftcorp.atlas.core.db.graph.Node;

public abstract class IndexInstruction {

	private static long ids = 1;
	private long id = (ids++);
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IndexInstruction other = (IndexInstruction) obj;
		if (id != other.id)
			return false;
		return true;
	}

	protected IndexProgram program;
	protected IndexFunction function;
	protected List<IndexInstruction> successors = new ArrayList<IndexInstruction>();
	protected EMFSourceCorrespondence sc;
	
	protected IndexInstruction(IndexFunction function, EMFSourceCorrespondence sc) {
		this.function = function;
		this.program = function.getProgram();
		this.sc = sc;
	}
	
	public IndexProgram getProgram() {
		return program;
	}
	
	public IndexFunction getFunction() {
		return function;
	}
	
	public EMFSourceCorrespondence getSourceCorrespondence() {
		return sc;
	}

	protected void addSuccessor(IndexInstruction successor) {
		this.successors.add(successor);
	}
	
	public List<IndexInstruction> getSuccessors(){
		return successors;
	}
	
	public abstract Node index(EditableGraph graph, SubMonitor monitor);
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
	
	public static class IndexImplicitReturn extends IndexInstruction {
		protected IndexImplicitReturn(IndexFunction function, EMFSourceCorrespondence sc) {
			super(function, sc);
		}

		@Override
		public Node index(EditableGraph graph, SubMonitor monitor) {
			Node instruction = graph.createNode();
			instruction.tag(XCSG.ControlFlow_Node);
			instruction.tag(XCSG.ControlFlowExit);
			instruction.putAttr(XCSG.name, "return");
			instruction.putAttr(XCSG.sourceCorrespondence, function.getSourceCorrespondence().toAtlasSourceCorrespondence());
			return instruction;
		}
	}
	
	public static class IndexIncrement extends IndexInstruction {
		protected IndexIncrement(IndexFunction function, EMFSourceCorrespondence sc) {
			super(function, sc);
		}
		
		@Override
		public Node index(EditableGraph graph, SubMonitor monitor) {
			Node instruction = graph.createNode();
			instruction.tag(XCSG.Elemental.IncrementInstruction);
			instruction.putAttr(XCSG.name, "+");
			instruction.putAttr(XCSG.sourceCorrespondence, sc.toAtlasSourceCorrespondence());
			return instruction;
		}
	}
	
	public static class IndexDecrement extends IndexInstruction {
		protected IndexDecrement(IndexFunction function, EMFSourceCorrespondence sc) {
			super(function, sc);
		}
		
		@Override
		public Node index(EditableGraph graph, SubMonitor monitor) {
			Node instruction = graph.createNode();
			instruction.tag(XCSG.Elemental.DecrementInstruction);
			instruction.putAttr(XCSG.name, "-");
			instruction.putAttr(XCSG.sourceCorrespondence, sc.toAtlasSourceCorrespondence());
			return instruction;
		}
	}
	
	public static class IndexMoveLeft extends IndexInstruction {
		protected IndexMoveLeft(IndexFunction function, EMFSourceCorrespondence sc) {
			super(function, sc);
		}
		
		@Override
		public Node index(EditableGraph graph, SubMonitor monitor) {
			Node instruction = graph.createNode();
			instruction.tag(XCSG.Elemental.MoveLeftInstruction);
			instruction.putAttr(XCSG.name, "<");
			instruction.putAttr(XCSG.sourceCorrespondence, sc.toAtlasSourceCorrespondence());
			return instruction;
		}
	}
	
	public static class IndexMoveRight extends IndexInstruction {
		protected IndexMoveRight(IndexFunction function, EMFSourceCorrespondence sc) {
			super(function, sc);
		}
		
		@Override
		public Node index(EditableGraph graph, SubMonitor monitor) {
			Node instruction = graph.createNode();
			instruction.tag(XCSG.Elemental.MoveRightInstruction);
			instruction.putAttr(XCSG.name, ">");
			instruction.putAttr(XCSG.sourceCorrespondence, sc.toAtlasSourceCorrespondence());
			return instruction;
		}
	}
	
	public static class IndexStore extends IndexInstruction {
		protected IndexStore(IndexFunction function, EMFSourceCorrespondence sc) {
			super(function, sc);
		}
		
		@Override
		public Node index(EditableGraph graph, SubMonitor monitor) {
			Node instruction = graph.createNode();
			instruction.tag(XCSG.Elemental.ReadInputInstruction);
			instruction.putAttr(XCSG.name, ",");
			instruction.putAttr(XCSG.sourceCorrespondence, sc.toAtlasSourceCorrespondence());
			return instruction;
		}
	}
	
	public static class IndexRecall extends IndexInstruction {
		protected IndexRecall(IndexFunction function, EMFSourceCorrespondence sc) {
			super(function, sc);
		}
		
		@Override
		public Node index(EditableGraph graph, SubMonitor monitor) {
			Node instruction = graph.createNode();
			instruction.tag(XCSG.Elemental.WriteOutputInstruction);
			instruction.putAttr(XCSG.name, ".");
			instruction.putAttr(XCSG.sourceCorrespondence, sc.toAtlasSourceCorrespondence());
			return instruction;
		}
	}
	
	public static class IndexAssignment extends IndexInstruction {
		protected IndexAssignment(IndexFunction function, EMFSourceCorrespondence sc) {
			super(function, sc);
		}
		
		@Override
		public Node index(EditableGraph graph, SubMonitor monitor) {
			Node instruction = graph.createNode();
			instruction.tag(XCSG.Elemental.AssignmentInstruction);
			instruction.putAttr(XCSG.name, "=");
			instruction.putAttr(XCSG.sourceCorrespondence, sc.toAtlasSourceCorrespondence());
			return instruction;
		}
	}
	
	public static class IndexBranch extends IndexInstruction {
		private List<IndexInstruction> body = new ArrayList<IndexInstruction>();
		
		protected IndexBranch(IndexFunction function, EMFSourceCorrespondence sc) {
			super(function, sc);
		}
		
		public List<IndexInstruction> getBody() {
			return body;
		}

		protected void addInstruction(IndexInstruction instruction) {
			if(instruction !=  null) {
				body.add(instruction);
			} else {
				throw new IllegalStateException("Instruction cannot be null");
			}
		}
		
		@Override
		public Node index(EditableGraph graph, SubMonitor monitor) {
			Node instruction = graph.createNode();
			instruction.tag(XCSG.ControlFlowBranchCondition);
			instruction.putAttr(XCSG.name, "(");
			instruction.putAttr(XCSG.sourceCorrespondence, sc.toAtlasSourceCorrespondence());
			return instruction;
		}
	}
	
	public static class IndexLoopBack extends IndexInstruction {
		public IndexLoopBack(IndexFunction function, IndexLoop header, EMFSourceCorrespondence sc) {
			super(function, sc);
			this.successors.add(header);
		}
		
		@Override
		protected void addSuccessor(IndexInstruction successor) {}
		
		protected IndexLoop getHeader() {
			return (IndexLoop) successors.get(0);
		}
		
		@Override
		public Node index(EditableGraph graph, SubMonitor monitor) {
			Node instruction = graph.createNode();
			instruction.tag(XCSG.Elemental.LoopFooter);
			instruction.putAttr(XCSG.name, "]");
			instruction.putAttr(XCSG.sourceCorrespondence, sc.toAtlasSourceCorrespondence());
			return instruction;
		}
	}
	
	public static class IndexLoop extends IndexInstruction {
		private List<IndexInstruction> body = new ArrayList<IndexInstruction>();
		
		protected IndexLoop(IndexFunction function, EMFSourceCorrespondence sc, IndexInstruction... instructions) {
			super(function, sc);
		}
		
		public List<IndexInstruction> getBody() {
			return body;
		}
		
		protected void addInstruction(IndexInstruction instruction) {
			if(instruction !=  null) {
				body.add(instruction);
			} else {
				throw new IllegalStateException("Instruction cannot be null");
			}
		}
		
		@Override
		public Node index(EditableGraph graph, SubMonitor monitor) {
			Node instruction = graph.createNode();
			instruction.tag(XCSG.ControlFlowLoopCondition);
			instruction.tag(XCSG.Loop);
			instruction.putAttr(XCSG.name, "[");
			instruction.putAttr(XCSG.sourceCorrespondence, sc.toAtlasSourceCorrespondence());
			return instruction;
		}
	}
	
	public static class IndexLabel extends IndexInstruction {
		private Byte name;
		
		protected IndexLabel(IndexFunction function, Byte name, EMFSourceCorrespondence sc) {
			super(function, sc);
			this.name = name;
		}
		
		public Byte getName() {
			return name;
		}
		
		@Override
		public Node index(EditableGraph graph, SubMonitor monitor) {
			Node instruction = graph.createNode();
			instruction.tag(XCSG.Elemental.LabelInstruction);
			instruction.putAttr(XCSG.name, "label:" + name);
			instruction.putAttr(XCSG.sourceCorrespondence, sc.toAtlasSourceCorrespondence());
			return instruction;
		}
	}
	
	public static class IndexGOTO extends IndexInstruction {
		protected IndexGOTO(IndexFunction function, IndexLabel label, EMFSourceCorrespondence sc) {
			super(function, sc);
			this.successors.add(label);
		}
		
		@Override
		protected void addSuccessor(IndexInstruction successor) {}

		public IndexLabel getLabel() {
			return (IndexLabel) successors.get(0);
		}
		
		@Override
		public Node index(EditableGraph graph, SubMonitor monitor) {
			Node instruction = graph.createNode();
			instruction.tag(XCSG.Elemental.GOTOInstruction);
			instruction.putAttr(XCSG.name, "goto label:" + getLabel().getName());
			instruction.putAttr(XCSG.sourceCorrespondence, sc.toAtlasSourceCorrespondence());
			return instruction;
		}
	}
	
	public static class IndexComputedGOTO extends IndexInstruction {
		protected IndexComputedGOTO(IndexFunction function, EMFSourceCorrespondence sc) {
			super(function, sc);
		}
		
		@Override
		public Node index(EditableGraph graph, SubMonitor monitor) {
			Node instruction = graph.createNode();
			instruction.tag(XCSG.Elemental.ComputedGOTOInstruction);
			instruction.putAttr(XCSG.name, "goto label:?");
			instruction.putAttr(XCSG.sourceCorrespondence, sc.toAtlasSourceCorrespondence());
			return instruction;
		}
	}
	
	public static class IndexStaticDispatch extends IndexInstruction {
		private Byte target;
		
		protected IndexStaticDispatch(IndexFunction function, Byte target, EMFSourceCorrespondence sc) {
			super(function, sc);
			this.target = target;
		}
		
		public Byte getTarget() {
			return target;
		}
		
		@Override
		public Node index(EditableGraph graph, SubMonitor monitor) {
			Node instruction = graph.createNode();
			instruction.tag(XCSG.Elemental.StaticDispatchInstruction);
			instruction.putAttr(XCSG.name, "call function:" + getTarget());
			instruction.putAttr(XCSG.sourceCorrespondence, sc.toAtlasSourceCorrespondence());
			return instruction;
		}
	}
	
	public static class IndexDynamicDispatch extends IndexInstruction {
		protected IndexDynamicDispatch(IndexFunction function, EMFSourceCorrespondence sc) {
			super(function, sc);
		}
		
		@Override
		public Node index(EditableGraph graph, SubMonitor monitor) {
			Node instruction = graph.createNode();
			instruction.tag(XCSG.Elemental.DynamicDispatchInstruction);
			instruction.putAttr(XCSG.name, "call function:?");
			instruction.putAttr(XCSG.sourceCorrespondence, sc.toAtlasSourceCorrespondence());
			return instruction;
		}
	}
	
}
