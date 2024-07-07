package model.workflow.fitness;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.workflow.Activity;
import model.workflow.InformationObject;
import model.workflow.Task;
import model.workflow.Workflow;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.IGuidanceFunction;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.interpreter.guidance.Solution;

public class ActivityInformationCohesion implements IGuidanceFunction {

	@Override
	public double computeFitness(Solution solution) {
		Workflow workflowModel = (Workflow) solution.getModel();
		
		return calculateActivityInformationCohesion(workflowModel);
	}

	private double calculateActivityInformationCohesion(Workflow workflowModel) {
		List<Activity> activities = workflowModel.getActivities();
		List<Double> activityInformationCohesionValues = new ArrayList<Double>();
		for (int i = 0; i < activities.size(); i++) {
			Activity currentActivity = activities.get(i);
			List<Task> tasks = getTasksFromActivity(currentActivity);
			double taskInIntersectionCounter = 0;
			
			for (int j = 0; j < tasks.size(); j++) {
				Task pTask = tasks.get(j);
				for (int k = 0; k < tasks.size(); k++) {
					Task qTask = tasks.get(k);
					
					if (pTask.equals(qTask)) {
						continue;
					}
					
					Set<Task> pOperation = getInputTasks(pTask);
					if(pOperation.isEmpty()) {
						continue;
					}
					pOperation.add(pTask);
					
					Set<Task> qOperation = getInputTasks(qTask);
					if(qOperation.isEmpty()) {
						continue;
					}
					qOperation.add(qTask);
					
					
					//Build intersection
					pOperation.retainAll(qOperation);
					
					if(pOperation.contains(pTask)) {
						taskInIntersectionCounter++;
					}
				}
			}
			
			double taskAmount = tasks.size();
			double activityInformationCohesion = taskInIntersectionCounter / taskAmount;
			activityInformationCohesionValues.add(activityInformationCohesion);
		}
		
		double aicMean = 0;
		double aicTotal = 0;
		double aicValueCount = activityInformationCohesionValues.size();
		for (Double value : activityInformationCohesionValues) {
			aicTotal += value;
		}
		
		aicMean = aicTotal / aicValueCount;
		
		return aicMean;
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
	
	private Set<Task> getInputTasks(InformationObject informationObject) {
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

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
