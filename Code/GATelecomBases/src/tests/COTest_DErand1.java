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

public class COTest_DErand1 {

	public static void main(String[] args) {	
		
		/*
		 * 	THIS CLASS IS USED FOR TESTING THE USE OF A CONTINUOUS OPTIMIZATION ALGORITHM FOR OPTIMIZING 
		 * 	THE PROBLEM THAT WAS MENTIONED IN "HOMEWORK PART 3 : CITY B"
		 * 	
		 * 	USED METHOD : DIFFERENTIAL EVOLUTION
		 * 	
		 * 	IN THIS CLASS , THE MUTATION METHOD IS : 
		 * 	-> DE/RAND/1
		 *
		 *	BY USING THIS PAGE, YOU CAN TEST THE PERFORMANCE OF THIS MUTATION METHOD SEPERATELY.
		 * 
		 */
		
		//Continuous Optimization Hyper-parameters
		int populationSize = 100;
		int maxGenerations = 1000;
		double F = 0.1;
		double crossoverRate = 0.9;
		
		
		//Multi-Solution Hyper-parameters
		double parameterRandomizationTimes = 4;
		double problemSolutionTimes = 25;
		
		
		//Achieve the problem from the global variables class
		Problem problemB = GlobalDEVariables.problemB;
		problemB.showCustomerCoordinates();
		
		
		//Define the arrraylists that will hold the multi-metrics for different parameter sets and solutions
		ArrayList<ArrayList<Double>> multiMetrics = new ArrayList<ArrayList<Double>>();
		ArrayList<ArrayList<Double>> multiResultsAvg = new ArrayList<ArrayList<Double>>();
		
		
		//Run the algorithm for a predefined number of different parameter sets
		for(int i = 0; i<parameterRandomizationTimes; i++) {
			
			ArrayList<Double> resultsAvgFitness = new ArrayList<Double>();
			
			//Solve the problem for a predefined number of times
			for(int j = 0; j<problemSolutionTimes; j++) {
				
				ArrayList<DEIndividual> population = OptimizationBuilder.runContinuousOptimization_DErand1(problemB, populationSize, maxGenerations, F, crossoverRate);
				
				double fitness = DEFitness.getAverageDEPopulationFitness(population);
				resultsAvgFitness.add(fitness);
				
			}
			
			//Calculate the metrics and save them to the multi-metrics array
			double average = MathSupport.average(resultsAvgFitness);
			double bestResult = MathSupport.getBestResult(resultsAvgFitness);
			double worstResult = MathSupport.getWorstResult(resultsAvgFitness);
			double median = MathSupport.median(resultsAvgFitness);
			double stdDev = MathSupport.sd(resultsAvgFitness);
			
			ArrayList<Double> metrics = new ArrayList<Double>();
			metrics.add(average);
			metrics.add(stdDev);
			metrics.add(bestResult);
			metrics.add(worstResult);
			metrics.add(median);
			
			multiMetrics.add(metrics);
			multiResultsAvg.add(resultsAvgFitness);
		}
		
		//Show metrics for mutation method : DE/RAND/1
		System.out.println("\n MUTATION METHOD -> DE/RAND/1 -> METRICS \n ");
		PrintSupport.printMultiMetrics(problemB, multiResultsAvg, multiMetrics);
		
	}

}
