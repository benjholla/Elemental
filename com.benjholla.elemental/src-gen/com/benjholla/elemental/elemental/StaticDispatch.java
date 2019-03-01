/**
 * generated by Xtext 2.16.0
 */
package com.benjholla.elemental.elemental;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Static Dispatch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.benjholla.elemental.elemental.StaticDispatch#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see com.benjholla.elemental.elemental.ElementalPackage#getStaticDispatch()
 * @model
 * @generated
 */
public interface StaticDispatch extends Instruction
{
  /**
   * Returns the value of the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' reference.
   * @see #setTarget(Function)
   * @see com.benjholla.elemental.elemental.ElementalPackage#getStaticDispatch_Target()
   * @model
   * @generated
   */
  Function getTarget();

  /**
   * Sets the value of the '{@link com.benjholla.elemental.elemental.StaticDispatch#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(Function value);

} // StaticDispatch