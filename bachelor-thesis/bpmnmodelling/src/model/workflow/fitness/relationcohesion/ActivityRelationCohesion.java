package model.workflow.fitness.relationcohesion;


import java.util.List;
import java.util.Set;
import model.workflow.Activity;
import model.workflow.Task;
import model.workflow.fitness.util.FitnessUtil;
import model.workflow.fitness.util.Operation;


public class ActivityRelationCohesion {
	
	/**
	 * Calculate the ARC for a given Activity.
	 * @param activity The given activity, for which the ARC should be calculated for
	 * @return The ARC of the given activity. The Activity Relation Cohesion is calculated by checking for each operation pair,
	 * if the intersection of these operations is not empty. If the intersection is not empty, this means, that the operations share
	 * an input or an output which is favorable for the ARC.
	 * The ARC is normalized between 0 and 1
	 */
	public double calculateActivityRelationCohesion(Activity activity) {
		List<Operation> operations = FitnessUtil.getAllOperationsFromActivity(activity);
		
		double relationCounter = 0;
		
		
		//If there is one task or less return 0
		if(operations.size() <= 1) {
			return 0;
		}
		
		//calculate ARC via intersection of operations
		for(int i = 0; i < operations.size(); i++) {
			Operation currentOperation = operations.get(i);
		
			
			for(int j = 0; j < operations.size(); j++) {
				Operation nextOperation = operations.get(j);
				
				//Skip operations with same output
				if(currentOperation.getOutput().equals(nextOperation.getOutput())) {
					continue;
				}
				
				Set<Task> intersection = currentOperation.intersect(nextOperation);
				
				if(intersection.isEmpty()) {
					continue;
				}
				
				relationCounter++;
			}
			
		}		
		//Calculate activity relation cohesion value for this activity	
		double activityRelationCohesion = relationCounter / (operations.size() * (operations.size() - 1));
		return activityRelationCohesion;
	}
	

}
