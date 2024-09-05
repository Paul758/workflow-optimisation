package model.workflow.fitness;

import java.util.List;

import model.workflow.Activity;
import model.workflow.InformationObject;
import model.workflow.Task;
import model.workflow.Workflow;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.IGuidanceFunction;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.interpreter.guidance.Solution;

public class InformationObjectsUsedInOperation implements IGuidanceFunction {

	@Override
	public double computeFitness(Solution solution) {
		Workflow workflow = (Workflow) solution.getModel();
		
		List<Activity> activities = workflow.getActivities();
		
		int objectCounter = 0;
		
		for(Activity activity : activities) {
			List<Task> tasks = FitnessUtil.getTasksFromActivity(activity);
			List<Operation> operations = FitnessUtil.getAllOperationsFromActivity(activity);
			boolean taskInOperation = false;
			
			for(Task task : tasks) {
				Task currentTask = task;
				taskInOperation = false;
				for(Operation operation : operations) {
					if(operation.getTaskSet().contains(task)) {
						taskInOperation = true;
						break;
					}
				}
				if(!taskInOperation) {
					objectCounter++;
				}
				
			}
			
		}
		
		return objectCounter;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
