package model.workflow.fitness.coupling;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Method;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.workflow.Activity;
import model.workflow.AlternativeOperation;
import model.workflow.Parallel;
import model.workflow.Task;
import model.workflow.Workflow;
import model.workflow.WorkflowFactory;
import model.workflow.fitness.cohesion.ProcessCohesion;

public class ProcessCouplingCohesionRatioTest {
	ProcessCohesion processCohesion;
	ProcessCoupling processCoupling;
	
	Workflow workflow;
	Activity activity1;
	Activity activity2;
	Activity activity3;
	Activity activity4;
	Activity activity5;
	
	Task task1;
	Task task2;
	Task task3;
	Task task4;
	Task task5;
	Task task6;
	Task task7;
	Task task8;
	Task task9;
	Task task10;
	Task task11;
	Task task12;
	Task task13;
	Task task14;
	Task task15;
	Task task16;
	Task task17;
	Task task18;
	Task task19;
	Task task20;
	Task task21;
	Task task22;
	Task task23;
	Task task24;
	Task task25;
	Task task26;
	Task task27;
	
	AlternativeOperation altOperation261;
	AlternativeOperation altOperation262;
	
	AlternativeOperation altOperation241;
	AlternativeOperation altOperation242;
	
	AlternativeOperation altOperation271;
	AlternativeOperation altOperation272;
	
