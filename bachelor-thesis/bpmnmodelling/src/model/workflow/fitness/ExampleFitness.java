package model.workflow.fitness;

import java.util.List;

import model.workflow.Activity;
import model.workflow.Task;
import model.workflow.Workflow;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.IGuidanceFunction;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.interpreter.guidance.Solution;

public class ExampleFitness implements IGuidanceFunction {

	@Override
	public double computeFitness(Solution solution) {
		Workflow wf = (Workflow) solution.getModel();
		List<Activity> activities = wf.getActivities();
		
		for (Activity activity : activities) {
			List<Task> tasks = FitnessUtil.getTasksFromActivity(activity);
			for (Task task : tasks) {
				System.out.println("The source of " + task.toString() + "is " + task.getSource().toString());
			}
		}
		
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
