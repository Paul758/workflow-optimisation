package model.workflow.fitness;

import model.workflow.Workflow;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.IGuidanceFunction;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.interpreter.guidance.Solution;

public class MinimiseObjectsWithoutActivity implements IGuidanceFunction {

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
