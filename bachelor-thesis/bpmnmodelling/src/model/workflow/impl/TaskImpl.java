/**
 */
package model.workflow.impl;

import java.util.Collection;
import model.workflow.InformationObject;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import model.workflow.Task;
import model.workflow.WorkflowPackage;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link model.workflow.impl.TaskImpl#getPreTasks <em>Pre Tasks</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TaskImpl extends InformationObjectImpl implements Task {
	/**
	 * The cached value of the '{@link #getPreTasks() <em>Pre Tasks</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreTasks()
	 * @generated
	 * @ordered
	 */
	protected EList<InformationObject> preTasks;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkflowPackage.Literals.TASK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InformationObject> getPreTasks() {
		if (preTasks == null) {
			preTasks = new EObjectResolvingEList<InformationObject>(InformationObject.class, this, WorkflowPackage.TASK__PRE_TASKS);
		}
		return preTasks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorkflowPackage.TASK__PRE_TASKS:
				return getPreTasks();
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
			case WorkflowPackage.TASK__PRE_TASKS:
				getPreTasks().clear();
				getPreTasks().addAll((Collection<? extends InformationObject>)newValue);
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
			case WorkflowPackage.TASK__PRE_TASKS:
				getPreTasks().clear();
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
			case WorkflowPackage.TASK__PRE_TASKS:
				return preTasks != null && !preTasks.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TaskImpl
