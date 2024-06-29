package model.workflow.fitness;

import java.util.List;

import model.workflow.Activity;
import model.workflow.InformationObject;
import model.workflow.Task;
import model.workflow.Workflow;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.IGuidanceFunction;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.interpreter.guidance.Solution;

public class MaximiseTasksInActivity implements IGuidanceFunction {

	@Override
	public double computeFitness(Solution solution) {
		
		System.out.println("computing fitness");
		
		Workflow workflowModel = (Workflow) solution.getModel();
		List<Activity> activities = workflowModel.getActivities();
		int totalTasks = 0;
		int totalActivities = activities.size();
		
		for (Activity activity : activities) {
			List<InformationObject> informationObjects = activity.getEncapsulates();
			
			for (InformationObject informationObject : informationObjects) {
				if(informationObject instanceof Task) {
					totalTasks++;
				}
			}
		}
		
		double activityWeight = 1.0d;
		double taskWeight = 0.1d;
		
		double fitness = (totalTasks * taskWeight) - (totalActivities * activityWeight);
		
		return fitness;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Maximise amount of tasks in an activity";
	}

}
