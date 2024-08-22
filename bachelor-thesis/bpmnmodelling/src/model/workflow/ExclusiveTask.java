/**
 */
package model.workflow;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exclusive Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link model.workflow.ExclusiveTask#getAlternativePaths <em>Alternative Paths</em>}</li>
 * </ul>
 *
 * @see model.workflow.WorkflowPackage#getExclusiveTask()
 * @model
 * @generated
 */
public interface ExclusiveTask extends InformationObject {

	/**
	 * Returns the value of the '<em><b>Alternative Paths</b></em>' containment reference list.
	 * The list contents are of type {@link model.workflow.AlternativeOperation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alternative Paths</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alternative Paths</em>' containment reference list.
	 * @see model.workflow.WorkflowPackage#getExclusiveTask_AlternativePaths()
	 * @model containment="true"
	 * @generated
	 */
	EList<AlternativeOperation> getAlternativePaths();

} // ExclusiveTask
