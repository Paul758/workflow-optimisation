package model.workflow.fitness.informationcohesion;

import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;
import model.workflow.Activity;
import model.workflow.AlternativeOperation;
import model.workflow.Task;
import model.workflow.Workflow;
import model.workflow.WorkflowFactory;


class ActivityInformationCohesionTest {

	ActivityInformationCohesion activityInformationCohesion = new ActivityInformationCohesion();
	
	Workflow workflow;
	Activity activity1;
	Activity activity2;
	Activity activity3;

	Task task1;
	Task task2;
	Task task3;
	Task task7;
	Task task9;
	Task task10;
	Task task11;
	Task task12;
	Task task13;
	Task task14;
	Task task15;
	Task task16;
	Task task17;
	Task task20;
	Task task21;
	Task task24;
	
	@Test
	void testActivityInformationCohesion() throws Exception {
		WorkflowFactory factory = WorkflowFactory.eINSTANCE;
		
		workflow = factory.createWorkflow();
		
		activity1 = factory.createActivity();
		activity1.setName("1");
		
		task1 = factory.createTask();
		task1.setName("1");
		
		task2 = factory.createTask();
		task2.setName("2");
		
		task3 = factory.createTask();
		task3.setName("3");
		
		task10 = factory.createTask();
		task10.setName("10");
		
		//Setup activity 1
		activity1.getEncapsulates().add(task1);
		activity1.getEncapsulates().add(task2);
		activity1.getEncapsulates().add(task3);
		
		task1.getSink().add(task3);
		task2.getSink().add(task3);
		
		task3.getSource().add(task1);
		task3.getSource().add(task2);
		task3.getSink().add(task10);
		
		workflow.getActivities().add(activity1);
		
		double aicValue = 0;
		
		Method method = ActivityInformationCohesion.class.getDeclaredMethod("calculateActivityInformationCohesion", Activity.class);
		method.setAccessible(true);
		aicValue = (double) method.invoke(activityInformationCohesion, activity1);
		
		System.out.println("AIC is: " + aicValue);
		double result = 0;
		assertEquals(result, aicValue);
		
	}
	
	@Test
	void testActivityInformationCohesion2() throws Exception {
		WorkflowFactory factory = WorkflowFactory.eINSTANCE;
		
		workflow = factory.createWorkflow();
		
		activity2 = factory.createActivity();
		activity2.setName("2");
		
		task3 = factory.createTask();
		task3.setName("3");
		
		task9 = factory.createTask();
		task9.setName("9");
		
		task10 = factory.createTask();
		task10.setName("10");
		
		task11 = factory.createTask();
		task11.setName("11");
		
		task13 = factory.createTask();
		task13.setName("13");
		
		task14 = factory.createTask();
		task14.setName("14");
		
		task15 = factory.createTask();
		task15.setName("15");
		
		activity2.getEncapsulates().add(task9);
		activity2.getEncapsulates().add(task10);
		activity2.getEncapsulates().add(task11);
		activity2.getEncapsulates().add(task13);
		activity2.getEncapsulates().add(task14);
		activity2.getEncapsulates().add(task15);
		
		task10.getSource().add(task3);
		task10.getSink().add(task13);
		task10.getSink().add(task14);
		
		task9.getSink().add(task13);
		task11.getSink().add(task14);
		
		task13.getSource().add(task9);
		task13.getSource().add(task10);
		task13.getSink().add(task15);
		
		task14.getSource().add(task10);
		task14.getSource().add(task11);
		task14.getSink().add(task15);
		
		task15.getSource().add(task13);
		task15.getSource().add(task14);
		
		workflow.getActivities().add(activity2);
		
		double aicValue = 0;
		
		Method method = ActivityInformationCohesion.class.getDeclaredMethod("calculateActivityInformationCohesion", Activity.class);
		method.setAccessible(true);
		aicValue = (double) method.invoke(activityInformationCohesion, activity2);
		
		
		System.out.println("AIC is: " + aicValue);
		double result = 0.5;
		assertEquals(result, aicValue);
		
	}
	
	@Test
	void testActivityInformationCohesionEmptyActivity() throws Exception {
		WorkflowFactory factory = WorkflowFactory.eINSTANCE;
		
		workflow = factory.createWorkflow();
		
		activity3 = factory.createActivity();
		activity3.setName("3");
		
		
		double aicValue = 0;
		
		Method method = ActivityInformationCohesion.class.getDeclaredMethod("calculateActivityInformationCohesion", Activity.class);
		method.setAccessible(true);
		aicValue = (double) method.invoke(activityInformationCohesion, activity3);
		
		
		System.out.println("AIC is: " + aicValue);
		double result = 0;
		assertEquals(result, aicValue);
		
	}
	
	@Test
	void testActivityInformationCohesionAlternativePaths() throws Exception {
		WorkflowFactory factory = WorkflowFactory.eINSTANCE;
		
		workflow = factory.createWorkflow();
		
		activity1 = factory.createActivity();
		activity1.setName("1");
		
		task3 = factory.createTask();
		task3.setName("3");
		
		task7 = factory.createTask();
		task7.setName("7");
		
		task12 = factory.createTask();
		task12.setName("12");
		
		task13 = factory.createTask();
		task13.setName("13");
		
		task14 = factory.createTask();
		task14.setName("14");
		
		task15 = factory.createTask();
		task15.setName("15");
		
		task16 = factory.createTask();
		task16.setName("16");
		
		task17 = factory.createTask();
		task17.setName("17");
		
		
		task20 = factory.createTask();
		task20.setName("20");
		
		task21 = factory.createTask();
		task21.setName("21");
		
		task24 = factory.createTask();
		task24.setName("24");
		
		activity1.getEncapsulates().add(task15);
		activity1.getEncapsulates().add(task16);
		activity1.getEncapsulates().add(task20);
		activity1.getEncapsulates().add(task21);
		activity1.getEncapsulates().add(task24);
		
		task15.getSource().add(task13);
		task15.getSource().add(task14);
		
		task15.getSink().add(task16);
		
		
		task16.getSource().add(task15);
		task16.getSource().add(task12);
		task16.getSource().add(task7);
		
		task16.getSink().add(task21);
		task16.getSink().add(task24);
		
		
		task20.getSource().add(task3);
		task20.getSource().add(task17);
		
		task20.getSink().add(task24);
		
		
		task21.getSource().add(task15);
		task21.getSource().add(task16);
		task21.getSink().add(task24);
		
		AlternativeOperation altOperation1 = factory.createAlternativeOperation();
		altOperation1.getInputTasks().add(task16);
		AlternativeOperation altOperation2 = factory.createAlternativeOperation();
		altOperation2.getInputTasks().add(task20);
		altOperation2.getInputTasks().add(task21);
		
		task24.getAlternativePaths().add(altOperation1);
		task24.getAlternativePaths().add(altOperation2);
		
		task24.getSource().add(task16);
		task24.getSource().add(task20);
		task24.getSource().add(task21);
		
		workflow.getActivities().add(activity1);
		
		double aicValue = 0;
		
		Method method = ActivityInformationCohesion.class.getDeclaredMethod("calculateActivityInformationCohesion", Activity.class);
		method.setAccessible(true);
		aicValue = (double) method.invoke(activityInformationCohesion, activity1);
		
		
		System.out.println("AIC is: " + aicValue);
		double result = 4.0d / 5.0d;
		assertEquals(result, aicValue);
		
	}
}
