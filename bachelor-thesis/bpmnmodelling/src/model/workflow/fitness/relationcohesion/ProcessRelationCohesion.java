package model.workflow.fitness.relationcohesion;

import java.util.List;

import model.workflow.Activity;
import model.workflow.Workflow;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.IGuidanceFunction;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.interpreter.guidance.Solution;

public class ProcessRelationCohesion implements IGuidanceFunction{

	ActivityRelationCohesion activityRelationCohesion = new ActivityRelationCohesion();
	
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
