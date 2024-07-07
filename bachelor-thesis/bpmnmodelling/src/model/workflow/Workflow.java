/**
 */
package model.workflow;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Workflow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link model.workflow.Workflow#getInformationObjects <em>Information Objects</em>}</li>
 *   <li>{@link model.workflow.Workflow#getActivities <em>Activities</em>}</li>
 * </ul>
 *
 * @see model.workflow.WorkflowPackage#getWorkflow()
 * @model
 * @generated
 */
public interface Workflow extends EObject {
	/**
	 * Returns the value of the '<em><b>Information Objects</b></em>' containment reference list.
	 * The list contents are of type {@link model.workflow.InformationObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Information Objects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Information Objects</em>' containment reference list.
	 * @see model.workflow.WorkflowPackage#getWorkflow_InformationObjects()
	 * @model containment="true"
	 * @generated
	 */
	EList<InformationObject> getInformationObjects();

	/**
	 * Returns the value of the '<em><b>Activities</b></em>' containment reference list.
	 * The list contents are of type {@link model.workflow.Activity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Activities</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Activities</em>' containment reference list.
	 * @see model.workflow.WorkflowPackage#getWorkflow_Activities()
	 * @model containment="true"
	 * @generated
	 */
	EList<Activity> getActivities();

} // Workflow
