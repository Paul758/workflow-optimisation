package model.workflow.fitness.constraints;

import model.workflow.Workflow;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.IGuidanceFunction;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.interpreter.guidance.Solution;

public class MinimiseEmptyActivities implements IGuidanceFunction {
	
	/**
	 * Constraint for checking if an activity is empty
	 * Count activities that don't contain any informationObjects. These can be deleted.
	 * @param Solution the instance model containing all activities
	 * @return The amount of activities that don't contain at least one informationObject.
	 */
	@Override
	public double computeFitness(Solution solution) {
		Workflow workflow = (Workflow) solution.getModel();
		
		return workflow.getActivities().stream()
		        .filter(activity -> activity.getEncapsulates().isEmpty())
		        .count();
	}

	@Override
	public String getName() {
		return "Minimise amount of activities that do not encapsulate any informationObject";
	}
	
}
