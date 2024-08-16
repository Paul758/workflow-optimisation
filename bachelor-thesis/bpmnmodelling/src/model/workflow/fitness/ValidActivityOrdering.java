package model.workflow.fitness;

import java.util.ArrayList;
import java.util.List;

import model.workflow.Activity;
import model.workflow.InformationObject;
import model.workflow.Workflow;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.IGuidanceFunction;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.interpreter.guidance.Solution;

public class ValidActivityOrdering implements IGuidanceFunction {
	
	/**
	 * Calculate, if the workflow has a valid ordering of activities
	 * Loop over all activities one by one. Gather every Task in the activity,
	 * if a task has no source, it is a starting activity and can be marked as done
	 * if a task is dependent on other tasks, then these tasks already need to
	 * be in the tasksDone list.
	 * If this is not the case, the outOfOrderCounter is increased
	 * If the activities are ordered, the outOfOrderCounter will be 0,
	 * then a valid ordering is given.
	 */
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
					System.out.println("Out of order activity found, the current tasks Done are: " + tasksDone.toString() + ". The task that is out of order: " + current.getName());
					outOfOrderCounter++;
				}
				tasksDone.add(current);
				
			}
			
		}
		for(Activity activity : activities) {
			System.out.println("The tasks in this activity are: " + activity.getEncapsulates());
		}
		return outOfOrderCounter;
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
}
