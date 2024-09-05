package model.workflow.fitness.constraints;

import model.workflow.Workflow;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.IGuidanceFunction;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.interpreter.guidance.Solution;

public class MinimiseObjectsWithoutActivity implements IGuidanceFunction {
	
	/**
	 * Constraint for checking if an informationObject is encapsulated by an activity.
	 * The goal is to count the informationObjects that aren't encapsulated by an activity.
	 * If the count is reduced to 0, the constraint is fulfilled.
	 * @param Solution the instance model containing all information objects.
	 * @return The amount of informationObjects that aren't encapsulated by an activity.
	 */
	@Override
	public double computeFitness(Solution solution) {
		Workflow workflow = (Workflow) solution.getModel();
		
		return workflow.getInformationObjects().stream()
		        .filter(informationObject -> informationObject.getIsEncapsulatedBy() == null)
		        .count();
		
	}

	@Override
	public String getName() {
		return "Minimise InformationObjects that are not in an activity";
	}

}
