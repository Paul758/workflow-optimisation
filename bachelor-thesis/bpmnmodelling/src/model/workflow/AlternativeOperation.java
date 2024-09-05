/**
 */
package model.workflow;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Alternative Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link model.workflow.AlternativeOperation#getInputTasks <em>Input Tasks</em>}</li>
 * </ul>
 *
 * @see model.workflow.WorkflowPackage#getAlternativeOperation()
 * @model
 * @generated
 */
public interface AlternativeOperation extends NamedElement {

	/**
	 * Returns the value of the '<em><b>Input Tasks</b></em>' reference list.
	 * The list contents are of type {@link model.workflow.Task}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Tasks</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Tasks</em>' reference list.
	 * @see model.workflow.WorkflowPackage#getAlternativeOperation_InputTasks()
	 * @model
	 * @generated
	 */
	EList<Task> getInputTasks();

} // AlternativeOperation
