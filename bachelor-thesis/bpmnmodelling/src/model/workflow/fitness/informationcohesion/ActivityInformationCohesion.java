package model.workflow.fitness.informationcohesion;


import java.util.List;
import java.util.Set;
import model.workflow.Activity;
import model.workflow.Task;
import model.workflow.fitness.FitnessUtil;


public class ActivityInformationCohesion {

	public double calculateActivityInformationCohesion(Activity activity) {
		
			List<Task> tasks = FitnessUtil.getTasksFromActivity(activity);
			double taskInIntersectionCounter = 0;
			double taskAmount = tasks.size();
			
			//Return 0 if there is no task
			if(taskAmount == 0) {
				return 0;
			}
			
			
			for (int i = 0; i < tasks.size(); i++) {
				Task pTask = tasks.get(i);
				for (int j = 0; j < tasks.size(); j++) {
					Task qTask = tasks.get(j);
					
					if (pTask.equals(qTask)) {
						continue;
					}
					
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
					
					
					//Build intersection
					pOperation.retainAll(qOperation);
					
					if(pOperation.contains(pTask)) {
						taskInIntersectionCounter++;
					}
				}
			}
			
		double activityInformationCohesion = taskInIntersectionCounter / taskAmount;
				
		return activityInformationCohesion;
	}

}
