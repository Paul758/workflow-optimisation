package model.workflow.fitness;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.workflow.Activity;
import model.workflow.InformationObject;
import model.workflow.Parallel;
import model.workflow.Task;
import model.workflow.Workflow;
import model.workflow.WorkflowFactory;

class ActivityRelationCohesionTest {
	
	ActivityRelationCohesion activityRelationCohesion;
	
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
		activityRelationCohesion = new ActivityRelationCohesion();
		
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
	void testGetInputTasks1() throws Exception {
		parallel1.getSource().add(task1);
		parallel1.getSource().add(task2);
		
		parallel2.getSource().add(parallel1);
		
		task3.getSource().add(parallel2);
		
		Method method = ActivityRelationCohesion.class.getDeclaredMethod("getInputTasks", InformationObject.class);
		method.setAccessible(true);
		
		HashSet<Task> inputTasks = (HashSet<Task>) method.invoke(activityRelationCohesion, task3);
		
		assertEquals(2, inputTasks.size());
		assertTrue(inputTasks.contains(task1) && inputTasks.contains(task2));
	}
	
	@Test
	void testActivityRelationCohesion() throws Exception {
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
		
		double activityRelationCohesionFitness = 0;
		
		Method method = ActivityRelationCohesion.class.getDeclaredMethod("calculateActivityRelationCohesion", Workflow.class);
		method.setAccessible(true);
		
		activityRelationCohesionFitness = (double) method.invoke(activityRelationCohesion, workflow);
		
		System.out.println("Activity Relation Cohesion is: " + activityRelationCohesionFitness);
		double result = 5.0d/9.0d;
		assertEquals(result, activityRelationCohesionFitness, 0.01);
		
	}
	
}
