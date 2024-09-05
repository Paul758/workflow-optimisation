package model.workflow.fitness;

import static org.junit.jupiter.api.Assertions.*;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import model.workflow.Activity;
import model.workflow.Task;
import model.workflow.Workflow;
import model.workflow.WorkflowFactory;
import model.workflow.fitness.util.FitnessUtil;
import model.workflow.fitness.util.Operation;


class FitnessUtilTest {
	
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
	public void testGetAllOperationsFromActivity() {
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
		
		Set<Operation> expectedSet = new HashSet<>();
		Operation operation = new Operation(task3);
		expectedSet.add(operation);
		
		Set<Operation> resultSet = new HashSet<>(FitnessUtil.getAllOperationsFromActivity(activity1));
		
		assertEquals(expectedSet, resultSet);
		
	}
		
	
	@Test
	public void testGetInputTasks() {
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
		
		Set<Task> expectedSet = new HashSet<>();
		expectedSet.add(task1);
		expectedSet.add(task2);
		
		assertEquals(expectedSet, FitnessUtil.getInputTasks(task3));
		
	}
	
	@Test
	public void testGetTasksFromActivity() {
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
			
			Set<Task> expectedSet = new HashSet<>();
			expectedSet.add(task1);
			expectedSet.add(task2);
			expectedSet.add(task3);
			
			Set<Task> resultSet = new HashSet<>(FitnessUtil.getTasksFromActivity(activity1));
			
			assertEquals(expectedSet, resultSet );
			
	}
}
