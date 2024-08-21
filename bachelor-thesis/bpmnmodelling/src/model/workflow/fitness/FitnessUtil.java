package model.workflow.fitness;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.workflow.Activity;
import model.workflow.InformationObject;
import model.workflow.Task;

public class FitnessUtil {

	public static Set<Task> getInputTasks(InformationObject informationObject) {
		HashSet<Task> inputTasks = new HashSet<Task>();
		List<InformationObject> previousObjects = informationObject.getSource();
		
		if(previousObjects == null) {
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
	
	public static List<Task> getTasksFromActivity(Activity currentActivity) {
		List<Task> tasks = new ArrayList<Task>();
		for (InformationObject informationObject : currentActivity.getEncapsulates()) {
			if (informationObject instanceof Task) {
				tasks.add((Task) informationObject);
			}
		}
		return tasks;
	}
	
	public static List<Operation> getAllOperationsFromActivity(Activity activity) {
		List<Operation> operations = new ArrayList<Operation>();
		List<Task> tasksInActivity = getTasksFromActivity(activity);
		
		for(Task task : tasksInActivity) {
			Operation operation = new Operation(task);
			if(operation.hasNoInput()) {
				continue;
			}
			operations.add(operation);
		}
		
		return operations;
		
	}
}
