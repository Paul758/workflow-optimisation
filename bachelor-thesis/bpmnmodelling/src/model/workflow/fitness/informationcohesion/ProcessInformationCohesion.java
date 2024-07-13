package model.workflow.fitness.informationcohesion;

import java.util.List;

import model.workflow.Activity;
import model.workflow.Workflow;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.IGuidanceFunction;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.interpreter.guidance.Solution;

public class ProcessInformationCohesion implements IGuidanceFunction {

	ActivityInformationCohesion activityInformationCohesion = new ActivityInformationCohesion();
	
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
