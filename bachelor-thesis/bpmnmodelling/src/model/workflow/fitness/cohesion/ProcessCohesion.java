package model.workflow.fitness.cohesion;

import java.util.List;

import model.workflow.Activity;
import model.workflow.Workflow;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.IGuidanceFunction;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.interpreter.guidance.Solution;

public class ProcessCohesion implements IGuidanceFunction {

	ActivityCohesion activityCohesion = new ActivityCohesion();
	
	@Override
	public double computeFitness(Solution solution) {
		Workflow workflow = (Workflow) solution.getModel();
		List<Activity> activities = workflow.getActivities();
		double totalActivities = activities.size();
		double totalCohesionValue = 0;
		for(Activity activity : activities) {
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
