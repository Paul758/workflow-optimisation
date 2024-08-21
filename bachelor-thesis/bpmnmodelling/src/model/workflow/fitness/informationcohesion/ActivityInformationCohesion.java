package model.workflow.fitness.informationcohesion;


import java.util.List;
import java.util.Set;
import model.workflow.Activity;
import model.workflow.Task;
import model.workflow.fitness.FitnessUtil;
import model.workflow.fitness.Operation;


public class ActivityInformationCohesion {
	
	/**
	 * @param activity The activity for which the AIC should be calculated
	 * @return Returns the AIC for the given activity. The AIC is calculated by checking for each task if there is
	 * a pair of operations, so that the task in present in the intersection of the operation pair.
	 * The count of tasks is also normalized between 0 and 1.
	 */
	public double calculateActivityInformationCohesion(Activity activity) {
		
		List<Task> tasks = FitnessUtil.getTasksFromActivity(activity);
		List<Operation> operations = FitnessUtil.getAllOperationsFromActivity(activity);
			
		double taskInIntersectionCounter = 0;
		double taskAmount = tasks.size();
			
		//Return 0 if there is no task
		if (taskAmount == 0) {
			return 0;
		}
		
		//Iterate over all tasks
		for (int i = 0; i < tasks.size(); i++) {
			Task currentTask = tasks.get(i);
			
			//If task is present in an operation intersection, increase counter
			if(existsInOperationIntersection(currentTask, operations)) {
				taskInIntersectionCounter++;
			}	
		}
		
		System.out.println("The taskIntersection count for " + activity.getName() + " is " + taskInIntersectionCounter);	
		System.out.println("The taskAmount for " + activity.getName() + " is " + taskAmount);	
		double activityInformationCohesion = taskInIntersectionCounter / taskAmount;
		
		System.out.println("The activity Information Cohesion for " + activity.toString() + "is " + activityInformationCohesion);
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
		//Task doesnt exist in any intersection, return false
		return operationPairExists;
	}

}
