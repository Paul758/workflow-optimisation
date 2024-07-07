package model.workflow.fitness;

import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.IGuidanceFunction;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.interpreter.guidance.Solution;

public class ActivityCohesion implements IGuidanceFunction {

	@Override
	public double computeFitness(Solution solution) {
		ActivityInformationCohesion aic = new ActivityInformationCohesion();
		ActivityRelationCohesion arc = new ActivityRelationCohesion();
		
		double activityCohesion = aic.computeFitness(solution) * arc.computeFitness(solution);
		
		return activityCohesion;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
