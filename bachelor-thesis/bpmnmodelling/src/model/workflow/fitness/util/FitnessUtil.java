package model.workflow.fitness.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.workflow.Activity;
import model.workflow.AlternativeOperation;
import model.workflow.InformationObject;
import model.workflow.Task;

public class FitnessUtil {
	
	/**
	 * Get the input tasks that are necessary to perform the given informationObject.
	 * @param informationObject the information object for which the input should be calculated.
	 * @return The Set of tasks that are needed as an input.
	 */
	public static Set<Task> getInputTasks(InformationObject informationObject) {
		HashSet<Task> inputTasks = new HashSet<Task>();
		List<InformationObject> previousObjects = informationObject.getSource();
		
		if (previousObjects == null) {
			return inputTasks;
		}
		
		for (int i = 0; i < previousObjects.size(); i++) {
			InformationObject currentObject = previousObjects.get(i);
			
			if (currentObject instanceof Task) {
				inputTasks.add((Task) currentObject);
			} else {
				inputTasks.addAll(getInputTasks(currentObject));
			}
		}
		return inputTasks;
	}
	
	/**
	 * Get a list of all task objects in an activity
	 * @param currentActivity The activity, for which the task objects should be listed.
	 * @return a List of the task objects that are present in the given activity
	 */
	public static List<Task> getTasksFromActivity(Activity currentActivity) {
		List<Task> tasks = new ArrayList<Task>();
		for (InformationObject informationObject : currentActivity.getEncapsulates()) {
			if (informationObject instanceof Task) {
				tasks.add((Task) informationObject);
			}
		}
		return tasks;
	}
	
	/**
	 * Get a list of all operations that are present in the given activity.
	 * @param activity The activity for which the operations should be listed
	 * @return a list of all operations that are present in the given activity
	 */
	public static List<Operation> getAllOperationsFromActivity(Activity activity) {
		List<Operation> operations = new ArrayList<Operation>();
		List<Task> tasksInActivity = getTasksFromActivity(activity);
		
		for (Task task : tasksInActivity) {
			
			if (task.getAlternativePaths().isEmpty()) {
				Operation operation = new Operation(task);
				
				if (operation.hasNoInput()) {
					continue;
				}
				operations.add(operation);
			} else {
				List<AlternativeOperation> alternativeOperations = task.getAlternativePaths();
				for (AlternativeOperation alternativeOperation : alternativeOperations) {
					operations.add(new Operation(task, alternativeOperation));
				}
			}
		}
		return operations;
	}
}
