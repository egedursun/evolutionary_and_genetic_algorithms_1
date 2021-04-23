/*
 * 		EGE DOĞAN DURSUN
 * 		05170000006
 * 
 * 		CEM ÇORBACIOĞLU
 * 		05130000242
 * 
 * 		EGE UNIVERSITY 
 * 		FACULTY OF ENGINEERING
 * 		COMPUTER ENGINEERING DEPARTMENT
 * 		2019 - 2020 - SPRING
 * 		EVOLUTIONARY COMPUTATION
 * 		TERM PROJECT : BASE STATION LOCATING OPTIMIZATION
 * 		DATE OF LATEST UPDATE : MAY 6, 2020 - TUESDAY
 * 
 */


package tests;

import java.util.ArrayList;

import continuous_optimization.DEFitness;
import continuous_optimization.DEIndividual;
import model.Problem;
import opt_builder.OptimizationBuilder;
import support.MathSupport;
import support.PrintSupport;

public class COGeneralTest {

	public static void main(String[] args) {

		/*
		 * 	THIS CLASS IS USED FOR TESTING THE USE OF A CONTINUOUS OPTIMIZATION ALGORITHM FOR OPTIMIZING 
		 * 	THE PROBLEM THAT WAS MENTIONED IN "HOMEWORK PART 3 : CITY B"
		 * 	
		 * 	USED METHOD : DIFFERENTIAL EVOLUTION
		 * 	
		 * 	I HAVE USED 5 DIFFERENT MUTATION METHODS : 
		 * 	1) DE/RAND/1
		 * 	2) DE/RAND/2
		 * 	3) DE/BEST/1
		 * 	4) DE/BEST/2
		 * 	5) DE/CURRENT_TO_BEST/1
		 *
		 *	BY USING THIS PAGE, YOU CAN TEST ALL OF THESE DIFFERENT MUTATION METHODS ON THE SAME PROBLEM.
		 * 
		 */
		
		
		//Continuous Optimization Hyper-parameters
		int populationSize = 100;
		int maxGenerations = 2000;
		double F = 0.1;
		double crossoverRate = 0.9;
		
		//Multi-Solution Hyper-parameters
		double parameterRandomizationTimes = 4;
		double problemSolutionTimes = 25;
		
		//Achieve the problem from global variables class
		Problem problemB = GlobalDEVariables.problemB;
		problemB.showCustomerCoordinates();
		
		//Define the wrapper arrays that will hold the metrics from multiple calculations with multiple parameter sets
		ArrayList<ArrayList<Double>> multiMetrics1 = new ArrayList<ArrayList<Double>>();
		ArrayList<ArrayList<Double>> multiMetrics2 = new ArrayList<ArrayList<Double>>();
		ArrayList<ArrayList<Double>> multiMetrics3 = new ArrayList<ArrayList<Double>>();
		ArrayList<ArrayList<Double>> multiMetrics4 = new ArrayList<ArrayList<Double>>();
		ArrayList<ArrayList<Double>> multiMetrics5 = new ArrayList<ArrayList<Double>>();
		
		ArrayList<ArrayList<Double>> multiResultsAvg1 = new ArrayList<ArrayList<Double>>();
		ArrayList<ArrayList<Double>> multiResultsAvg2 = new ArrayList<ArrayList<Double>>();
		ArrayList<ArrayList<Double>> multiResultsAvg3 = new ArrayList<ArrayList<Double>>();
		ArrayList<ArrayList<Double>> multiResultsAvg4 = new ArrayList<ArrayList<Double>>();
		ArrayList<ArrayList<Double>> multiResultsAvg5 = new ArrayList<ArrayList<Double>>();
		
		
		//Run the continuous optimization algorithm
		for(int i = 0; i<parameterRandomizationTimes; i++) {
			
			//For each parameter set, define 5 array lists that will hold the result metrics of 5 different differential evolution mutation methods.
			ArrayList<Double> resultsAvgFitness1 = new ArrayList<Double>();
			ArrayList<Double> resultsAvgFitness2 = new ArrayList<Double>();
			ArrayList<Double> resultsAvgFitness3 = new ArrayList<Double>();
			ArrayList<Double> resultsAvgFitness4 = new ArrayList<Double>();
			ArrayList<Double> resultsAvgFitness5 = new ArrayList<Double>();
			
			//Solve the problem for each of the parameter set , for defined number of times.
			for(int j = 0; j<problemSolutionTimes; j++) {
				
				//Run continuous optimization algorithm to run for predefined maximum epochs (for each of the differential evolution mutation methods)
				ArrayList<DEIndividual> population1 = OptimizationBuilder.runContinuousOptimization_DErand1(problemB, populationSize, maxGenerations, F, crossoverRate);
				ArrayList<DEIndividual> population2 = OptimizationBuilder.runContinuousOptimization_DErand2(problemB, populationSize, maxGenerations, F, crossoverRate);
				ArrayList<DEIndividual> population3 = OptimizationBuilder.runContinuousOptimization_DEbest1(problemB, populationSize, maxGenerations, F, crossoverRate);
				ArrayList<DEIndividual> population4 = OptimizationBuilder.runContinuousOptimization_DEbest2(problemB, populationSize, maxGenerations, F, crossoverRate);
				ArrayList<DEIndividual> population5 = OptimizationBuilder.runContinuousOptimization_DEcurToBest1(problemB, populationSize, maxGenerations, F, crossoverRate);
				
				//Calculate the fitness levels for each of the mutation methods after maximum epochs reached.
				double fitness1 = DEFitness.getAverageDEPopulationFitness(population1);
				double fitness2 = DEFitness.getAverageDEPopulationFitness(population2);
				double fitness3 = DEFitness.getAverageDEPopulationFitness(population3);
				double fitness4 = DEFitness.getAverageDEPopulationFitness(population4);
				double fitness5 = DEFitness.getAverageDEPopulationFitness(population5);
				
				//Save the fitness scores to the different arraylists
				resultsAvgFitness1.add(fitness1);
				resultsAvgFitness2.add(fitness2);
				resultsAvgFitness3.add(fitness3);
				resultsAvgFitness4.add(fitness4);
				resultsAvgFitness5.add(fitness5);
				
			}
			
			//Calculate the metrics for the first mutation method : DE/RAND/1 and save them to the corresponding multi-metrics array
			double average = MathSupport.average(resultsAvgFitness1);
			double bestResult = MathSupport.getBestResult(resultsAvgFitness1);
			double worstResult = MathSupport.getWorstResult(resultsAvgFitness1);
			double median = MathSupport.median(resultsAvgFitness1);
			double stdDev = MathSupport.sd(resultsAvgFitness1);
			
			ArrayList<Double> metrics1 = new ArrayList<Double>();
			metrics1.add(average);
			metrics1.add(stdDev);
			metrics1.add(bestResult);
			metrics1.add(worstResult);
			metrics1.add(median);
			
			multiMetrics1.add(metrics1);
			multiResultsAvg1.add(resultsAvgFitness1);
			
			
			//Calculate the metrics for the first mutation method : DE/RAND/2 and save them to the corresponding multi-metrics array
			average = MathSupport.average(resultsAvgFitness2);
			bestResult = MathSupport.getBestResult(resultsAvgFitness2);
			worstResult = MathSupport.getWorstResult(resultsAvgFitness2);
			median = MathSupport.median(resultsAvgFitness2);
			stdDev = MathSupport.sd(resultsAvgFitness2);
			
			ArrayList<Double> metrics2 = new ArrayList<Double>();
			metrics2.add(average);
			metrics2.add(stdDev);
			metrics2.add(bestResult);
			metrics2.add(worstResult);
			metrics2.add(median);
			
			multiMetrics2.add(metrics2);
			multiResultsAvg2.add(resultsAvgFitness2);
			
			
			//Calculate the metrics for the first mutation method : DE/BEST/1 and save them to the corresponding multi-metrics array
			average = MathSupport.average(resultsAvgFitness3);
			bestResult = MathSupport.getBestResult(resultsAvgFitness3);
			worstResult = MathSupport.getWorstResult(resultsAvgFitness3);
			median = MathSupport.median(resultsAvgFitness3);
			stdDev = MathSupport.sd(resultsAvgFitness3);
			
			ArrayList<Double> metrics3 = new ArrayList<Double>();
			metrics3.add(average);
			metrics3.add(stdDev);
			metrics3.add(bestResult);
			metrics3.add(worstResult);
			metrics3.add(median);
			
			multiMetrics3.add(metrics3);
			multiResultsAvg3.add(resultsAvgFitness3);
			
			
			//Calculate the metrics for the first mutation method : DE/BEST/2 and save them to the corresponding multi-metrics array
			average = MathSupport.average(resultsAvgFitness4);
			bestResult = MathSupport.getBestResult(resultsAvgFitness4);
			worstResult = MathSupport.getWorstResult(resultsAvgFitness4);
			median = MathSupport.median(resultsAvgFitness4);
			stdDev = MathSupport.sd(resultsAvgFitness4);
			
			ArrayList<Double> metrics4 = new ArrayList<Double>();
			metrics4.add(average);
			metrics4.add(stdDev);
			metrics4.add(bestResult);
			metrics4.add(worstResult);
			metrics4.add(median);
			
			multiMetrics4.add(metrics4);
			multiResultsAvg4.add(resultsAvgFitness4);
			
			
			//Calculate the metrics for the first mutation method : DE/CURRENT_TO_BEST/1 and save them to the corresponding multi-metrics array
			average = MathSupport.average(resultsAvgFitness5);
			bestResult = MathSupport.getBestResult(resultsAvgFitness5);
			worstResult = MathSupport.getWorstResult(resultsAvgFitness5);
			median = MathSupport.median(resultsAvgFitness5);
			stdDev = MathSupport.sd(resultsAvgFitness5);
			
			ArrayList<Double> metrics5 = new ArrayList<Double>();
			metrics5.add(average);
			metrics5.add(stdDev);
			metrics5.add(bestResult);
			metrics5.add(worstResult);
			metrics5.add(median);
			
			multiMetrics5.add(metrics5);
			multiResultsAvg5.add(resultsAvgFitness5);
			
			
		}
		
		//Show metrics for DE/RAND/1
		System.out.println("\n MUTATION METHOD -> DE/RAND/1 -> METRICS \n ");
		PrintSupport.printMultiMetrics(problemB, multiResultsAvg1, multiMetrics1);
		
		//Show metrics for DE/RAND/2
		System.out.println("\n MUTATION METHOD -> DE/RAND/2 -> METRICS \n ");
		PrintSupport.printMultiMetrics(problemB, multiResultsAvg2, multiMetrics2);
		
		//Show metrics for DE/BEST/1
		System.out.println("\n MUTATION METHOD -> DE/BEST/1 -> METRICS \n ");
		PrintSupport.printMultiMetrics(problemB, multiResultsAvg3, multiMetrics3);
		
		//Show metrics for DE/BEST/2
		System.out.println("\n MUTATION METHOD -> DE/BEST/2 -> METRICS \n ");
		PrintSupport.printMultiMetrics(problemB, multiResultsAvg4, multiMetrics4);
		
		//Show metrics for DE/CURRENT_TO_BEST/1
		System.out.println("\n MUTATION METHOD -> DE/CURRENT_TO_BEST/1 -> METRICS \n ");
		PrintSupport.printMultiMetrics(problemB, multiResultsAvg5, multiMetrics5);

	}

}
