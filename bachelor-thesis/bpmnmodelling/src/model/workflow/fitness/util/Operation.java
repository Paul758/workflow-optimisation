package model.workflow.fitness.util;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import model.workflow.AlternativeOperation;
import model.workflow.Task;

/**
 * A class to construct the operations based on the modeled task structure
 * An operation contains exactly one Task that represents the output and 
 * a set of tasks that represent the input.
 * The operation taskSet is the union of the input and the output.
 */
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
	
	@Override
	public boolean equals(Object other) {
		if(!(other instanceof Operation)) {
			return false;
		}
		
		Operation otherOperation = (Operation) other;
		return this.operationTaskSet.equals(otherOperation.getTaskSet());
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(operationTaskSet);
	}
}
