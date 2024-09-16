package model.workflow.fitness.cohesion;

import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.IGuidanceFunction;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.interpreter.guidance.Solution;

/* MDE Optimiser's maximization of an objective does not seem to work.
 * For a pareto optimization problem the maximization is necessary, so calculate (1 - objective value) to achieve the maximization. 
 */
public class ProcessCohesionMaximization extends ProcessCohesion implements IGuidanceFunction {
	
	@Override
	public double computeFitness(Solution solution) {
		
		return 1 - super.computeFitness(solution);
	}
	
}
