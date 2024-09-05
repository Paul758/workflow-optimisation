/**
 */
package model.workflow.impl;

import java.util.Collection;
import model.workflow.AlternativeOperation;
import model.workflow.Task;
import model.workflow.WorkflowPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Alternative Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link model.workflow.impl.AlternativeOperationImpl#getInputTasks <em>Input Tasks</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AlternativeOperationImpl extends NamedElementImpl implements AlternativeOperation {
	/**
	 * The cached value of the '{@link #getInputTasks() <em>Input Tasks</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputTasks()
	 * @generated
	 * @ordered
	 */
	protected EList<Task> inputTasks;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AlternativeOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkflowPackage.Literals.ALTERNATIVE_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Task> getInputTasks() {
		if (inputTasks == null) {
			inputTasks = new EObjectResolvingEList<Task>(Task.class, this, WorkflowPackage.ALTERNATIVE_OPERATION__INPUT_TASKS);
		}
		return inputTasks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorkflowPackage.ALTERNATIVE_OPERATION__INPUT_TASKS:
				return getInputTasks();
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
			case WorkflowPackage.ALTERNATIVE_OPERATION__INPUT_TASKS:
				getInputTasks().clear();
				getInputTasks().addAll((Collection<? extends Task>)newValue);
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
			case WorkflowPackage.ALTERNATIVE_OPERATION__INPUT_TASKS:
				getInputTasks().clear();
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
			case WorkflowPackage.ALTERNATIVE_OPERATION__INPUT_TASKS:
				return inputTasks != null && !inputTasks.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AlternativeOperationImpl
