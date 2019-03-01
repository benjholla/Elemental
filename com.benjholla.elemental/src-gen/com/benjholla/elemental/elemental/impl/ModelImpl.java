/**
 * generated by Xtext 2.16.0
 */
package com.benjholla.elemental.elemental.impl;

import com.benjholla.elemental.elemental.Block;
import com.benjholla.elemental.elemental.ElementalPackage;
import com.benjholla.elemental.elemental.Function;
import com.benjholla.elemental.elemental.Model;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.benjholla.elemental.elemental.impl.ModelImpl#getImplicitFunction <em>Implicit Function</em>}</li>
 *   <li>{@link com.benjholla.elemental.elemental.impl.ModelImpl#getExplicitFunctions <em>Explicit Functions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model
{
  /**
   * The cached value of the '{@link #getImplicitFunction() <em>Implicit Function</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImplicitFunction()
   * @generated
   * @ordered
   */
  protected Block implicitFunction;

  /**
   * The cached value of the '{@link #getExplicitFunctions() <em>Explicit Functions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExplicitFunctions()
   * @generated
   * @ordered
   */
  protected EList<Function> explicitFunctions;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModelImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ElementalPackage.Literals.MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Block getImplicitFunction()
  {
    return implicitFunction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetImplicitFunction(Block newImplicitFunction, NotificationChain msgs)
  {
    Block oldImplicitFunction = implicitFunction;
    implicitFunction = newImplicitFunction;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ElementalPackage.MODEL__IMPLICIT_FUNCTION, oldImplicitFunction, newImplicitFunction);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setImplicitFunction(Block newImplicitFunction)
  {
    if (newImplicitFunction != implicitFunction)
    {
      NotificationChain msgs = null;
      if (implicitFunction != null)
        msgs = ((InternalEObject)implicitFunction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ElementalPackage.MODEL__IMPLICIT_FUNCTION, null, msgs);
      if (newImplicitFunction != null)
        msgs = ((InternalEObject)newImplicitFunction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ElementalPackage.MODEL__IMPLICIT_FUNCTION, null, msgs);
      msgs = basicSetImplicitFunction(newImplicitFunction, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ElementalPackage.MODEL__IMPLICIT_FUNCTION, newImplicitFunction, newImplicitFunction));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Function> getExplicitFunctions()
  {
    if (explicitFunctions == null)
    {
      explicitFunctions = new EObjectContainmentEList<Function>(Function.class, this, ElementalPackage.MODEL__EXPLICIT_FUNCTIONS);
    }
    return explicitFunctions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ElementalPackage.MODEL__IMPLICIT_FUNCTION:
        return basicSetImplicitFunction(null, msgs);
      case ElementalPackage.MODEL__EXPLICIT_FUNCTIONS:
        return ((InternalEList<?>)getExplicitFunctions()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ElementalPackage.MODEL__IMPLICIT_FUNCTION:
        return getImplicitFunction();
      case ElementalPackage.MODEL__EXPLICIT_FUNCTIONS:
        return getExplicitFunctions();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ElementalPackage.MODEL__IMPLICIT_FUNCTION:
        setImplicitFunction((Block)newValue);
        return;
      case ElementalPackage.MODEL__EXPLICIT_FUNCTIONS:
        getExplicitFunctions().clear();
        getExplicitFunctions().addAll((Collection<? extends Function>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ElementalPackage.MODEL__IMPLICIT_FUNCTION:
        setImplicitFunction((Block)null);
        return;
      case ElementalPackage.MODEL__EXPLICIT_FUNCTIONS:
        getExplicitFunctions().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ElementalPackage.MODEL__IMPLICIT_FUNCTION:
        return implicitFunction != null;
      case ElementalPackage.MODEL__EXPLICIT_FUNCTIONS:
        return explicitFunctions != null && !explicitFunctions.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ModelImpl
