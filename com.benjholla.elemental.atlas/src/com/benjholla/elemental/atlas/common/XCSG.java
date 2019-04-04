package com.benjholla.elemental.atlas.common;

import org.eclipse.ui.IStartup;

import com.benjholla.elemental.atlas.log.Log;

/**
 * A wrapper and extension for relevant XCSG tag and attribute constants
 * 
 * @author Ben Holland
 */
public class XCSG implements IStartup {

	public static class Language {
		public static final String Elemental = "XCSG.Language.Elemental";
	}
	
	public static class Elemental {
		// nodes
		public static final String LoopFooter = "XCSG.Elemental.LoopFooter";
		public static final String Instruction = "XCSG.Elemental.Instruction";
		public static final String Instructions = "XCSG.Elemental.Instructions"; // just used for coalesced basic blocks
		public static final String IncrementInstruction = "XCSG.Elemental.IncrementInstruction";
		public static final String DecrementInstruction = "XCSG.Elemental.DecrementInstruction";
		public static final String MoveLeftInstruction = "XCSG.Elemental.MoveLeftInstruction";
		public static final String MoveRightInstruction = "XCSG.Elemental.MoveRightInstruction";
		public static final String ReadInputInstruction = "XCSG.Elemental.ReadInputInstruction";
		public static final String WriteOutputInstruction = "XCSG.Elemental.WriteOutputInstruction";
		public static final String AssignmentInstruction = "XCSG.Elemental.AssignmentInstruction";
		public static final String LabelInstruction = "XCSG.Elemental.LabelInstruction";
		public static final String GOTOInstruction = "XCSG.Elemental.GOTOInstruction";
		public static final String ComputedGOTOInstruction = "XCSG.Elemental.ComputedGOTOInstruction";
		public static final String StaticDispatchInstruction = "XCSG.Elemental.StaticDispatchInstruction";
		public static final String DynamicDispatchInstruction = "XCSG.Elemental.DynamicDispatchInstruction";
	}
	
	// nodes
	public static final String Project = com.ensoftcorp.atlas.core.xcsg.XCSG.Project;
	public static final String Namespace = com.ensoftcorp.atlas.core.xcsg.XCSG.Namespace;
	public static final String Function = com.ensoftcorp.atlas.core.xcsg.XCSG.Function;
	public static final String ControlFlow_Node = com.ensoftcorp.atlas.core.xcsg.XCSG.ControlFlow_Node;
	public static final String ControlFlowRoot = com.ensoftcorp.atlas.core.xcsg.XCSG.controlFlowRoot;
	public static final String ControlFlowExit = com.ensoftcorp.atlas.core.xcsg.XCSG.controlFlowExitPoint;
	public static final String ControlFlowCondition = com.ensoftcorp.atlas.core.xcsg.XCSG.ControlFlowCondition;
	public static final String ControlFlowBranchCondition = com.ensoftcorp.atlas.core.xcsg.XCSG.ControlFlowIfCondition;
	public static final String ControlFlowLoopCondition = com.ensoftcorp.atlas.core.xcsg.XCSG.ControlFlowLoopCondition;
	public static final String Loop = com.ensoftcorp.atlas.core.xcsg.XCSG.Loop;
	
	// edges
	public static final String Contains = com.ensoftcorp.atlas.core.xcsg.XCSG.Contains;
	public static final String ControlFlow_Edge = com.ensoftcorp.atlas.core.xcsg.XCSG.ControlFlow_Edge;
	public static final String ControlFlowBackEdge = com.ensoftcorp.atlas.core.xcsg.XCSG.ControlFlowBackEdge;
	public static final String LoopChild = com.ensoftcorp.atlas.core.xcsg.XCSG.LoopChild;
	
	// attributes
	public static String name = com.ensoftcorp.atlas.core.xcsg.XCSG.name;
	public static final String conditionValue = com.ensoftcorp.atlas.core.xcsg.XCSG.conditionValue;
	public static final String sourceCorrespondence = com.ensoftcorp.atlas.core.xcsg.XCSG.sourceCorrespondence;
	
	@Override
	public void earlyStartup() {
		try {
			registerSchema();
		} catch (Exception e){
			Log.error("Unable to build tag hierarchy.", e);
		}
	}
	
	private static boolean isTagHierarchyInitialized = false;
	
	public static void registerSchema(){
		if(!isTagHierarchyInitialized){
			isTagHierarchyInitialized = true;
			com.ensoftcorp.atlas.core.xcsg.XCSG.HIERARCHY.registerTag(XCSG.Elemental.Instruction, XCSG.ControlFlow_Node);
			com.ensoftcorp.atlas.core.xcsg.XCSG.HIERARCHY.registerTag(XCSG.Elemental.Instructions, XCSG.ControlFlow_Node);
			com.ensoftcorp.atlas.core.xcsg.XCSG.HIERARCHY.registerTag(XCSG.Elemental.IncrementInstruction, XCSG.Elemental.Instruction);
			com.ensoftcorp.atlas.core.xcsg.XCSG.HIERARCHY.registerTag(XCSG.Elemental.DecrementInstruction, XCSG.Elemental.Instruction);
			com.ensoftcorp.atlas.core.xcsg.XCSG.HIERARCHY.registerTag(XCSG.Elemental.MoveLeftInstruction, XCSG.Elemental.Instruction);
			com.ensoftcorp.atlas.core.xcsg.XCSG.HIERARCHY.registerTag(XCSG.Elemental.MoveRightInstruction, XCSG.Elemental.Instruction);
			com.ensoftcorp.atlas.core.xcsg.XCSG.HIERARCHY.registerTag(XCSG.Elemental.ReadInputInstruction, XCSG.Elemental.Instruction);
			com.ensoftcorp.atlas.core.xcsg.XCSG.HIERARCHY.registerTag(XCSG.Elemental.WriteOutputInstruction, XCSG.Elemental.Instruction);
			com.ensoftcorp.atlas.core.xcsg.XCSG.HIERARCHY.registerTag(XCSG.Elemental.AssignmentInstruction, XCSG.Elemental.Instruction);
			com.ensoftcorp.atlas.core.xcsg.XCSG.HIERARCHY.registerTag(XCSG.Elemental.LoopFooter, XCSG.ControlFlowCondition);
		}
	}
	
}
