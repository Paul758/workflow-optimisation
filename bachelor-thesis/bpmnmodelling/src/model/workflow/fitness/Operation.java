package model.workflow.fitness;

import java.util.HashSet;
import java.util.Set;

import model.workflow.Task;

public class Operation {
	
	private Task output;
	private Set<Task> input;
	
	private Set<Task> operationTaskSet;
	
	public Operation(Task task) {
		output = task;
		input = new HashSet<Task>();
		operationTaskSet = new HashSet<Task>();
		
		initializeInput(task);
		constructOperation(task);
	}
	
	private void initializeInput(Task task) {
		input = FitnessUtil.getInputTasks(task);
	}
	
	private void constructOperation(Task task) {	
		operationTaskSet.add(task);
		operationTaskSet.addAll(input);
	
	}
	
	public Set<Task> getTaskSet() {
		return operationTaskSet;
	}
	
	public boolean hasNoInput() {
		return input.isEmpty();
	}

	public Set<Task> intersect(Operation other) {
		Set<Task> otherTaskSet = other.getTaskSet();
		
		Set<Task> intersectionSet = new HashSet<Task>(operationTaskSet);
		intersectionSet.retainAll(otherTaskSet);
		
		return intersectionSet;
	}

	public Task getOutput() {
		return this.output;
	}
}
