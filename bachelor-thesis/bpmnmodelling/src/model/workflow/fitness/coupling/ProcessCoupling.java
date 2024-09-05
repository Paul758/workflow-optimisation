package model.workflow.fitness.coupling;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.workflow.Activity;
import model.workflow.Task;
import model.workflow.Workflow;
import model.workflow.fitness.util.FitnessUtil;
import model.workflow.fitness.util.Operation;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.IGuidanceFunction;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.interpreter.guidance.Solution;

public class ProcessCoupling implements IGuidanceFunction {

	/**
	 * Calculate the coupling of a process by finding all connections between each activity.
	 * Two activities are connected, if the operations of each activities share at least one informationObject.
	 * The coupling of a process is the count of all connections, divided by the
	 * amount of activities * amount  of activities - 1 to normalize it
	 * @param Solution the instance model containing all activities
	 * @return The coupling of the whole process
	 */
	@Override
	public double computeFitness(Solution solution) {
		Workflow workflow = (Workflow) solution.getModel();
		return calculateProcessCoupling(workflow);
	}

	
	private double calculateProcessCoupling(Workflow workflow) {
		List<Activity> activities = workflow.getActivities();
		double connectedCounter = 0;
		double totalActivities = activities.size();
		
		for (int i = 0; i < activities.size(); i++) {
			Activity currentActivity = activities.get(i);
			
			for (int j = 0; j < activities.size(); j++) {
				Activity nextActivity = activities.get(j);
				
				if(connected(currentActivity, nextActivity)) {
					connectedCounter++;
				}
			}
		}
		double fitness = connectedCounter / (totalActivities * (totalActivities - 1));
		return fitness;
	}


	private boolean connected(Activity sActivity, Activity tActivity) {
		if (sActivity.equals(tActivity)) {
			return false;
		}
		return activitiesShareInformationObjects(sActivity, tActivity);	
	}
	
	private boolean activitiesShareInformationObjects(Activity sActivity, Activity tActivity) {
		List<Operation> sOperations = FitnessUtil.getAllOperationsFromActivity(sActivity);
		List<Operation> tOperations = FitnessUtil.getAllOperationsFromActivity(tActivity);
    
	    for (int i = 0; i < sOperations.size(); i++) {
	    	
	    	Operation currentOperation = sOperations.get(i);
	    	
		    for (int j = 0; j < tOperations.size(); j++) {
		    	
		    	Operation nextOperation = tOperations.get(j);    	
		    	Set<Task> intersectionSet = new HashSet<Task>(currentOperation.getTaskSet());
		    	intersectionSet.retainAll(nextOperation.getTaskSet());
		    	
		    	if(!intersectionSet.isEmpty()) {
		    		return true;
		    	}
		    	
		    }
	    }
		return false;
	}


	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
