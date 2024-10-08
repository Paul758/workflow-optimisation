/**
 */
package model.workflow;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Activity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link model.workflow.Activity#getEncapsulates <em>Encapsulates</em>}</li>
 * </ul>
 *
 * @see model.workflow.WorkflowPackage#getActivity()
 * @model
 * @generated
 */
public interface Activity extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Encapsulates</b></em>' reference list.
	 * The list contents are of type {@link model.workflow.InformationObject}.
	 * It is bidirectional and its opposite is '{@link model.workflow.InformationObject#getIsEncapsulatedBy <em>Is Encapsulated By</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Encapsulates</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Encapsulates</em>' reference list.
	 * @see model.workflow.WorkflowPackage#getActivity_Encapsulates()
	 * @see model.workflow.InformationObject#getIsEncapsulatedBy
	 * @model opposite="isEncapsulatedBy"
	 * @generated
	 */
	EList<InformationObject> getEncapsulates();

} // Activity
