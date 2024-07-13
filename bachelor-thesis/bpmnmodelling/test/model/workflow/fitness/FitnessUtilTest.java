package model.workflow.fitness;

import static org.junit.jupiter.api.Assertions.*;


import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.workflow.Activity;
import model.workflow.Parallel;
import model.workflow.Task;
import model.workflow.Workflow;
import model.workflow.WorkflowFactory;


class FitnessUtilTest {

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
	void testGetInputTasks() throws Exception {
		parallel1.getSource().add(task1);
		parallel1.getSource().add(task2);
		
		parallel2.getSource().add(parallel1);
		
		task3.getSource().add(parallel2);
		
	
		Set<Task> inputTasks = FitnessUtil.getInputTasks(task3);
		
		assertEquals(2, inputTasks.size());
		assertTrue(inputTasks.contains(task1) && inputTasks.contains(task2));
	}

}
