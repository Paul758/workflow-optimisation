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

public class ActivityRelationCohesion implements IGuidanceFunction {

	@Override
	public double computeFitness(Solution solution) {
		Workflow workflowModel = (Workflow) solution.getModel();
		return calculateActivityRelationCohesion(workflowModel);
	}

	
	private double calculateActivityRelationCohesion(Workflow workflowModel) {
		System.out.println("Starting to calculate fitness");
		List<Activity> activities = workflowModel.getActivities();
		List<Double> activityRelationCohesionValues = new ArrayList<Double>();
		
		//Iterate over all activities in the workflow
		for (int i = 0; i < activities.size(); i++) {
			System.out.println("Loop 1: " + i);
			Activity currentActivity = activities.get(i);
			List<Task> tasks = getTasksFromActivity(currentActivity);
			int relationCounter = 0;
			
			//Compare all tasks to each other
			for (int j = 0; j < tasks.size(); j++) {
				Task pTask = tasks.get(j);
				for(int k = 0; k < tasks.size(); k++) {
					Task qTask = tasks.get(k);
					//Skip same tasks
					if(pTask.equals(qTask)) {
						continue;
					}
					//Construct operations
					Set<Task> pOperation = getInputTasks(pTask);
					if(pOperation.isEmpty()) {
						System.out.println("P operation is empty");
						continue;
					}
					pOperation.add(pTask);
					System.out.println("P operation is " + pOperation.toString());
					Set<Task> qOperation = getInputTasks(qTask);
					if(qOperation.isEmpty()) {
						System.out.println("Q operation is empty");
						continue;
					}
					qOperation.add(qTask);
					System.out.println("Q operation is " + qOperation.toString());
					
					pOperation.retainAll(qOperation);
					System.out.println("Intersection is: " + pOperation);
					
					if(!pOperation.isEmpty()) {
						relationCounter++;
						System.out.println("Increasing counter to " + relationCounter);
					}
				}
			}
			
			//Calculate activity relation cohesion value for this activity
			
			double taskAmount = tasks.size();
			System.out.println("The task size is: " + taskAmount);
			double activityRelationCohesion = relationCounter / (taskAmount * (taskAmount - 1));
			System.out.println("This ARC is: " + activityRelationCohesion);
			activityRelationCohesionValues.add(activityRelationCohesion);
			System.out.println(" ---Finished run----");
			System.out.println(" ");
		}
		
		//Calculate mean for workflow model
		double arcMean = 0;
		double arcTotal = 0;
		for(Double value : activityRelationCohesionValues) {
			arcTotal += value;
		}
		
		arcMean = arcTotal / activities.size();
		
		return arcMean;
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

	private List<Task> getTasksFromActivity(Activity currentActivity) {
		List<Task> tasks = new ArrayList<Task>();
		for (InformationObject informationObject : currentActivity.getEncapsulates()) {
			if (informationObject instanceof Task) {
				tasks.add((Task) informationObject);
			}
		}
		return tasks;
	}
	
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
