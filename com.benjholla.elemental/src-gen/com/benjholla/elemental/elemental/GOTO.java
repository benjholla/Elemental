/**
 * generated by Xtext 2.16.0
 */
package com.benjholla.elemental.elemental;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>GOTO</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.benjholla.elemental.elemental.GOTO#getLabel <em>Label</em>}</li>
 * </ul>
 *
 * @see com.benjholla.elemental.elemental.ElementalPackage#getGOTO()
 * @model
 * @generated
 */
public interface GOTO extends Instruction
{
  /**
   * Returns the value of the '<em><b>Label</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Label</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Label</em>' reference.
   * @see #setLabel(Label)
   * @see com.benjholla.elemental.elemental.ElementalPackage#getGOTO_Label()
   * @model
   * @generated
   */
  Label getLabel();

  /**
   * Sets the value of the '{@link com.benjholla.elemental.elemental.GOTO#getLabel <em>Label</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Label</em>' reference.
   * @see #getLabel()
   * @generated
   */
  void setLabel(Label value);

} // GOTO