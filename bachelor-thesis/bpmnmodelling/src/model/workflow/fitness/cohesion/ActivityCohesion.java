package model.workflow.fitness.cohesion;

import model.workflow.Activity;
import model.workflow.fitness.informationcohesion.ActivityInformationCohesion;
import model.workflow.fitness.relationcohesion.ActivityRelationCohesion;

public class ActivityCohesion {

	public double calculateActivityCohesion(Activity activity) {
		ActivityInformationCohesion aic = new ActivityInformationCohesion();
		ActivityRelationCohesion arc = new ActivityRelationCohesion();
		
		double activityCohesion = aic.calculateActivityInformationCohesion(activity) * arc.calculateActivityRelationCohesion(activity);
		
		return activityCohesion;
	}

}
