/**
 */
package model.workflow.tests;

import junit.textui.TestRunner;

import model.workflow.Activity;
import model.workflow.WorkflowFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Activity</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ActivityTest extends NamedElementTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ActivityTest.class);
	}

	/**
	 * Constructs a new Activity test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Activity test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Activity getFixture() {
		return (Activity)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(WorkflowFactory.eINSTANCE.createActivity());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //ActivityTest
