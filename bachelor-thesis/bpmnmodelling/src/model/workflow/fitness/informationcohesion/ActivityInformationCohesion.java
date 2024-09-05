package model.workflow.fitness.informationcohesion;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.workflow.Activity;
import model.workflow.Task;
import model.workflow.fitness.util.FitnessUtil;
import model.workflow.fitness.util.Operation;


public class ActivityInformationCohesion {
	
	/**
	 * Calculate the AIC for a given Activity.
	 * @param activity The activity for which the AIC should be calculated
	 * @return Returns the AIC for the given activity. The AIC is calculated by checking for each task if there is
	 * a pair of operations, so that the task in present in the intersection of the operation pair.
	 * The count of tasks is also normalized between 0 and 1.
	 */
	public double calculateActivityInformationCohesion(Activity activity) {
		
		List<Task> tasks = FitnessUtil.getTasksFromActivity(activity);
		List<Operation> operations = FitnessUtil.getAllOperationsFromActivity(activity);
		Set<Task> tasksUsedInAnyOperation = new HashSet<Task>(tasks);	
		double taskInIntersectionCounter = 0;
		
			
		//Construct set of all tasks that are used in any operation (denominator for calculation)	
		for(Operation operation : operations) {

			tasksUsedInAnyOperation.addAll(operation.getTaskSet());
			
		}
	
		//Return 0 if there is no operation
		if (operations.size() == 0) {
			return 0;
		}
		
		//Iterate over all tasks
		ArrayList<Task> tasksUsedInActivity = new ArrayList<Task>(tasksUsedInAnyOperation);
		for (int i = 0; i < tasksUsedInActivity.size(); i++) {
			Task currentTask = tasksUsedInActivity.get(i);
			
			//If task is present in an operation intersection, increase counter
			if(existsInOperationIntersection(currentTask, operations)) {
				taskInIntersectionCounter++;
			}	
		}
		
		double activityInformationCohesion = taskInIntersectionCounter / tasksUsedInAnyOperation.size();
		return activityInformationCohesion;
	}

	private boolean existsInOperationIntersection(Task task, List<Operation> operations) {
		boolean operationPairExists = false;
		
		//Build intersections of all operations
		for (int j = 0; j < operations.size(); j++) {
			Operation currentOperation = operations.get(j);
			
			for (int k = 0; k < operations.size(); k++) {
				Operation nextOperation = operations.get(k);
				
				//Skip operations with same output
				if(currentOperation.getOutput().equals(nextOperation.getOutput())) {
					continue;
				}
				
				//Intersect both operations
				Set<Task> intersectionSet = currentOperation.intersect(nextOperation);
				
				//If task is present in any intersection, return true
				if(intersectionSet.contains(task)) {
					return true;
				}
			}
			
		}
		//Task doesn't exist in any intersection, return false
		return operationPairExists;
	}

}
