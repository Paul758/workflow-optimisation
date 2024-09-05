package model.workflow.fitness;

import model.workflow.Workflow;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.IGuidanceFunction;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.interpreter.guidance.Solution;

public class ActivityHasOperation implements IGuidanceFunction {
	
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
