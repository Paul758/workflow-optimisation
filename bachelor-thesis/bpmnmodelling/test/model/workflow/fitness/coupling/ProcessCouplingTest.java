package model.workflow.fitness.coupling;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.workflow.Activity;
import model.workflow.AlternativeOperation;
import model.workflow.Task;
import model.workflow.Workflow;
import model.workflow.WorkflowFactory;
import model.workflow.fitness.relationcohesion.ActivityRelationCohesion;


class ProcessCouplingTest {


	ProcessCoupling processCoupling;
	
	Workflow workflow;
	Activity activity1;
	Activity activity2;
	Activity activity3;
	
	Task task1;
	Task task2;
	Task task3;
	
	Task task9;
	Task task10;
	Task task11;
	Task task13;
	Task task14;
	Task task15;
	
	Task task4;
	Task task5;
	Task task8;
	Task task12;

	Task task7;
	Task task16;
	Task task17;
	Task task20;
	Task task21;
	Task task24;

	private Task task25;
	
	@BeforeEach
	void setUp() {
		processCoupling = new ProcessCoupling();
		
		
		WorkflowFactory factory = WorkflowFactory.eINSTANCE;
		
		workflow = factory.createWorkflow();
		
		activity1 = factory.createActivity();
		activity1.setName("1");
		
		activity2 = factory.createActivity();
		activity2.setName("2");
		
		activity3 = factory.createActivity();
		activity3.setName("3");
		
		task1 = factory.createTask();
		task1.setName("1");
		
		task2 = factory.createTask();
		task2.setName("2");
		
		task3 = factory.createTask();
		task3.setName("3");
		
		task4 = factory.createTask();
		task4.setName("4");
		
		task5 = factory.createTask();
		task5.setName("5");
		
		task8 = factory.createTask();
		task8.setName("8");
		
		task12 = factory.createTask();
		task12.setName("12");
		
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
		
	}
	
	
	
	
	@Test
	void testProcessCoupling() throws Exception {
		//Setup activity 1
				activity1.getEncapsulates().add(task1);
				activity1.getEncapsulates().add(task2);
				activity1.getEncapsulates().add(task3);
				
				task1.getSink().add(task3);
				task2.getSink().add(task3);
				
				task3.getSource().add(task1);
				task3.getSource().add(task2);
				task3.getSink().add(task10);
				
				//Setup activity 2
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
				
				
				workflow.getActivities().add(activity1);
				workflow.getActivities().add(activity2);
			
				
				double processCouplingValue = 0;
				
				
				Method method = ProcessCoupling.class.getDeclaredMethod("calculateProcessCoupling", Workflow.class);
				method.setAccessible(true);
				
				processCouplingValue = (double) method.invoke(processCoupling, workflow);
				
				
				double result = 1;
				assertEquals(result, processCouplingValue, 0.01);
	}

	
	@Test
	void testProcessCoupling2() throws Exception {
		//Setup activity 1
				activity1.getEncapsulates().add(task1);
				activity1.getEncapsulates().add(task2);
				activity1.getEncapsulates().add(task3);
				
				task1.getSink().add(task3);
				task2.getSink().add(task3);
				
				task3.getSource().add(task1);
				task3.getSource().add(task2);
				task3.getSink().add(task10);
				
				//Setup activity 2
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
				
				
				
				//Activity 3
				activity3.getEncapsulates().add(task4);
				activity3.getEncapsulates().add(task5);
				activity3.getEncapsulates().add(task8);
				activity3.getEncapsulates().add(task12);
			
				
				task4.getSink().add(task8);
				task5.getSink().add(task8);
				
				task8.getSource().add(task4);
				task8.getSource().add(task5);
				task8.getSink().add(task12);
				
				workflow.getActivities().add(activity1);
				workflow.getActivities().add(activity2);
				workflow.getActivities().add(activity3);
				
				double processCouplingValue = 0;
				
				
				Method method = ProcessCoupling.class.getDeclaredMethod("calculateProcessCoupling", Workflow.class);
				method.setAccessible(true);
				
				processCouplingValue = (double) method.invoke(processCoupling, workflow);
				
				
				double result = 1.0d / 3.0d;
				assertEquals(result, processCouplingValue, 0.01);
	}
	
	@Test
	void testProcessCouplingEmpty() throws Exception {
		
				workflow.getActivities().add(activity1);
				workflow.getActivities().add(activity2);
				workflow.getActivities().add(activity3);
				
				double processCouplingValue = 0;
				
				
				Method method = ProcessCoupling.class.getDeclaredMethod("calculateProcessCoupling", Workflow.class);
				method.setAccessible(true);
				
				processCouplingValue = (double) method.invoke(processCoupling, workflow);
				
				
				double result = 0;
				assertEquals(result, processCouplingValue, 0.01);
	}
	
	@Test
	void testCouplingAlternativePaths() throws Exception {
		WorkflowFactory factory = WorkflowFactory.eINSTANCE;
		
		workflow = factory.createWorkflow();
		
		activity1 = factory.createActivity();
		activity1.setName("1");
		
		activity2 = factory.createActivity();
		activity2.setName("2");
		
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
		
		task25 = factory.createTask();
		task25.setName("25");
		
		//Setup activity 1
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
		task21.getSink().add(task25);
		
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
		
		task24.getSink().add(task25);
		
		//Setup activity 2
		activity2.getEncapsulates().add(task25);
		
		task25.getSource().add(task24);
		task25.getSource().add(task21);
		
		workflow.getActivities().add(activity1);
		workflow.getActivities().add(activity2);
		
		double processCouplingValue = 0;
		
		
		Method method = ProcessCoupling.class.getDeclaredMethod("calculateProcessCoupling", Workflow.class);
		method.setAccessible(true);
		
		processCouplingValue = (double) method.invoke(processCoupling, workflow);
		
		
		double result = 1;
		assertEquals(result, processCouplingValue, 0.01);
		
	}
	
}
