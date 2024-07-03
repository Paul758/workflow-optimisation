package model.workflow.fitness;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import model.workflow.Activity;
import model.workflow.InformationObject;
import model.workflow.Task;
import model.workflow.Workflow;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.IGuidanceFunction;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.interpreter.guidance.Solution;

public class MaximiseTasksInActivity implements IGuidanceFunction {

	@Override
	public double computeFitness(Solution solution) {
		
		System.out.println("computing fitness");
		
		Workflow workflowModel = (Workflow) solution.getModel();
		List<Activity> activities = workflowModel.getActivities();
		int totalTasks = 0;
		int totalActivities = activities.size();
		
		for (Activity activity : activities) {
			List<InformationObject> informationObjects = activity.getEncapsulates();
			
			for (InformationObject informationObject : informationObjects) {
				if(informationObject instanceof Task) {
					totalTasks++;
				}
			}
		}
		
		double activityWeight = 1.0d;
		double taskWeight = 0.1d;
		
		double fitness = (totalTasks * taskWeight) - (totalActivities * activityWeight);
		
		return fitness;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Maximise amount of tasks in an activity";
	}
	
	public double activityCohesion(Solution solution) {
		
		
		return 0;
	}
	
	public double activityRelationCohesion(Solution solution) {
		Workflow workflowModel = (Workflow) solution.getModel();
		List<Activity> activities = workflowModel.getActivities();
		
		int totalTasks = 0;
		int totalActivities = activities.size();
		
		List<Double> activityRelationCohesionValues = new ArrayList<Double>();
		
		//Iterate over all activities in the workflow
		for (int i = 0; i < activities.size(); i++) {
			Activity currentActivity = activities.get(i);
			List<Task> tasks = getTasksFromActivity(currentActivity);
			
			//Compare all tasks to each other
			for (int j = 0; j < tasks.size(); i++) {
				int relationCounter = 0;
				Task pTask = tasks.get(j);
				for(int k = 0; k < tasks.size(); k++) {
					Task qTask = tasks.get(k);
					//Skip same tasks
					if(pTask.equals(qTask)) {
						continue;
					}
					//Construct operations
					Set<Task> pOperation = getInputTasks(pTask);
					pOperation.add(pTask);
					Set<Task> qOperation = getInputTasks(qTask);
					qOperation.add(qTask);
					
					pOperation.retainAll(qOperation);
					
					if(!pOperation.isEmpty()) {
						relationCounter++;
					}
				}
			}
			
			//Calculate activity relation cohesion value for this activity
			
		}
		
		return 0;
	}

	private Set<Task> getInputTasks(Task pTask) {
		// TODO Auto-generated method stub
		return null;
	}

	private List<Task> getTasksFromActivity(Activity currentActivity) {
		List<Task> tasks = new ArrayList<Task>();
		for (InformationObject informationObject : currentActivity.getEncapsulates()) {
			if (informationObject instanceof Task) {
				tasks.add((Task) informationObject);
			}
		}
		return tasks;
	}
	

}
