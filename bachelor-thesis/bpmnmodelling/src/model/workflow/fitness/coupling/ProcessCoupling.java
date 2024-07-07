package model.workflow.fitness.coupling;

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
		
		
		return connectedCounter / (totalActivities * (totalActivities - 1));
	}

	
	private boolean connected(Activity sActivity, Activity tActivity) {
		if(sActivity.equals(tActivity)) {
			return false;
		}
		
		return activitiesShareInformationObjects(sActivity, tActivity);
		
		
	}
	
	private boolean activitiesShareInformationObjects(Activity sActivity, Activity tActivity) {
	    List<Task> sTasks = FitnessUtil.getTasksFromActivity(sActivity);
	    List<Task> tTasks = FitnessUtil.getTasksFromActivity(tActivity);
		
	    for (int i = 0; i < sTasks.size(); i++) {
	    	
	    	Task currentTask = sTasks.get(i);
	    	Set<Task> sOperation = FitnessUtil.getInputTasks(currentTask);
	    	sOperation.add(currentTask);
	    	
		    for (int j = 0; j < tTasks.size(); j++) {
		    	Task nextTask = tTasks.get(j);
		    	Set<Task> tOperation = FitnessUtil.getInputTasks(nextTask);
		    	tOperation.add(nextTask);
		    	
		    	//Interset sets
		    	sOperation.retainAll(tOperation);
		    	
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
