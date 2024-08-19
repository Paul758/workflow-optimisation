package model.workflow.fitness.coupling;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Method;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.workflow.Activity;
import model.workflow.Parallel;
import model.workflow.Task;
import model.workflow.Workflow;
import model.workflow.WorkflowFactory;

public class ProcessCouplingTest2 {
	ProcessCoupling processCoupling;
	
	Workflow workflow;
	Activity activity1;
	Activity activity2;
	Activity activity3;
	Task task1;
	Task task2;
	Task task3;
	Task task10;
	Task task5;
	Task task6;
	Task task7;
	Task task8;
	Task task9;
	Parallel parallel1;
	Parallel parallel2;
	Parallel parallel3;
	
	@BeforeEach
	void setUp() {
		System.out.println("Run Before");
		processCoupling = new ProcessCoupling();
		
		WorkflowFactory factory = WorkflowFactory.eINSTANCE;
		
		workflow = factory.createWorkflow();
		
		activity1 = factory.createActivity();
		activity1.setName("1");
		
		activity2 = factory.createActivity();
		activity2.setName("2");
		
		
		task1 = factory.createTask();
		task1.setName("1");
		
		task2 = factory.createTask();
		task2.setName("2");
		
		task3 = factory.createTask();
		task3.setName("3");
		
		task10 = factory.createTask();
		task10.setName("10");
		
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
				activity2.getEncapsulates().add(task10);
				task10.getSource().add(task3);
				
				//Add to workflow
				workflow.getActivities().add(activity1);
				workflow.getActivities().add(activity2);
				
				double processCouplingValue = 0;
				
				Method calculateProcessCoupling = ProcessCoupling.class.getDeclaredMethod("calculateProcessCoupling", Workflow.class);
				calculateProcessCoupling.setAccessible(true);
			
				
				processCouplingValue = (double) calculateProcessCoupling.invoke(processCoupling, workflow);
				
				System.out.println("Process Coupling is: " + processCouplingValue);
				double result = (1);
				assertEquals(result, processCouplingValue, 0.01);
	}
}
