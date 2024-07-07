package model.workflow.fitness.coupling;

import model.workflow.fitness.cohesion.ProcessCohesion;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.IGuidanceFunction;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.interpreter.guidance.Solution;

public class ProcessCouplingCohesionRatio implements IGuidanceFunction {

	ProcessCoupling processCoupling = new ProcessCoupling();
	ProcessCohesion processCohesion = new ProcessCohesion();
	
	@Override
	public double computeFitness(Solution solution) {
		double processCouplingValue = processCoupling.computeFitness(solution);
		double processCohesionValue = processCohesion.computeFitness(solution);
		
		return processCouplingValue / processCohesionValue;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
