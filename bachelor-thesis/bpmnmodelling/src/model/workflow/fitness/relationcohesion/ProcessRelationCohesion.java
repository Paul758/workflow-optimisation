package model.workflow.fitness.relationcohesion;

import java.util.List;

import model.workflow.Activity;
import model.workflow.Workflow;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.IGuidanceFunction;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.interpreter.guidance.Solution;

public class ProcessRelationCohesion implements IGuidanceFunction{

	ActivityRelationCohesion activityRelationCohesion = new ActivityRelationCohesion();
	
	/**
	 * The ProcessRelationCohesion is calculated for test purposes. It calculates the ARC for all activities
	 * in the process and normalizes it by the amount of all activities
	 * @Solution solution The instance model for which the ProcessInformationCohesion should be calculated
	 * @return The ProcessInformationCohesion for the instance model.
	 */
	@Override
	public double computeFitness(Solution solution) {
		Workflow workflow = (Workflow) solution.getModel();
		return calculateProcessRelationCohesion(workflow);
	}

	private double calculateProcessRelationCohesion(Workflow workflow) {
		List<Activity> activities = workflow.getActivities();
		double processRelationCohesionTotal = 0;
		double totalActivities = activities.size();
		
		for (Activity activity : activities) {
			processRelationCohesionTotal += activityRelationCohesion.calculateActivityRelationCohesion(activity);
		}
		
		
		return processRelationCohesionTotal / totalActivities;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
