package model.workflow.fitness.coupling;

import model.workflow.fitness.cohesion.ProcessCohesion;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.IGuidanceFunction;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.interpreter.guidance.Solution;

public class ProcessCouplingCohesionRatio implements IGuidanceFunction {

	ProcessCoupling processCoupling = new ProcessCoupling();
	ProcessCohesion processCohesion = new ProcessCohesion();
	
	/**
	 * The Coupling / Cohesion Ratio (CCR) is defined as the ProcessCoupling / ProcessCohesion
	 * @param Solution the instance model for which the CCR should be calculated
	 * @return The CCR of the instance model
	 */
	@Override
	public double computeFitness(Solution solution) {
		double processCouplingValue = processCoupling.computeFitness(solution);	
		double processCohesionValue = processCohesion.computeFitness(solution);
		
		if(processCohesionValue == 0) {
			return 0;
		}
		return processCouplingValue / processCohesionValue;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
