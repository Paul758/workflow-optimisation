package model.workflow.fitness.coupling;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.workflow.Activity;
import model.workflow.Task;
import model.workflow.Workflow;
import model.workflow.fitness.FitnessUtil;
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
	    List<Task> sTasks = FitnessUtil.getTasksFromActivity(sActivity);
	    List<Task> tTasks = FitnessUtil.getTasksFromActivity(tActivity);
		System.out.println("The tasks in " + sActivity.toString() + "are" + sTasks);
		System.out.println("The tasks in " + tActivity.toString() + "are" + tTasks);
	    
	    for (int i = 0; i < sTasks.size(); i++) {
	    	
	    	Task currentTask = sTasks.get(i);
	    	Set<Task> sOperation = FitnessUtil.getInputTasks(currentTask);
	    	sOperation.add(currentTask);
	    	
		    for (int j = 0; j < tTasks.size(); j++) {
		    	Task nextTask = tTasks.get(j);
		    	Set<Task> tOperation = FitnessUtil.getInputTasks(nextTask);
		    	tOperation.add(nextTask);
		    	System.out.println("The sOperation is " + sOperation.toString());
		    	System.out.println("The tOperation is " + tOperation.toString());
		    	//Intersect sets
		    	Set<Task> intersectionSet = new HashSet<Task>(sOperation);
		    	intersectionSet.retainAll(tOperation);
		    	System.out.println("the intersection is " + sOperation.toString());
		    	if(!sOperation.isEmpty()) {
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