	@BeforeEach
	void setUp() {
		System.out.println("Run Before");
		processCoupling = new ProcessCoupling();
		processCohesion = new ProcessCohesion();
		
		WorkflowFactory factory = WorkflowFactory.eINSTANCE;
		
		workflow = factory.createWorkflow();
		
		activity1 = factory.createActivity();
		activity1.setName("1");
		
		activity2 = factory.createActivity();
		activity2.setName("2");
		
		activity3 = factory.createActivity();
		activity3.setName("3");
		
		activity4 = factory.createActivity();
		activity4.setName("4");
		
		activity5 = factory.createActivity();
		activity5.setName("5");
		
		
		task1 = factory.createTask();
		task1.setName("1");
		
		task2 = factory.createTask();
		task2.setName("2");
		
		task3 = factory.createTask();
		task3.setName("3");
		
		task4 = factory.createTask();
		task4.setName("4");
		
		task5 = factory.createTask();
		task5.setName("5");
		
		task6 = factory.createTask();
		task6.setName("6");
		
		task7 = factory.createTask();
		task7.setName("7");
		
		task8 = factory.createTask();
		task8.setName("8");
		
		task9 = factory.createTask();
		task9.setName("9");
		
		task10 = factory.createTask();
		task10.setName("10");
		
		task11 = factory.createTask();
		task11.setName("11");
		
		task12 = factory.createTask();
		task12.setName("12");
		
		task13 = factory.createTask();
		task13.setName("13");
		
		task14 = factory.createTask();
		task14.setName("14");
		
		task15 = factory.createTask();
		task15.setName("15");
		
		task16 = factory.createTask();
		task16.setName("16");
		
		task17 = factory.createTask();
		task17.setName("17");
		
		task18 = factory.createTask();
		task18.setName("18");
		
		task19 = factory.createTask();
		task19.setName("19");
		
		task20 = factory.createTask();
		task20.setName("20");
		
		task21 = factory.createTask();
		task21.setName("21");
		
		task22 = factory.createTask();
		task22.setName("22");
		
		task23 = factory.createTask();
		task23.setName("23");
		
		task24 = factory.createTask();
		task24.setName("24");
		
		task25 = factory.createTask();
		task25.setName("25");
		
		task26 = factory.createTask();
		task26.setName("26");
		
		task27 = factory.createTask();
		task27.setName("27");
		
		altOperation261 = factory.createAlternativeOperation();
		altOperation262 = factory.createAlternativeOperation();
		
		altOperation241 = factory.createAlternativeOperation();
		altOperation242 = factory.createAlternativeOperation();
		
		altOperation271 = factory.createAlternativeOperation();
		altOperation272 = factory.createAlternativeOperation();
		
	}
	
	
	
	
	@Test
	void testProcessCouplingCohesionRatio() throws Exception {
		//Setup activity 1
		activity1.getEncapsulates().add(task1);
		activity1.getEncapsulates().add(task2);
		activity1.getEncapsulates().add(task3);
		activity1.getEncapsulates().add(task10);
		
		task1.getSink().add(task3);
		task2.getSink().add(task3);
		
		task3.getSource().add(task1);
		task3.getSource().add(task2);
		task3.getSink().add(task10);
		task3.getSink().add(task20);
		task3.getSink().add(task23);
		task3.getSink().add(task25);
		
		task10.getSource().add(task3);
		task10.getSink().add(task13);
		task10.getSink().add(task14);
		
		//Setup activity 2
		activity2.getEncapsulates().add(task9);
		activity2.getEncapsulates().add(task11);
		activity2.getEncapsulates().add(task13);
		activity2.getEncapsulates().add(task14);
		activity2.getEncapsulates().add(task15);
		
		
		task9.getSink().add(task13);
		
		task11.getSink().add(task14);
		
		task13.getSource().add(task9);
		task13.getSource().add(task10);
		task13.getSink().add(task15);
		
		task14.getSource().add(task10);
		task14.getSource().add(task11);
		task14.getSink().add(task15);
		
		task15.getSource().add(task13);
		task15.getSource().add(task14);
		task15.getSink().add(task16);
		task15.getSink().add(task21);
		
		//Setup activity 3
		activity3.getEncapsulates().add(task4);
		activity3.getEncapsulates().add(task5);
		activity3.getEncapsulates().add(task6);
		activity3.getEncapsulates().add(task7);
		activity3.getEncapsulates().add(task8);
		activity3.getEncapsulates().add(task12);
		activity3.getEncapsulates().add(task19);
		
		task4.getSink().add(task8);
		task5.getSink().add(task8);
		
		task8.getSource().add(task4);
		task8.getSource().add(task5);
		task8.getSink().add(task12);
		
		task6.getSink().add(task8);
		
		task7.getSink().add(task12);
		task7.getSink().add(task16);
		task7.getSink().add(task19);
		
		task12.getSource().add(task6);
		task12.getSource().add(task7);
		task12.getSource().add(task8);
		
		task12.getSink().add(task16);
		task12.getSink().add(task19);
		task12.getSink().add(task25);
		
		task19.getSource().add(task12);
		task19.getSource().add(task7);
		task19.getSink().add(task26);
		
		//Setup activity 4
		activity4.getEncapsulates().add(task22);
		activity4.getEncapsulates().add(task23);
		activity4.getEncapsulates().add(task26);
		
		task22.getSink().add(task26);
		
		task23.getSource().add(task3);
		task23.getSink().add(task26);
		
		task26.getSource().add(task19);
		task26.getSource().add(task22);
		task26.getSource().add(task23);
		
		task26.getSink().add(task27);
		
		//Alternative Operations for task 26
		altOperation261.getInputTasks().add(task19);
		
		altOperation262.getInputTasks().add(task19);
		altOperation262.getInputTasks().add(task22);
		altOperation262.getInputTasks().add(task23);
		
		task26.getAlternativePaths().add(altOperation261);
		task26.getAlternativePaths().add(altOperation262);
		
		//Setup activity 5
		activity5.getEncapsulates().add(task16);
		activity5.getEncapsulates().add(task17);
		activity5.getEncapsulates().add(task18);
		activity5.getEncapsulates().add(task20);
		activity5.getEncapsulates().add(task21);
		activity5.getEncapsulates().add(task24);
		activity5.getEncapsulates().add(task25);
		activity5.getEncapsulates().add(task27);
		
		task16.getSource().add(task7);
		task16.getSource().add(task12);
		task16.getSource().add(task15);
		
		task16.getSink().add(task21);
		task16.getSink().add(task24);
		
		task17.getSink().add(task20);
		task17.getSink().add(task25);
		
		task18.getSink().add(task25);
		
		task20.getSource().add(task3);
		task20.getSource().add(task17);
		task20.getSink().add(task24);
		
		task21.getSource().add(task15);
		task21.getSource().add(task16);
		task21.getSink().add(task24);
		
		task24.getSource().add(task16);
		task24.getSource().add(task20);
		task24.getSource().add(task21);
		task24.getSink().add(task27);
		
		altOperation241.getInputTasks().add(task16);
		
		altOperation242.getInputTasks().add(task20);
		altOperation242.getInputTasks().add(task21);
		
		task24.getAlternativePaths().add(altOperation241);
		task24.getAlternativePaths().add(altOperation242);
		
		task25.getSource().add(task3);
		task25.getSource().add(task12);
		task25.getSource().add(task17);
		task25.getSource().add(task18);
		task25.getSink().add(task27);
		
		task27.getSource().add(task12);
		task27.getSource().add(task24);
		task27.getSource().add(task25);
		task27.getSource().add(task26);
		
		altOperation271.getInputTasks().add(task12);
		
		altOperation272.getInputTasks().add(task24);
		altOperation272.getInputTasks().add(task25);
		altOperation272.getInputTasks().add(task26);
		
		task27.getAlternativePaths().add(altOperation271);
		task27.getAlternativePaths().add(altOperation272);
		
		
		workflow.getActivities().add(activity1);
		workflow.getActivities().add(activity2);
		workflow.getActivities().add(activity3);
		workflow.getActivities().add(activity4);
		workflow.getActivities().add(activity5);
				
		double cohesionValue = 0;
		double couplingValue = 0;
				
		Method calculateCohesionValue = ProcessCohesion.class.getDeclaredMethod("calculateProcessCohesion", Workflow.class);
		calculateCohesionValue.setAccessible(true);	
		cohesionValue = (double) calculateCohesionValue.invoke(processCohesion, workflow);
		
		Method calculateCouplingValue = ProcessCoupling.class.getDeclaredMethod("calculateProcessCoupling", Workflow.class);
		calculateCouplingValue.setAccessible(true);	
		couplingValue = (double) calculateCouplingValue.invoke(processCoupling, workflow);
				
		System.out.println("Process CouplingCohesionRatio is: " + (couplingValue / cohesionValue));
		double result = 0;
		assertEquals(result, couplingValue / cohesionValue, 0.01);
	}
	
