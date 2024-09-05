package model.workflow.fitness.constraints;

import model.workflow.Workflow;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.IGuidanceFunction;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.interpreter.guidance.Solution;

public class MinimiseSmallActivities implements IGuidanceFunction {
	
	/**
	 * Constraint for checking if an activity is small e.g. contains less than two informationObjects.
	 * The goal is to count the activities that don't contain at least 3 informationObjects.
	 * If the count is reduced to 0, the constraint is fulfilled.
	 * @param Solution the instance model containing all activities
	 * @return The amount of activities that don't contain at least 3 informationObjects.
	 */
	@Override
	public double computeFitness(Solution solution) {
		Workflow workflow = (Workflow) solution.getModel();
		
		return workflow.getActivities().stream()
		        .filter(activity -> activity.getEncapsulates().size() <= 2)
		        .count();
	}

	@Override
	public String getName() {
		return "Minimise amount of activities that do not encapsulate any informationObject";
	}
}
