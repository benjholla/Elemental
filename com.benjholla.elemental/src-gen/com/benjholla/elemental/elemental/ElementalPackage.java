/**
 * generated by Xtext 2.16.0
 */
package com.benjholla.elemental.elemental;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.benjholla.elemental.elemental.ElementalFactory
 * @model kind="package"
 * @generated
 */
public interface ElementalPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "elemental";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.benjholla.com/elemental/Elemental";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "elemental";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ElementalPackage eINSTANCE = com.benjholla.elemental.elemental.impl.ElementalPackageImpl.init();

  /**
   * The meta object id for the '{@link com.benjholla.elemental.elemental.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.benjholla.elemental.elemental.impl.ModelImpl
   * @see com.benjholla.elemental.elemental.impl.ElementalPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Implicit Function</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__IMPLICIT_FUNCTION = 0;

  /**
   * The feature id for the '<em><b>Explicit Functions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__EXPLICIT_FUNCTIONS = 1;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.benjholla.elemental.elemental.impl.BlockImpl <em>Block</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.benjholla.elemental.elemental.impl.BlockImpl
   * @see com.benjholla.elemental.elemental.impl.ElementalPackageImpl#getBlock()
   * @generated
   */
  int BLOCK = 1;

  /**
   * The feature id for the '<em><b>Instructions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK__INSTRUCTIONS = 0;

  /**
   * The number of structural features of the '<em>Block</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.benjholla.elemental.elemental.impl.LabelImpl <em>Label</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.benjholla.elemental.elemental.impl.LabelImpl
   * @see com.benjholla.elemental.elemental.impl.ElementalPackageImpl#getLabel()
   * @generated
   */
  int LABEL = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LABEL__NAME = 0;

  /**
   * The number of structural features of the '<em>Label</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LABEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.benjholla.elemental.elemental.impl.FunctionImpl <em>Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.benjholla.elemental.elemental.impl.FunctionImpl
   * @see com.benjholla.elemental.elemental.impl.ElementalPackageImpl#getFunction()
   * @generated
   */
  int FUNCTION = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION__NAME = 0;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION__BODY = 1;

  /**
   * The number of structural features of the '<em>Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.benjholla.elemental.elemental.impl.InstructionImpl <em>Instruction</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.benjholla.elemental.elemental.impl.InstructionImpl
   * @see com.benjholla.elemental.elemental.impl.ElementalPackageImpl#getInstruction()
   * @generated
   */
  int INSTRUCTION = 4;

  /**
   * The number of structural features of the '<em>Instruction</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTRUCTION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.benjholla.elemental.elemental.impl.BranchImpl <em>Branch</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.benjholla.elemental.elemental.impl.BranchImpl
   * @see com.benjholla.elemental.elemental.impl.ElementalPackageImpl#getBranch()
   * @generated
   */
  int BRANCH = 5;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BRANCH__BODY = INSTRUCTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Branch</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BRANCH_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.benjholla.elemental.elemental.impl.LoopImpl <em>Loop</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.benjholla.elemental.elemental.impl.LoopImpl
   * @see com.benjholla.elemental.elemental.impl.ElementalPackageImpl#getLoop()
   * @generated
   */
  int LOOP = 6;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP__BODY = INSTRUCTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Loop</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOOP_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.benjholla.elemental.elemental.impl.GOTOImpl <em>GOTO</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.benjholla.elemental.elemental.impl.GOTOImpl
   * @see com.benjholla.elemental.elemental.impl.ElementalPackageImpl#getGOTO()
   * @generated
   */
  int GOTO = 7;

  /**
   * The feature id for the '<em><b>Label</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOTO__LABEL = INSTRUCTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>GOTO</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOTO_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.benjholla.elemental.elemental.impl.StaticDispatchImpl <em>Static Dispatch</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.benjholla.elemental.elemental.impl.StaticDispatchImpl
   * @see com.benjholla.elemental.elemental.impl.ElementalPackageImpl#getStaticDispatch()
   * @generated
   */
  int STATIC_DISPATCH = 8;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATIC_DISPATCH__TARGET = INSTRUCTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Static Dispatch</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATIC_DISPATCH_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link com.benjholla.elemental.elemental.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see com.benjholla.elemental.elemental.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference '{@link com.benjholla.elemental.elemental.Model#getImplicitFunction <em>Implicit Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Implicit Function</em>'.
   * @see com.benjholla.elemental.elemental.Model#getImplicitFunction()
   * @see #getModel()
   * @generated
   */
  EReference getModel_ImplicitFunction();

  /**
   * Returns the meta object for the containment reference list '{@link com.benjholla.elemental.elemental.Model#getExplicitFunctions <em>Explicit Functions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Explicit Functions</em>'.
   * @see com.benjholla.elemental.elemental.Model#getExplicitFunctions()
   * @see #getModel()
   * @generated
   */
  EReference getModel_ExplicitFunctions();

  /**
   * Returns the meta object for class '{@link com.benjholla.elemental.elemental.Block <em>Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Block</em>'.
   * @see com.benjholla.elemental.elemental.Block
   * @generated
   */
  EClass getBlock();

  /**
   * Returns the meta object for the containment reference list '{@link com.benjholla.elemental.elemental.Block#getInstructions <em>Instructions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Instructions</em>'.
   * @see com.benjholla.elemental.elemental.Block#getInstructions()
   * @see #getBlock()
   * @generated
   */
  EReference getBlock_Instructions();

  /**
   * Returns the meta object for class '{@link com.benjholla.elemental.elemental.Label <em>Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Label</em>'.
   * @see com.benjholla.elemental.elemental.Label
   * @generated
   */
  EClass getLabel();

  /**
   * Returns the meta object for the attribute '{@link com.benjholla.elemental.elemental.Label#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.benjholla.elemental.elemental.Label#getName()
   * @see #getLabel()
   * @generated
   */
  EAttribute getLabel_Name();

  /**
   * Returns the meta object for class '{@link com.benjholla.elemental.elemental.Function <em>Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function</em>'.
   * @see com.benjholla.elemental.elemental.Function
   * @generated
   */
  EClass getFunction();

  /**
   * Returns the meta object for the attribute '{@link com.benjholla.elemental.elemental.Function#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.benjholla.elemental.elemental.Function#getName()
   * @see #getFunction()
   * @generated
   */
  EAttribute getFunction_Name();

  /**
   * Returns the meta object for the containment reference '{@link com.benjholla.elemental.elemental.Function#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see com.benjholla.elemental.elemental.Function#getBody()
   * @see #getFunction()
   * @generated
   */
  EReference getFunction_Body();

  /**
   * Returns the meta object for class '{@link com.benjholla.elemental.elemental.Instruction <em>Instruction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Instruction</em>'.
   * @see com.benjholla.elemental.elemental.Instruction
   * @generated
   */
  EClass getInstruction();

  /**
   * Returns the meta object for class '{@link com.benjholla.elemental.elemental.Branch <em>Branch</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Branch</em>'.
   * @see com.benjholla.elemental.elemental.Branch
   * @generated
   */
  EClass getBranch();

  /**
   * Returns the meta object for the containment reference '{@link com.benjholla.elemental.elemental.Branch#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see com.benjholla.elemental.elemental.Branch#getBody()
   * @see #getBranch()
   * @generated
   */
  EReference getBranch_Body();

  /**
   * Returns the meta object for class '{@link com.benjholla.elemental.elemental.Loop <em>Loop</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Loop</em>'.
   * @see com.benjholla.elemental.elemental.Loop
   * @generated
   */
  EClass getLoop();

  /**
   * Returns the meta object for the containment reference '{@link com.benjholla.elemental.elemental.Loop#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see com.benjholla.elemental.elemental.Loop#getBody()
   * @see #getLoop()
   * @generated
   */
  EReference getLoop_Body();

  /**
   * Returns the meta object for class '{@link com.benjholla.elemental.elemental.GOTO <em>GOTO</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>GOTO</em>'.
   * @see com.benjholla.elemental.elemental.GOTO
   * @generated
   */
  EClass getGOTO();

  /**
   * Returns the meta object for the reference '{@link com.benjholla.elemental.elemental.GOTO#getLabel <em>Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Label</em>'.
   * @see com.benjholla.elemental.elemental.GOTO#getLabel()
   * @see #getGOTO()
   * @generated
   */
  EReference getGOTO_Label();

  /**
   * Returns the meta object for class '{@link com.benjholla.elemental.elemental.StaticDispatch <em>Static Dispatch</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Static Dispatch</em>'.
   * @see com.benjholla.elemental.elemental.StaticDispatch
   * @generated
   */
  EClass getStaticDispatch();

  /**
   * Returns the meta object for the reference '{@link com.benjholla.elemental.elemental.StaticDispatch#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see com.benjholla.elemental.elemental.StaticDispatch#getTarget()
   * @see #getStaticDispatch()
   * @generated
   */
  EReference getStaticDispatch_Target();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ElementalFactory getElementalFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link com.benjholla.elemental.elemental.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.benjholla.elemental.elemental.impl.ModelImpl
     * @see com.benjholla.elemental.elemental.impl.ElementalPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Implicit Function</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__IMPLICIT_FUNCTION = eINSTANCE.getModel_ImplicitFunction();

    /**
     * The meta object literal for the '<em><b>Explicit Functions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__EXPLICIT_FUNCTIONS = eINSTANCE.getModel_ExplicitFunctions();

    /**
     * The meta object literal for the '{@link com.benjholla.elemental.elemental.impl.BlockImpl <em>Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.benjholla.elemental.elemental.impl.BlockImpl
     * @see com.benjholla.elemental.elemental.impl.ElementalPackageImpl#getBlock()
     * @generated
     */
    EClass BLOCK = eINSTANCE.getBlock();

    /**
     * The meta object literal for the '<em><b>Instructions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BLOCK__INSTRUCTIONS = eINSTANCE.getBlock_Instructions();

    /**
     * The meta object literal for the '{@link com.benjholla.elemental.elemental.impl.LabelImpl <em>Label</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.benjholla.elemental.elemental.impl.LabelImpl
     * @see com.benjholla.elemental.elemental.impl.ElementalPackageImpl#getLabel()
     * @generated
     */
    EClass LABEL = eINSTANCE.getLabel();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LABEL__NAME = eINSTANCE.getLabel_Name();

    /**
     * The meta object literal for the '{@link com.benjholla.elemental.elemental.impl.FunctionImpl <em>Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.benjholla.elemental.elemental.impl.FunctionImpl
     * @see com.benjholla.elemental.elemental.impl.ElementalPackageImpl#getFunction()
     * @generated
     */
    EClass FUNCTION = eINSTANCE.getFunction();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FUNCTION__NAME = eINSTANCE.getFunction_Name();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION__BODY = eINSTANCE.getFunction_Body();

    /**
     * The meta object literal for the '{@link com.benjholla.elemental.elemental.impl.InstructionImpl <em>Instruction</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.benjholla.elemental.elemental.impl.InstructionImpl
     * @see com.benjholla.elemental.elemental.impl.ElementalPackageImpl#getInstruction()
     * @generated
     */
    EClass INSTRUCTION = eINSTANCE.getInstruction();

    /**
     * The meta object literal for the '{@link com.benjholla.elemental.elemental.impl.BranchImpl <em>Branch</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.benjholla.elemental.elemental.impl.BranchImpl
     * @see com.benjholla.elemental.elemental.impl.ElementalPackageImpl#getBranch()
     * @generated
     */
    EClass BRANCH = eINSTANCE.getBranch();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BRANCH__BODY = eINSTANCE.getBranch_Body();

    /**
     * The meta object literal for the '{@link com.benjholla.elemental.elemental.impl.LoopImpl <em>Loop</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.benjholla.elemental.elemental.impl.LoopImpl
     * @see com.benjholla.elemental.elemental.impl.ElementalPackageImpl#getLoop()
     * @generated
     */
    EClass LOOP = eINSTANCE.getLoop();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOOP__BODY = eINSTANCE.getLoop_Body();

    /**
     * The meta object literal for the '{@link com.benjholla.elemental.elemental.impl.GOTOImpl <em>GOTO</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.benjholla.elemental.elemental.impl.GOTOImpl
     * @see com.benjholla.elemental.elemental.impl.ElementalPackageImpl#getGOTO()
     * @generated
     */
    EClass GOTO = eINSTANCE.getGOTO();

    /**
     * The meta object literal for the '<em><b>Label</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GOTO__LABEL = eINSTANCE.getGOTO_Label();

    /**
     * The meta object literal for the '{@link com.benjholla.elemental.elemental.impl.StaticDispatchImpl <em>Static Dispatch</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.benjholla.elemental.elemental.impl.StaticDispatchImpl
     * @see com.benjholla.elemental.elemental.impl.ElementalPackageImpl#getStaticDispatch()
     * @generated
     */
    EClass STATIC_DISPATCH = eINSTANCE.getStaticDispatch();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATIC_DISPATCH__TARGET = eINSTANCE.getStaticDispatch_Target();

  }

} //ElementalPackage
