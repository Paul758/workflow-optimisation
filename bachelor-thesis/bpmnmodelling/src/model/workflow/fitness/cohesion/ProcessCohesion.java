package model.workflow.fitness.cohesion;

import java.util.List;

import model.workflow.Activity;
import model.workflow.Workflow;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.IGuidanceFunction;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.interpreter.guidance.Solution;

public class ProcessCohesion implements IGuidanceFunction {

	ActivityCohesion activityCohesion = new ActivityCohesion();
	
	/**
	 * Calculate the process cohesion by summing up the activity cohesion for each activity and then dividing it by all activities
	 * resulting in the mean
	 * @param Solution the instance model, for which the fitness is calculated.
	 * @return the processCohesion for the instance model 
	 */
	@Override
	public double computeFitness(Solution solution) {
		Workflow workflow = (Workflow) solution.getModel();
		return calculateProcessCohesion(workflow);
	}
	
	private double calculateProcessCohesion(Workflow workflow) {
		List<Activity> activities = workflow.getActivities();
		double totalActivities = activities.size();
		
		//If no activities exists, the cohesion is 0.
		if (activities.size() == 0) {
			return 0;
		}
		
		double totalCohesionValue = 0;
		for (Activity activity : activities) {
			totalCohesionValue += activityCohesion.calculateActivityCohesion(activity);
		}
		
		return totalCohesionValue / totalActivities;
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
