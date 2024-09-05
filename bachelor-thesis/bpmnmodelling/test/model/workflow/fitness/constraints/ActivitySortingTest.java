package model.workflow.fitness.constraints;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.workflow.Activity;
import model.workflow.Task;
import model.workflow.Workflow;
import model.workflow.WorkflowFactory;

public class ActivitySortingTest {
	
	ActivitySorting activitySorting;
	
	Workflow workflow;
	Activity activity1;
	Activity activity2;

	Task task1;
	Task task2;
	Task task3;
	
	Task task9;
	Task task10;
	Task task11;
	Task task13;
	Task task14;
	Task task15;
	
	@BeforeEach
	void setUp() {
		
		activitySorting = new ActivitySorting();
		
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
	void testTopologicalSortingOutcomeTrue() throws Exception {
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
			
				
				boolean sortingOutcome = false;
				HashMap<Activity, HashSet<Activity>> adjacencyList = new HashMap<>();
				
				adjacencyList.put(activity1, new HashSet<>());
				HashSet<Activity> activity2Dependencies = new HashSet<>();
				activity2Dependencies.add(activity1);
				adjacencyList.put(activity2, activity2Dependencies);
				
				
				Method method = ActivitySorting.class.getDeclaredMethod("topSort", HashMap.class);
				method.setAccessible(true);
				
				sortingOutcome = (boolean) method.invoke(activitySorting, adjacencyList);
				
				
				
				assertEquals(true, sortingOutcome);
	}
	
	@Test
	void testTopologicalSortingOutcomeFalse() throws Exception {
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
			
				
				boolean sortingOutcome = false;
				HashMap<Activity, HashSet<Activity>> adjacencyList = new HashMap<>();
				
				HashSet<Activity> activity1Dependencies = new HashSet<>();
				activity1Dependencies.add(activity2);
				adjacencyList.put(activity1, activity1Dependencies);
				HashSet<Activity> activity2Dependencies = new HashSet<>();
				activity2Dependencies.add(activity1);
				adjacencyList.put(activity2, activity2Dependencies);
				
				
				Method method = ActivitySorting.class.getDeclaredMethod("topSort", HashMap.class);
				method.setAccessible(true);
				
				sortingOutcome = (boolean) method.invoke(activitySorting, adjacencyList);
				
				
				
				assertEquals(false, sortingOutcome);
	}
	
}
