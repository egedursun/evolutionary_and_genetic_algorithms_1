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

import genetic_algorithm.Fitness;
import genetic_algorithm.Individual;
import model.Problem;
import opt_builder.OptimizationBuilder;
import support.MathSupport;
import support.PrintSupport;

public class GAGeneralTest {

	public static void main(String[] args) {
		
		
		/*
		 * 	THIS CLASS IS USED FOR TESTING THE USE OF A CONTINUOUS OPTIMIZATION ALGORITHM FOR OPTIMIZING 
		 * 	THE PROBLEM THAT WAS MENTIONED IN "HOMEWORK PART 2 : CITY A"
		 * 	
		 * 	USED METHOD : GENETIC ALGORITHM
		 * 	
		 * 	SELECTION WORKS AS THE FOLLOWING : 
		 * 
		 * 	-> AN ELITE GROUP IS SELECTED AMONG THE POPULATION EACH EPOCH, REGARDING THEIR FITNESS SCORES.
		 * 	-> A SPECIFIC PERCENT OF THIS ELITE GROUP TRANSFERS TO THE NEXT GENERATION DIRECTLY, AS ELDERS.
		 *  -> BY USING THE ELITE GROUP'S GENES, SPECIFIC PERCENTAGE OF CHILDREN ARE CREATED, AS WELL AS BEING ABLE TO APPLY A CROSSING-OVER; PASSING TO OTHER GENERATION.
		 *	-> A SPECIFIC PERCENT OF RANDOM INDIVIDUALS CAN BE SELECTED FROM THE POPULATION TO PASS TO OTHER GENERATION
		 *	-> MUTATION CAN APPLY, CONTROLLED BY THE MUTATION RATE
		 *
		 *	IN THIS CLASS, YOU CAN EVALUATE THE PERFORMANCE OF THE GENETIC ALGORITHM
		 * 
		 */
		
		//Genetic Algorithm Hyper-parameters
		int populationSize = 100;
		int maxGenerations = 2000;
		double elitismAmount = (populationSize*0.4);
		double elderAmount = (populationSize*0*1);
		double childrenAmount = (populationSize*0.89);
		double randomIndividualAmount = (populationSize*0.01);
		double crossoverRate = 0.9;
		double mutationRate = 0.1;
		
		
		//Multi-Solution Hyper-parameters
		double parameterRandomizationTimes = 4;
		double problemSolutionTimes = 25;
		

		//Define the city and the problem
		Problem problemA = GlobalGAVariables.problemA;
		
		
		//Define the multi-metrics array for different parameter sets and solution metrics for the algorithm
		ArrayList<ArrayList<Double>> multiMetrics = new ArrayList<ArrayList<Double>>();
		ArrayList<ArrayList<Double>> multiResultsAvg = new ArrayList<ArrayList<Double>>();
		
		//Run the genetic algorithm for a predefined number of times with different parameter sets
		for(int i = 0; i<parameterRandomizationTimes; i++) {
			
			ArrayList<Double> resultsAvgFitness = new ArrayList<Double>();
			
			//Solve the problem for a predefined number of times
			for(int j = 0; j<problemSolutionTimes; j++) {
				
				ArrayList<Individual> population = OptimizationBuilder.runGA(problemA, populationSize, maxGenerations, 
						elitismAmount, elderAmount, randomIndividualAmount,
						childrenAmount, crossoverRate, mutationRate);
				
				double fitness = Fitness.getAveragePopulationFitness(population);
				resultsAvgFitness.add(fitness);
				
			}
			
			//Calculate the metrics for the solutions and save them to the multimetrics array
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
		
		
		//Show metrics for the Genetic Algorithm solution
		System.out.println("\n GENETIC ALGORITHM SOLUTION METRICS : \n");
		PrintSupport.printMultiMetrics(problemA, multiResultsAvg, multiMetrics);
	}

}
