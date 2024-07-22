/**
 */
package model.workflow;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Information Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link model.workflow.InformationObject#getIsEncapsulatedBy <em>Is Encapsulated By</em>}</li>
 *   <li>{@link model.workflow.InformationObject#getSource <em>Source</em>}</li>
 *   <li>{@link model.workflow.InformationObject#getSink <em>Sink</em>}</li>
 * </ul>
 *
 * @see model.workflow.WorkflowPackage#getInformationObject()
 * @model abstract="true"
 * @generated
 */
public interface InformationObject extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Is Encapsulated By</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link model.workflow.Activity#getEncapsulates <em>Encapsulates</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Encapsulated By</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Encapsulated By</em>' reference.
	 * @see #setIsEncapsulatedBy(Activity)
	 * @see model.workflow.WorkflowPackage#getInformationObject_IsEncapsulatedBy()
	 * @see model.workflow.Activity#getEncapsulates
	 * @model opposite="encapsulates"
	 * @generated
	 */
	Activity getIsEncapsulatedBy();

	/**
	 * Sets the value of the '{@link model.workflow.InformationObject#getIsEncapsulatedBy <em>Is Encapsulated By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Encapsulated By</em>' reference.
	 * @see #getIsEncapsulatedBy()
	 * @generated
	 */
	void setIsEncapsulatedBy(Activity value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference list.
	 * The list contents are of type {@link model.workflow.InformationObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference list.
	 * @see model.workflow.WorkflowPackage#getInformationObject_Source()
	 * @model
	 * @generated
	 */
	EList<InformationObject> getSource();

	/**
	 * Returns the value of the '<em><b>Sink</b></em>' reference list.
	 * The list contents are of type {@link model.workflow.InformationObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sink</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sink</em>' reference list.
	 * @see model.workflow.WorkflowPackage#getInformationObject_Sink()
	 * @model
	 * @generated
	 */
	EList<InformationObject> getSink();

} // InformationObject
