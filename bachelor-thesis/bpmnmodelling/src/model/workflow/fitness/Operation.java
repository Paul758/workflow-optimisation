package model.workflow.fitness;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.workflow.AlternativeOperation;
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
	
	public Operation(Task task, AlternativeOperation alternativePath) {
		output = task;
		input = new HashSet<Task>();
		operationTaskSet = new HashSet<Task>();
		
		input.addAll(alternativePath.getInputTasks());
		
		operationTaskSet.add(output);
		operationTaskSet.addAll(input);
	}
	
	private void initializeInput(Task task) {
		input = FitnessUtil.getInputTasks(task);
	}
	
	private void constructOperation(Task task) {	
		operationTaskSet.add(task);
		operationTaskSet.addAll(input);
	
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
	
	public Set<Task> getTaskSet() {
		return operationTaskSet;
	}
}
