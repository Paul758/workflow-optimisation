package model.workflow.fitness;

import java.util.ArrayList;
import java.util.List;

import model.workflow.Activity;
import model.workflow.InformationObject;
import model.workflow.Task;
import model.workflow.Workflow;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.IGuidanceFunction;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.interpreter.guidance.Solution;

public class ValidActivityOrdering implements IGuidanceFunction {
	
	@Override
	public double computeFitness(Solution solution) {
		Workflow workflow = (Workflow) solution.getModel();
		int outOfOrderCounter = 0;
		
		List<Activity> activities = workflow.getActivities();
		List<InformationObject> tasksDone = new ArrayList<InformationObject>();
		
		
		for(int i = 0; i < activities.size(); i++) {
			List<InformationObject> tasksInActivity = activities.get(i).getEncapsulates();
			for(int j = 0; j < tasksInActivity.size(); j++) {
				InformationObject current = tasksInActivity.get(j);
				
				if(current.getSource().isEmpty()) {
					tasksDone.add(current);
					continue;
				}
				
				List<InformationObject> currentDependencies = current.getSource();
				
				for(InformationObject dependencyTask : currentDependencies) {
					if(tasksDone.contains(dependencyTask)) {
						continue;
					}
					outOfOrderCounter++;
				}
				tasksDone.add(current);
				
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
