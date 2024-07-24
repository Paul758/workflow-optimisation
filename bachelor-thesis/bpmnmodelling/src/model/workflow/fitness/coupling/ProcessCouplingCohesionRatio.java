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
		//System.out.println("The processCouplingValue in ratio class is: " + processCouplingValue);
		double processCohesionValue = processCohesion.computeFitness(solution);
		//System.out.println("The processCohesionValue in ratio class is: " + processCohesionValue);
		
		
		if(processCohesionValue == 0) {
			System.out.println("The processCohesionValue is 0, so for this run the processCouplingCohesionRatio is also 0");
			return 0;
		}
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("The processCouplingValue in ratio class is: " + processCouplingValue);
		System.out.println("The processCohesionValue in ratio class is: " + processCohesionValue);
		System.out.println("The processCouplingCohesionRatio for this model is " + processCouplingValue / processCohesionValue);
		System.out.println(" ");
		return processCouplingValue / processCohesionValue;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
