/**
 */
package model.workflow;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link model.workflow.Task#getPreTasks <em>Pre Tasks</em>}</li>
 * </ul>
 *
 * @see model.workflow.WorkflowPackage#getTask()
 * @model
 * @generated
 */
public interface Task extends InformationObject {

	/**
	 * Returns the value of the '<em><b>Pre Tasks</b></em>' reference list.
	 * The list contents are of type {@link model.workflow.InformationObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pre Tasks</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pre Tasks</em>' reference list.
	 * @see model.workflow.WorkflowPackage#getTask_PreTasks()
	 * @model
	 * @generated
	 */
	EList<InformationObject> getPreTasks();
} // Task
