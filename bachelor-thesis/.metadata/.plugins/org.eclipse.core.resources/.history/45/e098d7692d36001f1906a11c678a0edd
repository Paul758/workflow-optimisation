/**
 */
package workflow.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import workflow.Activity;
import workflow.InformationObject;
import workflow.WorkflowPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Information Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link workflow.impl.InformationObjectImpl#getIsEncapsulatedBy <em>Is Encapsulated By</em>}</li>
 *   <li>{@link workflow.impl.InformationObjectImpl#getSource <em>Source</em>}</li>
 *   <li>{@link workflow.impl.InformationObjectImpl#getSink <em>Sink</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class InformationObjectImpl extends NamedElementImpl implements InformationObject {
	/**
	 * The cached value of the '{@link #getIsEncapsulatedBy() <em>Is Encapsulated By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsEncapsulatedBy()
	 * @generated
	 * @ordered
	 */
	protected Activity isEncapsulatedBy;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected EList<InformationObject> source;

	/**
	 * The cached value of the '{@link #getSink() <em>Sink</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSink()
	 * @generated
	 * @ordered
	 */
	protected EList<InformationObject> sink;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InformationObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkflowPackage.Literals.INFORMATION_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity getIsEncapsulatedBy() {
		if (isEncapsulatedBy != null && isEncapsulatedBy.eIsProxy()) {
			InternalEObject oldIsEncapsulatedBy = (InternalEObject)isEncapsulatedBy;
			isEncapsulatedBy = (Activity)eResolveProxy(oldIsEncapsulatedBy);
			if (isEncapsulatedBy != oldIsEncapsulatedBy) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorkflowPackage.INFORMATION_OBJECT__IS_ENCAPSULATED_BY, oldIsEncapsulatedBy, isEncapsulatedBy));
			}
		}
		return isEncapsulatedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity basicGetIsEncapsulatedBy() {
		return isEncapsulatedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIsEncapsulatedBy(Activity newIsEncapsulatedBy, NotificationChain msgs) {
		Activity oldIsEncapsulatedBy = isEncapsulatedBy;
		isEncapsulatedBy = newIsEncapsulatedBy;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.INFORMATION_OBJECT__IS_ENCAPSULATED_BY, oldIsEncapsulatedBy, newIsEncapsulatedBy);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsEncapsulatedBy(Activity newIsEncapsulatedBy) {
		if (newIsEncapsulatedBy != isEncapsulatedBy) {
			NotificationChain msgs = null;
			if (isEncapsulatedBy != null)
				msgs = ((InternalEObject)isEncapsulatedBy).eInverseRemove(this, WorkflowPackage.ACTIVITY__ENCAPSULATES, Activity.class, msgs);
			if (newIsEncapsulatedBy != null)
				msgs = ((InternalEObject)newIsEncapsulatedBy).eInverseAdd(this, WorkflowPackage.ACTIVITY__ENCAPSULATES, Activity.class, msgs);
			msgs = basicSetIsEncapsulatedBy(newIsEncapsulatedBy, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.INFORMATION_OBJECT__IS_ENCAPSULATED_BY, newIsEncapsulatedBy, newIsEncapsulatedBy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InformationObject> getSource() {
		if (source == null) {
			source = new EObjectResolvingEList<InformationObject>(InformationObject.class, this, WorkflowPackage.INFORMATION_OBJECT__SOURCE);
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InformationObject> getSink() {
		if (sink == null) {
			sink = new EObjectResolvingEList<InformationObject>(InformationObject.class, this, WorkflowPackage.INFORMATION_OBJECT__SINK);
		}
		return sink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkflowPackage.INFORMATION_OBJECT__IS_ENCAPSULATED_BY:
				if (isEncapsulatedBy != null)
					msgs = ((InternalEObject)isEncapsulatedBy).eInverseRemove(this, WorkflowPackage.ACTIVITY__ENCAPSULATES, Activity.class, msgs);
				return basicSetIsEncapsulatedBy((Activity)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkflowPackage.INFORMATION_OBJECT__IS_ENCAPSULATED_BY:
				return basicSetIsEncapsulatedBy(null, msgs);
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
			case WorkflowPackage.INFORMATION_OBJECT__IS_ENCAPSULATED_BY:
				if (resolve) return getIsEncapsulatedBy();
				return basicGetIsEncapsulatedBy();
			case WorkflowPackage.INFORMATION_OBJECT__SOURCE:
				return getSource();
			case WorkflowPackage.INFORMATION_OBJECT__SINK:
				return getSink();
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
			case WorkflowPackage.INFORMATION_OBJECT__IS_ENCAPSULATED_BY:
				setIsEncapsulatedBy((Activity)newValue);
				return;
			case WorkflowPackage.INFORMATION_OBJECT__SOURCE:
				getSource().clear();
				getSource().addAll((Collection<? extends InformationObject>)newValue);
				return;
			case WorkflowPackage.INFORMATION_OBJECT__SINK:
				getSink().clear();
				getSink().addAll((Collection<? extends InformationObject>)newValue);
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
			case WorkflowPackage.INFORMATION_OBJECT__IS_ENCAPSULATED_BY:
				setIsEncapsulatedBy((Activity)null);
				return;
			case WorkflowPackage.INFORMATION_OBJECT__SOURCE:
				getSource().clear();
				return;
			case WorkflowPackage.INFORMATION_OBJECT__SINK:
				getSink().clear();
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
			case WorkflowPackage.INFORMATION_OBJECT__IS_ENCAPSULATED_BY:
				return isEncapsulatedBy != null;
			case WorkflowPackage.INFORMATION_OBJECT__SOURCE:
				return source != null && !source.isEmpty();
			case WorkflowPackage.INFORMATION_OBJECT__SINK:
				return sink != null && !sink.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //InformationObjectImpl
