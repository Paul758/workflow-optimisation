package model.workflow.fitness.informationcohesion;

import java.util.List;

import model.workflow.Activity;
import model.workflow.Workflow;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.IGuidanceFunction;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.interpreter.guidance.Solution;

public class ProcessInformationCohesion implements IGuidanceFunction {

	ActivityInformationCohesion activityInformationCohesion = new ActivityInformationCohesion();
	
	/**
	 * The ProcessInformationCohesion is calculated for test purposes. It calculates the AIC for all activities
	 * in the process and normalizes it by the amount of all activities
	 * @Solution solution The instance model for which the ProcessInformationCohesion should be calculated
	 * @return The ProcessInformationCohesion for the instance model.
	 */
	@Override
	public double computeFitness(Solution solution) {
		Workflow workflow = (Workflow) solution.getModel();
		return calculateProcessInformationCohesion(workflow);
	}
	
	private double calculateProcessInformationCohesion(Workflow workflow) {
		List<Activity> activities = workflow.getActivities();
		double totalActivities = activities.size();
		double totalActivityInformationCohesion = 0;
		
		for (Activity activity : activities) {
			totalActivityInformationCohesion += activityInformationCohesion.calculateActivityInformationCohesion(activity);
		}
		
		return totalActivityInformationCohesion / totalActivities;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
