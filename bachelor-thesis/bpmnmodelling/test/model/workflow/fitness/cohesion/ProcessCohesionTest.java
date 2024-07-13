package model.workflow.fitness.cohesion;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.workflow.Activity;
import model.workflow.Parallel;
import model.workflow.Task;
import model.workflow.Workflow;
import model.workflow.WorkflowFactory;
import model.workflow.fitness.informationcohesion.ProcessInformationCohesion;
import model.workflow.fitness.relationcohesion.ProcessRelationCohesion;


class ProcessCohesionTest {

	
	ActivityCohesion activityCohesion;
	ProcessCohesion processCohesion;
	ProcessRelationCohesion processRelationCohesion;
	ProcessInformationCohesion processInformationCohesion;
	
	Workflow workflow;
	Activity activity1;
	Activity activity2;
	Activity activity3;
	Task task1;
	Task task2;
	Task task3;
	Task task4;
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
		activityCohesion = new ActivityCohesion();
		processCohesion = new ProcessCohesion();
		processRelationCohesion = new ProcessRelationCohesion();
		processInformationCohesion = new ProcessInformationCohesion();
		
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
		
		task6 = factory.createTask();
		task6.setName("6");
		
		task7 = factory.createTask();
		task7.setName("7");
		
		task8 = factory.createTask();
		task8.setName("8");
		
		task9 = factory.createTask();
		task9.setName("9");
		
		parallel1 = factory.createParallel();
		parallel1.setName("Parallel 1");
		
		parallel2 = factory.createParallel();
		parallel2.setName("Parallel 2");
		
		parallel3 = factory.createParallel();
		parallel3.setName("Parallel 3");
		
	}
	
	
	
	
	@Test
	void testProcessCohesion() throws Exception {
		//Setup activity 1
				activity1.getEncapsulates().add(task1);
				activity1.getEncapsulates().add(task2);
				activity1.getEncapsulates().add(task3);
				activity1.getEncapsulates().add(parallel1);
				
				parallel1.getSource().add(task1);
				parallel1.getSource().add(task2);
				task3.getSource().add(parallel1);
				
				//Setup activity 2
				activity2.getEncapsulates().add(task4);
				activity2.getEncapsulates().add(task5);
				activity2.getEncapsulates().add(task6);
				activity2.getEncapsulates().add(parallel2);
				
				parallel2.getSource().add(task3);
				task4.getSource().add(parallel2);
				task5.getSource().add(parallel2);
				task6.getSource().add(parallel2);
				
				//Setup activity 3
				activity3.getEncapsulates().add(task7);
				activity3.getEncapsulates().add(task8);
				activity3.getEncapsulates().add(task9);
				activity3.getEncapsulates().add(parallel3);
				
				parallel3.getSource().add(task4);
				parallel3.getSource().add(task5);
				parallel3.getSource().add(task6);
				
				task7.getSource().add(parallel3);
				task8.getSource().add(task7);
				task9.getSource().add(task8);
				
				workflow.getActivities().add(activity1);
				workflow.getActivities().add(activity2);
				workflow.getActivities().add(activity3);
				
				double processCohesionValue = 0;
				
				Method processRelationCohesion = ProcessRelationCohesion.class.getDeclaredMethod("calculateProcessRelationCohesion", Workflow.class);
				processRelationCohesion.setAccessible(true);
				
				Method processInformationCohesion = ProcessInformationCohesion.class.getDeclaredMethod("calculateProcessInformationCohesion", Workflow.class);
				processInformationCohesion.setAccessible(true);
				
				Method method = ProcessCohesion.class.getDeclaredMethod("calculateProcessCohesion", Workflow.class);
				method.setAccessible(true);
				
				processCohesionValue = (double) method.invoke(processCohesion, workflow);
				
				System.out.println("Process Information Cohesion is: " + processCohesionValue);
				double result = (4.0d/27.0d);
				assertEquals(result, processCohesionValue, 0.01);
	}

}
