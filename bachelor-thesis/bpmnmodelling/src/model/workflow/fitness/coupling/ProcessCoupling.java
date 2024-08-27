package model.workflow.fitness.coupling;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.workflow.Activity;
import model.workflow.Task;
import model.workflow.Workflow;
import model.workflow.fitness.FitnessUtil;
import model.workflow.fitness.Operation;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.IGuidanceFunction;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.interpreter.guidance.Solution;

public class ProcessCoupling implements IGuidanceFunction {

	@Override
	public double computeFitness(Solution solution) {
		Workflow workflow = (Workflow) solution.getModel();
		return calculateProcessCoupling(workflow);
	}

	
	private double calculateProcessCoupling(Workflow workflow) {
		
		List<Activity> activities = workflow.getActivities();
		System.out.println("The activities are " + activities.toString());
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
		System.out.println("The amount of connections: " + connectedCounter);
		double fitness = connectedCounter / (totalActivities * (totalActivities - 1));
		return fitness;
	}


	private boolean connected(Activity sActivity, Activity tActivity) {
		System.out.println("now comparing " + sActivity.toString() + " and " + tActivity.toString());
		if(sActivity.equals(tActivity)) {
			System.out.println("the activities are the same, so skip");
			return false;
		}
		
		return activitiesShareInformationObjects(sActivity, tActivity);
		
		
	}
	
	private boolean activitiesShareInformationObjects(Activity sActivity, Activity tActivity) {
		List<Operation> sOperations = FitnessUtil.getAllOperationsFromActivity(sActivity);
		List<Operation> tOperations = FitnessUtil.getAllOperationsFromActivity(tActivity);
		System.out.println("The operations in " + sActivity.toString() + "are" + sOperations.toString());
		System.out.println("The operations in " + tActivity.toString() + "are" + tOperations.toString());
	    
	    for (int i = 0; i < sOperations.size(); i++) {
	    	
	    	Operation currentOperation = sOperations.get(i);
	    	
		    for (int j = 0; j < tOperations.size(); j++) {
		    	Operation nextOperation = tOperations.get(j);
		    	System.out.println("The sOperation is " + sOperations.toString());
		    	System.out.println("The tOperation is " + tOperations.toString());
		    	//Intersect sets
		    	Set<Task> intersectionSet = new HashSet<Task>(currentOperation.getTaskSet());
		    	intersectionSet.retainAll(nextOperation.getTaskSet());
		    	System.out.println("the intersection is " + sOperations.toString());
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
