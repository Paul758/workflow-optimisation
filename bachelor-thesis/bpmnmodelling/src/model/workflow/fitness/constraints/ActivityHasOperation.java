package model.workflow.fitness.constraints;

import model.workflow.Workflow;
import model.workflow.fitness.util.FitnessUtil;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.IGuidanceFunction;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.interpreter.guidance.Solution;

public class ActivityHasOperation implements IGuidanceFunction {
	
	/**
	 * Constraint for checking if an activity holds at least one operation
	 * This is necessary to be a valid activity
	 * The goal is to count the activities that don't contain at least one operation.
	 * If the count is reduced to 0, the constraint is fulfilled.
	 * @param Solution the instance model containing all activities
	 * @return The amount of activities that don't contain at least one operation.
	 */
	@Override
	public double computeFitness(Solution solution) {
		Workflow workflow = (Workflow) solution.getModel();
		
		return workflow.getActivities().stream()
		        .filter(activity -> FitnessUtil.getAllOperationsFromActivity(activity).isEmpty())
		        .count();
	}

	@Override
	public String getName() {
		return "Minimise amount of activities that do not have an operation";
	}
}
