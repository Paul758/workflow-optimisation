package model.workflow.fitness.cohesion;

import model.workflow.Activity;
import model.workflow.fitness.informationcohesion.ActivityInformationCohesion;
import model.workflow.fitness.relationcohesion.ActivityRelationCohesion;

public class ActivityCohesion {

	/**
	 * Calculate the activity cohesion by multiplying the information cohesion and the relation cohesion
	 * for each activity. For the process cohesion, the total value of all activity cohesion is divided by the
	 * amount of activities resulting in the mean.
	 * @param activity the activity which the cohesion is calculated for.
	 * @return the activity cohesion as a product of activity relation cohesion and activity information cohesion.
	 */
	public double calculateActivityCohesion(Activity activity) {
		ActivityInformationCohesion aic = new ActivityInformationCohesion();
		ActivityRelationCohesion arc = new ActivityRelationCohesion();
		
		double activityCohesion = aic.calculateActivityInformationCohesion(activity) * arc.calculateActivityRelationCohesion(activity);
		return activityCohesion;
	}

}
