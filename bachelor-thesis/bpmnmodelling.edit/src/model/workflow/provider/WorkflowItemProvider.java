/**
 */
package model.workflow.provider;


import java.util.Collection;
import java.util.List;

import model.workflow.Workflow;
import model.workflow.WorkflowFactory;
import model.workflow.WorkflowPackage;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

<<<<<<< HEAD
=======
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
>>>>>>> refactorProcessCohesion
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link model.workflow.Workflow} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class WorkflowItemProvider 
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkflowItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

<<<<<<< HEAD
=======
			addAlternativeOperationsPropertyDescriptor(object);
>>>>>>> refactorProcessCohesion
		}
		return itemPropertyDescriptors;
	}

	/**
<<<<<<< HEAD
=======
	 * This adds a property descriptor for the Alternative Operations feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAlternativeOperationsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Workflow_alternativeOperations_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Workflow_alternativeOperations_feature", "_UI_Workflow_type"),
				 WorkflowPackage.Literals.WORKFLOW__ALTERNATIVE_OPERATIONS,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
>>>>>>> refactorProcessCohesion
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(WorkflowPackage.Literals.WORKFLOW__INFORMATION_OBJECTS);
			childrenFeatures.add(WorkflowPackage.Literals.WORKFLOW__ACTIVITIES);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Workflow.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Workflow"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_Workflow_type");
	}


	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Workflow.class)) {
			case WorkflowPackage.WORKFLOW__INFORMATION_OBJECTS:
			case WorkflowPackage.WORKFLOW__ACTIVITIES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(WorkflowPackage.Literals.WORKFLOW__INFORMATION_OBJECTS,
				 WorkflowFactory.eINSTANCE.createTask()));

		newChildDescriptors.add
			(createChildParameter
				(WorkflowPackage.Literals.WORKFLOW__INFORMATION_OBJECTS,
<<<<<<< HEAD
				 WorkflowFactory.eINSTANCE.createParallel()));

		newChildDescriptors.add
			(createChildParameter
				(WorkflowPackage.Literals.WORKFLOW__INFORMATION_OBJECTS,
				 WorkflowFactory.eINSTANCE.createExclusive()));
=======
				 WorkflowFactory.eINSTANCE.createExclusiveTask()));
>>>>>>> refactorProcessCohesion

		newChildDescriptors.add
			(createChildParameter
				(WorkflowPackage.Literals.WORKFLOW__ACTIVITIES,
				 WorkflowFactory.eINSTANCE.createActivity()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return WorkflowEditPlugin.INSTANCE;
	}

}
