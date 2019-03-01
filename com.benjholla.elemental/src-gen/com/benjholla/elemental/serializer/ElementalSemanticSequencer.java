/*
 * generated by Xtext 2.16.0
 */
package com.benjholla.elemental.serializer;

import com.benjholla.elemental.elemental.Block;
import com.benjholla.elemental.elemental.Branch;
import com.benjholla.elemental.elemental.ElementalPackage;
import com.benjholla.elemental.elemental.Function;
import com.benjholla.elemental.elemental.GOTO;
import com.benjholla.elemental.elemental.Instruction;
import com.benjholla.elemental.elemental.Label;
import com.benjholla.elemental.elemental.Loop;
import com.benjholla.elemental.elemental.Model;
import com.benjholla.elemental.elemental.StaticDispatch;
import com.benjholla.elemental.services.ElementalGrammarAccess;
import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class ElementalSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private ElementalGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == ElementalPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case ElementalPackage.BLOCK:
				sequence_Block(context, (Block) semanticObject); 
				return; 
			case ElementalPackage.BRANCH:
				sequence_Branch(context, (Branch) semanticObject); 
				return; 
			case ElementalPackage.FUNCTION:
				sequence_Function(context, (Function) semanticObject); 
				return; 
			case ElementalPackage.GOTO:
				sequence_GOTO(context, (GOTO) semanticObject); 
				return; 
			case ElementalPackage.INSTRUCTION:
				sequence_Instruction(context, (Instruction) semanticObject); 
				return; 
			case ElementalPackage.LABEL:
				sequence_Label(context, (Label) semanticObject); 
				return; 
			case ElementalPackage.LOOP:
				sequence_Loop(context, (Loop) semanticObject); 
				return; 
			case ElementalPackage.MODEL:
				sequence_Model(context, (Model) semanticObject); 
				return; 
			case ElementalPackage.STATIC_DISPATCH:
				sequence_StaticDispatch(context, (StaticDispatch) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     Block returns Block
	 *
	 * Constraint:
	 *     instructions+=Instruction*
	 */
	protected void sequence_Block(ISerializationContext context, Block semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Instruction returns Branch
	 *     Branch returns Branch
	 *
	 * Constraint:
	 *     body=Block
	 */
	protected void sequence_Branch(ISerializationContext context, Branch semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ElementalPackage.Literals.BRANCH__BODY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ElementalPackage.Literals.BRANCH__BODY));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getBranchAccess().getBodyBlockParserRuleCall_2_0(), semanticObject.getBody());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Function returns Function
	 *
	 * Constraint:
	 *     (name=ID body=Block)
	 */
	protected void sequence_Function(ISerializationContext context, Function semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ElementalPackage.Literals.FUNCTION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ElementalPackage.Literals.FUNCTION__NAME));
			if (transientValues.isValueTransient(semanticObject, ElementalPackage.Literals.FUNCTION__BODY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ElementalPackage.Literals.FUNCTION__BODY));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getFunctionAccess().getNameIDTerminalRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getFunctionAccess().getBodyBlockParserRuleCall_2_0(), semanticObject.getBody());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Instruction returns GOTO
	 *     GOTO returns GOTO
	 *
	 * Constraint:
	 *     label=[Label|ID]
	 */
	protected void sequence_GOTO(ISerializationContext context, GOTO semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ElementalPackage.Literals.GOTO__LABEL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ElementalPackage.Literals.GOTO__LABEL));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getGOTOAccess().getLabelLabelIDTerminalRuleCall_1_0_1(), semanticObject.eGet(ElementalPackage.Literals.GOTO__LABEL, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Instruction returns Instruction
	 *
	 * Constraint:
	 *     {Instruction}
	 */
	protected void sequence_Instruction(ISerializationContext context, Instruction semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Label returns Label
	 *
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_Label(ISerializationContext context, Label semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ElementalPackage.Literals.LABEL__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ElementalPackage.Literals.LABEL__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLabelAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Instruction returns Loop
	 *     Loop returns Loop
	 *
	 * Constraint:
	 *     body=Block
	 */
	protected void sequence_Loop(ISerializationContext context, Loop semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ElementalPackage.Literals.LOOP__BODY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ElementalPackage.Literals.LOOP__BODY));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLoopAccess().getBodyBlockParserRuleCall_2_0(), semanticObject.getBody());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Model returns Model
	 *
	 * Constraint:
	 *     (implicitFunction=Block explicitFunctions+=Function*)
	 */
	protected void sequence_Model(ISerializationContext context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Instruction returns StaticDispatch
	 *     StaticDispatch returns StaticDispatch
	 *
	 * Constraint:
	 *     target=[Function|ID]
	 */
	protected void sequence_StaticDispatch(ISerializationContext context, StaticDispatch semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ElementalPackage.Literals.STATIC_DISPATCH__TARGET) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ElementalPackage.Literals.STATIC_DISPATCH__TARGET));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getStaticDispatchAccess().getTargetFunctionIDTerminalRuleCall_1_0_1(), semanticObject.eGet(ElementalPackage.Literals.STATIC_DISPATCH__TARGET, false));
		feeder.finish();
	}
	
	
}