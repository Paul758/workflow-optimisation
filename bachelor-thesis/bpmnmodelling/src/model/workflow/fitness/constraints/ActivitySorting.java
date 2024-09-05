package model.workflow.fitness.constraints;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import model.workflow.Activity;
import model.workflow.InformationObject;
import model.workflow.Workflow;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.IGuidanceFunction;
import uk.ac.kcl.inf.mdeoptimiser.libraries.core.optimisation.interpreter.guidance.Solution;

public class ActivitySorting implements IGuidanceFunction {
	
	/**
	 * Constraint for checking if the activities of a process can be executed in a feasible order.
	 * The activities of a feasible process model can be seen as an acyclic graph. If a topological sorting of
	 * the activities is possible, the activities have an order, in which they can be executed.
	 * @param Solution The instance model containing all activities
	 * @return If a topological sorting is possible return 0, else 1. This is a binary constraint
	 */
	@Override
	public double computeFitness(Solution solution) {
		Workflow workflow = (Workflow) solution.getModel();
		
		HashMap<Activity, HashSet<Activity>> adjacencyList =  createDependencyList(workflow);
		
		if(topSort(adjacencyList)) {
			return 0;
		}
		return 1;
	}

	private boolean topSort(HashMap<Activity, HashSet<Activity>> adjacencyList) {
		HashMap<Activity, Integer> inDegree = new HashMap<Activity, Integer>();
		
		for(Activity activity : adjacencyList.keySet()) {
			inDegree.put(activity, 0);
		}
		
		for(Activity activity : adjacencyList.keySet()) {
			for(Activity dependendsOn : adjacencyList.get(activity)) {
				inDegree.put(dependendsOn, inDegree.get(dependendsOn) + 1);
			}

		}
		
		Queue<Activity> queue = new LinkedList<>();
		for(Activity activity : inDegree.keySet()) {
			if(inDegree.get(activity) == 0) {
				queue.add(activity);
			}
		}
		
		List<Activity> sortedOrder = new ArrayList<>();
		while(!queue.isEmpty()) {
			Activity activity = queue.poll();
			sortedOrder.add(activity);
			
			for(Activity dependent : adjacencyList.get(activity)) {
				inDegree.put(dependent, inDegree.get(dependent) - 1);
				if(inDegree.get(dependent) == 0) {
					queue.add(dependent);
				}
			}
		}
		
		//Check if a cycle is contained
		if(sortedOrder.size() != adjacencyList.size()) {
			//Cycle detected, there exists no valid ordering
			return false;
		}
		//System.out.println(sortedOrder.toString());
		return true;
		
	}

	private HashMap<Activity, HashSet<Activity>> createDependencyList(Workflow workflow) {
		List<Activity> activities = (List<Activity>) workflow.getActivities();
		HashMap<Activity, HashSet<Activity>> adjacencyList = new HashMap<Activity, HashSet<Activity>>();
		
		for(Activity activity : activities) {
			adjacencyList.putIfAbsent(activity, new HashSet<Activity>());
		}
		
		for(Activity activity : activities) {
			
			List<InformationObject> informationObjects = activity.getEncapsulates();
			for(InformationObject infoObject : informationObjects) {
				
				for(InformationObject dependencyObject : infoObject.getSource()) {
					
					Activity possibleDependantActivity = dependencyObject.getIsEncapsulatedBy();
					//Null check if informationObject is not encapsulated by an activity
					if(possibleDependantActivity == null) {
						continue;
					}
					
					if(activity.equals(possibleDependantActivity)) {
						continue;
					}
					//Dependency found
					HashSet<Activity> dependencyList = adjacencyList.get(activity);
					dependencyList.add(possibleDependantActivity);
					adjacencyList.put(activity, dependencyList);
					
				}
			}
		}
		
		return adjacencyList;	
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
