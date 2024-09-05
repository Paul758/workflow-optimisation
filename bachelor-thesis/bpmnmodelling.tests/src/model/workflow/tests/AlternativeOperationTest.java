/**
 */
package model.workflow.tests;

import junit.textui.TestRunner;

import model.workflow.AlternativeOperation;
import model.workflow.WorkflowFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Alternative Operation</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AlternativeOperationTest extends NamedElementTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AlternativeOperationTest.class);
	}

	/**
	 * Constructs a new Alternative Operation test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlternativeOperationTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Alternative Operation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected AlternativeOperation getFixture() {
		return (AlternativeOperation)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(WorkflowFactory.eINSTANCE.createAlternativeOperation());
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

} //AlternativeOperationTest
