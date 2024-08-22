/**
 */
package model.workflow.impl;

import java.util.Collection;
import model.workflow.AlternativeOperation;
import model.workflow.ExclusiveTask;
import model.workflow.WorkflowPackage;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Exclusive Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link model.workflow.impl.ExclusiveTaskImpl#getAlternativePaths <em>Alternative Paths</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExclusiveTaskImpl extends InformationObjectImpl implements ExclusiveTask {
	/**
	 * The cached value of the '{@link #getAlternativePaths() <em>Alternative Paths</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlternativePaths()
	 * @generated
	 * @ordered
	 */
	protected EList<AlternativeOperation> alternativePaths;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExclusiveTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkflowPackage.Literals.EXCLUSIVE_TASK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AlternativeOperation> getAlternativePaths() {
		if (alternativePaths == null) {
			alternativePaths = new EObjectContainmentEList<AlternativeOperation>(AlternativeOperation.class, this, WorkflowPackage.EXCLUSIVE_TASK__ALTERNATIVE_PATHS);
		}
		return alternativePaths;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkflowPackage.EXCLUSIVE_TASK__ALTERNATIVE_PATHS:
				return ((InternalEList<?>)getAlternativePaths()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorkflowPackage.EXCLUSIVE_TASK__ALTERNATIVE_PATHS:
				return getAlternativePaths();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WorkflowPackage.EXCLUSIVE_TASK__ALTERNATIVE_PATHS:
				getAlternativePaths().clear();
				getAlternativePaths().addAll((Collection<? extends AlternativeOperation>)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case WorkflowPackage.EXCLUSIVE_TASK__ALTERNATIVE_PATHS:
				getAlternativePaths().clear();
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case WorkflowPackage.EXCLUSIVE_TASK__ALTERNATIVE_PATHS:
				return alternativePaths != null && !alternativePaths.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ExclusiveTaskImpl
