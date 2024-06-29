/**
 */
package workflow;

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
 *   <li>{@link workflow.Activity#getEncapsulates <em>Encapsulates</em>}</li>
 * </ul>
 *
 * @see workflow.WorkflowPackage#getActivity()
 * @model
 * @generated
 */
public interface Activity extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Encapsulates</b></em>' reference list.
	 * The list contents are of type {@link workflow.InformationObject}.
	 * It is bidirectional and its opposite is '{@link workflow.InformationObject#getIsEncapsulatedBy <em>Is Encapsulated By</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Encapsulates</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Encapsulates</em>' reference list.
	 * @see workflow.WorkflowPackage#getActivity_Encapsulates()
	 * @see workflow.InformationObject#getIsEncapsulatedBy
	 * @model opposite="isEncapsulatedBy"
	 * @generated
	 */
	EList<InformationObject> getEncapsulates();

} // Activity
