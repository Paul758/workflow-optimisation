package model.workflow.fitness.relationcohesion;


import java.util.List;
import java.util.Set;
import model.workflow.Activity;
import model.workflow.Task;
import model.workflow.fitness.FitnessUtil;


public class ActivityRelationCohesion {

	public double calculateActivityRelationCohesion(Activity activity) {
		List<Task> tasks = FitnessUtil.getTasksFromActivity(activity);
		double relationCounter = 0;
		double taskAmount = tasks.size();
		//If there is one task or less return 0
		if(taskAmount <= 1) {
			return 0;
		}
		
		//Compare all tasks to each other
		for (int i = 0; i < tasks.size(); i++) {
			Task pTask = tasks.get(i);
			
			for(int j = 0; j < tasks.size(); j++) {
				Task qTask = tasks.get(j);
				
				//Skip same tasks
				if(pTask.equals(qTask)) {
					continue;
				}
				//Construct operations
				Set<Task> pOperation = FitnessUtil.getInputTasks(pTask);
				if(pOperation.isEmpty()) {
					continue;
				}
				pOperation.add(pTask);
			
				Set<Task> qOperation = FitnessUtil.getInputTasks(qTask);
				if(qOperation.isEmpty()) {
					continue;
				}
				qOperation.add(qTask);
				
				pOperation.retainAll(qOperation);
				
				
				if(!pOperation.isEmpty()) {
					relationCounter++;
					
				}
			}
		}
			
		//Calculate activity relation cohesion value for this activity
		double activityRelationCohesion = relationCounter / (taskAmount * (taskAmount - 1));
	
		return activityRelationCohesion;
	}
	

}
