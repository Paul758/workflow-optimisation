package model.workflow.fitness.coupling;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.workflow.Activity;
import model.workflow.Task;
import model.workflow.Workflow;
import model.workflow.WorkflowFactory;


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
	void testProcessCohesion() throws Exception {
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
	void testProcessCohesion2() throws Exception {
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
	
}
