package model.workflow.fitness;

import java.util.List;

import model.workflow.Activity;
import model.workflow.InformationObject;
import model.workflow.Workflow;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.IGuidanceFunction;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.interpreter.guidance.Solution;

public class KeepOrdering implements IGuidanceFunction {

	@Override
	public double computeFitness(Solution solution) {
		Workflow workflow = (Workflow) solution.getModel();
		int outOfOrderCounter = 0;
		
		List<Activity> activities = workflow.getActivities();
		
		for(Activity activity : activities) {
			List<InformationObject> informationObjects = activity.getEncapsulates();
			for(int i = 0; i < informationObjects.size() - 1; i++) {
				InformationObject cur = informationObjects.get(i);
				InformationObject next = informationObjects.get(i + 1);
				
				if(cur.getSink().contains(next)) {
					continue;
				}
				
				outOfOrderCounter++;
			}
		}
		return outOfOrderCounter;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