	@Test
	void testProcessCouplingCohesionRatioWorkflow() throws Exception {
		//Setup activity 1
		activity1.getEncapsulates().add(task1);
		activity1.getEncapsulates().add(task2);
		activity1.getEncapsulates().add(task3);
		
		task1.getSink().add(task3);
		task2.getSink().add(task3);
		
		task3.getSource().add(task1);
		task3.getSource().add(task2);
		task3.getSink().add(task10);
		
		//Setup activity 2
		activity2.getEncapsulates().add(task9);
		activity2.getEncapsulates().add(task10);
		activity2.getEncapsulates().add(task11);
		activity2.getEncapsulates().add(task13);
		activity2.getEncapsulates().add(task14);
		activity2.getEncapsulates().add(task15);
		
		task10.getSource().add(task3);
		task10.getSink().add(task13);
		task10.getSink().add(task14);
		
		task9.getSink().add(task13);
		task11.getSink().add(task14);
		
		task13.getSource().add(task9);
		task13.getSource().add(task10);
		task13.getSink().add(task15);
		
		task14.getSource().add(task10);
		task14.getSource().add(task11);
		task14.getSink().add(task15);
		
		task15.getSource().add(task13);
		task15.getSource().add(task14);
		
		
		workflow.getActivities().add(activity1);
		workflow.getActivities().add(activity2);
				
		double cohesionValue = 0;
		double couplingValue = 0;
				
		Method calculateCohesionValue = ProcessCohesion.class.getDeclaredMethod("calculateProcessCohesion", Workflow.class);
		calculateCohesionValue.setAccessible(true);	
		cohesionValue = (double) calculateCohesionValue.invoke(processCohesion, workflow);
		
		Method calculateCouplingValue = ProcessCoupling.class.getDeclaredMethod("calculateProcessCoupling", Workflow.class);
		calculateCouplingValue.setAccessible(true);	
		couplingValue = (double) calculateCouplingValue.invoke(processCoupling, workflow);
				
		System.out.println("Process CouplingCohesionRatio is: " + (couplingValue / cohesionValue));
		double result = (1.0d / (5.0d/28.0d));
		assertEquals(result, couplingValue / cohesionValue, 0.01);
	}
}
