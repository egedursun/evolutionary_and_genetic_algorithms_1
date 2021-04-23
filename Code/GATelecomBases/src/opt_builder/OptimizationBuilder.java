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


package opt_builder;

import java.util.ArrayList;

import continuous_optimization.DECrossover;
import continuous_optimization.DEFitness;
import continuous_optimization.DEIndividual;
import continuous_optimization.DEPopulation;
import model.Problem;
import genetic_algorithm.Population;
import genetic_algorithm.Selection;
import genetic_algorithm.Fitness;
import genetic_algorithm.Individual;
import genetic_algorithm.Mating;
import genetic_algorithm.Mutation;

public class OptimizationBuilder {

	
	/*
	 * 
	 * OPTIMIZATION BUILDER IS A CLASS THAT CONTAINS WRAPPER FUNCTIONS THAT RUNS THE FOLLOWING OPTIMIZATION ALGORITHMS:
	 * 		-> GENETIC ALGORITHM
	 * 		-> CONTINUOUS OPTIMIZATION -> DIFFERENTIAL EVOLUTION IS USED
	 * 				->> DE/RAND/1
	 * 				->> DE/RAND/2
	 * 				->> DE/BEST/1
	 * 				->> DE/BEST/2
	 * 				->> DE/CURRENT_TO_BEST/1
	 * 
	 * 
	 */
	
	
	//This method is used for iteratively pushing the generations in the genetic algorithm further. Defined as a separate function to increase modularity.
	public static ArrayList<Individual> nextGenerationGA(Problem problem, ArrayList<Individual> population,
														double elitismAmount, double elderAmount,
														double randomIndividualAmount, double childrenAmount,
														double crossoverRate, double mutationRate) {
		
		//evaluate population fitness
		population = Fitness.evaluatePopulationFitness(problem, population);
		
		//show average population fitness
		Fitness.showAveragePopulationFitness(problem, population);
		
		//select best individuals/elites from the population
		ArrayList<Individual> elites = Selection.selectElitesByFitness(population, elitismAmount);
		
		//select elders from elites
		ArrayList<Individual> elders = Selection.selectElders(population, elites, elderAmount);
		
		//select random individuals from the population
		ArrayList<Individual> randomIvs = Selection.randomlySelectIndividuals(population, randomIndividualAmount);
		
		//produce children from the elite individuals
		ArrayList<Individual> children = Mating.breedPopulation(problem, elites, childrenAmount, crossoverRate);
		
		//combine the population
		ArrayList<Individual> combinedPopulation = Population.combinePopulation(elders, children, randomIvs);
		
		//mutate the children
		children = Mutation.mutatePopulation(problem, combinedPopulation, mutationRate);		
		
		//return the resulting population (children)
		return children;
	}
	
	
	//This method is used for iteratively pushing the generations in the differential evolution (DE/rand/1) further. Defined as a separate function to increase modularity.
	public static ArrayList<DEIndividual> nextGenerationContinuousOptimization_DErand1(Problem problem, ArrayList<DEIndividual> population,
																				double F, double crossoverRate) {
		
		//evaluate the fitness of the population
		population = DEFitness.evaluateDEPopulationFitness(problem, population);
		
		//show the average fitness of the population
		DEFitness.showAverageDEPopulationFitness(problem, population);
		
		//mutate the individuals with mutation method de/rand/1
		ArrayList<DEIndividual> mutatedIndividuals = DECrossover.mutateDEPopulation_DErand1(problem, population, F, crossoverRate);
		
		//return mutated individuals
		return mutatedIndividuals;
	}
	
	
	//This method is used for iteratively pushing the generations in the differential evolution (DE/rand/2) further. Defined as a separate function to increase modularity.
	public static ArrayList<DEIndividual> nextGenerationContinuousOptimization_DErand2(Problem problem, ArrayList<DEIndividual> population,
																				double F, double crossoverRate) {

		//evaluate the fitness of the population
		population = DEFitness.evaluateDEPopulationFitness(problem, population);

		//show the average fitness of the population
		DEFitness.showAverageDEPopulationFitness(problem, population);

		//mutate the individuals with mutation method de/rand/2
		ArrayList<DEIndividual> mutatedIndividuals = DECrossover.mutateDEPopulation_DErand2(problem, population, F, crossoverRate);

		//return the mutated individuals
		return mutatedIndividuals;
	}
	
	
	//This method is used for iteratively pushing the generations in the differential evolution (DE/best/1) further. Defined as a separate function to increase modularity.
	public static ArrayList<DEIndividual> nextGenerationContinuousOptimization_DEbest1(Problem problem, ArrayList<DEIndividual> population,
																				double F, double crossoverRate) {

		//evalute the fitness of the population
		population = DEFitness.evaluateDEPopulationFitness(problem, population);
		
		//show the average fitness of the population
		DEFitness.showAverageDEPopulationFitness(problem, population);
		
		//mutate the individuals with mutation method de/best/1
		ArrayList<DEIndividual> mutatedIndividuals = DECrossover.mutateDEPopulation_DEbest1(problem, population, F, crossoverRate);
		
		//return the mutated individuals
		return mutatedIndividuals;
	}
	
	
	//This method is used for iteratively pushing the generations in the differential evolution (DE/best/2) further. Defined as a separate function to increase modularity.
	public static ArrayList<DEIndividual> nextGenerationContinuousOptimization_DEbest2(Problem problem, ArrayList<DEIndividual> population,
																				double F, double crossoverRate) {

		//evaluate the fitness of the population
		population = DEFitness.evaluateDEPopulationFitness(problem, population);
		
		//show the average fitness level of the population
		DEFitness.showAverageDEPopulationFitness(problem, population);
		
		//mutate the individuals with mutation method de/best/2
		ArrayList<DEIndividual> mutatedIndividuals = DECrossover.mutateDEPopulation_DEbest2(problem, population, F, crossoverRate);
		
		//return mutated individuals
		return mutatedIndividuals;
	}
	
	
	//This method is used for iteratively pushing the generations in the differential evolution (DE/current_to_best/1) further. Defined as a separate function to increase modularity.
	public static ArrayList<DEIndividual> nextGenerationContinuousOptimization_DEcurToBest1(Problem problem, ArrayList<DEIndividual> population,
																				double F, double crossoverRate) {

		//evaluate the fitness of the population
		population = DEFitness.evaluateDEPopulationFitness(problem, population);
		
		//show the average fitness of the population
		DEFitness.showAverageDEPopulationFitness(problem, population);
		
		//mutate the individuals with mutation method de/current_to_best/1
		ArrayList<DEIndividual> mutatedIndividuals = DECrossover.mutateDEPopulation_DEcurToBest1(problem, population, F, crossoverRate);
		
		//return mutated individuals
		return mutatedIndividuals;
	}
	
	
	//This is the main wrapper function to be able to use for running the genetic algorithm with predefined hyper-parameters
	public static ArrayList<Individual> runGA(Problem problem, int populationSize, int maxGenerations,
								double elitismAmount, double elderAmount,
								double randomIndividualAmount, double childrenAmount,
								double crossoverRate, double mutationRate) {
		
		//generate initial population
		ArrayList<Individual> population = Population.generatePopulation(problem, populationSize);
		
		//evaluate initial population fitness
		Fitness.evaluatePopulationFitness(problem, population);
		
		//show initial average population fitness
		Fitness.showAveragePopulationFitness(problem, population);
		
		//Run the algorithm for maxGenerations times
		System.out.println("GENERATION 0 : \n");
		
		for(int i = 0; i<maxGenerations; i++) {
			
			System.out.println("GENERATION :" + i + " \n");
			
			ArrayList<Individual> nextPopulation = nextGenerationGA(problem, population, elitismAmount, elderAmount,
																		randomIndividualAmount, childrenAmount,
																		crossoverRate, mutationRate);
			
			System.out.println("\n________________________");
			
			population = nextPopulation;
		}
		
		//evaluate final populationn fitness
		population = Fitness.evaluatePopulationFitness(problem, population);
		
		//return final population
		return population;
		
	}
	
	
	//This is the main wrapper function to be able to use for running the differential evolution (DE/rand/1) with predefined hyper-parameters
	public static ArrayList<DEIndividual> runContinuousOptimization_DErand1(Problem problem, int populationSize, int maxGenerations,
																	double F, double crossoverRate) {
		
		//Generate initial population
		ArrayList<DEIndividual> population = DEPopulation.generateDEPopulation(problem, populationSize);
		
		//evaluate initial population fitness
		DEFitness.evaluateDEPopulationFitness(problem, population);
		
		//show average initial population fitness
		DEFitness.showAverageDEPopulationFitness(problem, population);
		
		//run the algorithm for maxGenerations times
		System.out.println("GENERATION 0 : \n");
		
		for(int i = 0; i<maxGenerations; i++) {
			
			System.out.println("GENERATION :" + i + " \n");
			
			ArrayList<DEIndividual> nextPopulation = nextGenerationContinuousOptimization_DErand1(problem, population, F, crossoverRate);
			
			System.out.println("\n_________________________");
			
			population = nextPopulation;
		}
		
		//Evaluate final population fitness
		population = DEFitness.evaluateDEPopulationFitness(problem, population);
		
		//return final population
		return population;
	}
	
	
	//This is the main wrapper function to be able to use for running the differential evolution (DE/rand/2) with predefined hyper-parameters
	public static ArrayList<DEIndividual> runContinuousOptimization_DErand2(Problem problem, int populationSize, int maxGenerations,
																			double F, double crossoverRate) {

		//generate initial population
		ArrayList<DEIndividual> population = DEPopulation.generateDEPopulation(problem, populationSize);
		
		//evaluate initial population fitness
		DEFitness.evaluateDEPopulationFitness(problem, population);
		
		//show average initial population fitness
		DEFitness.showAverageDEPopulationFitness(problem, population);
		
		//run the algorithm for maxGenerations times
		System.out.println("GENERATION 0 : \n");
		
		for(int i = 0; i<maxGenerations; i++) {
		
		System.out.println("GENERATION :" + i + " \n");
		
		ArrayList<DEIndividual> nextPopulation = nextGenerationContinuousOptimization_DErand2(problem, population, F, crossoverRate);
		
		System.out.println("\n_________________________");
		
		population = nextPopulation;
		}
		
		//evaluate the final population fitness
		population = DEFitness.evaluateDEPopulationFitness(problem, population);
		
		//return final population
		return population;
	}
	
	
	//This is the main wrapper function to be able to use for running the differential evolution (DE/best/1) with predefined hyper-parameters
	public static ArrayList<DEIndividual> runContinuousOptimization_DEbest1(Problem problem, int populationSize, int maxGenerations,
			double F, double crossoverRate) {

		
		//generate initial population
		ArrayList<DEIndividual> population = DEPopulation.generateDEPopulation(problem, populationSize);
		
		//evaluate initial population fitness
		DEFitness.evaluateDEPopulationFitness(problem, population);
		
		//show initial population fitness
		DEFitness.showAverageDEPopulationFitness(problem, population);
		
		
		//Run the algorithm for maxGenerations times
		System.out.println("GENERATION 0 : \n");
		
		for(int i = 0; i<maxGenerations; i++) {
		
		System.out.println("GENERATION :" + i + " \n");
		
		ArrayList<DEIndividual> nextPopulation = nextGenerationContinuousOptimization_DEbest1(problem, population, F, crossoverRate);
		
		System.out.println("\n_________________________");
		
		population = nextPopulation;
		}
		
		//evaluate the fitness for the final population
		population = DEFitness.evaluateDEPopulationFitness(problem, population);
		
		//return the final population
		return population;
	}
	
	
	//This is the main wrapper function to be able to use for running the differential evolution (DE/best/2) with predefined hyper-parameters
	public static ArrayList<DEIndividual> runContinuousOptimization_DEbest2(Problem problem, int populationSize, int maxGenerations,
			double F, double crossoverRate) {

		//generate initial population
		ArrayList<DEIndividual> population = DEPopulation.generateDEPopulation(problem, populationSize);
		
		//evaluate initial population fitness
		DEFitness.evaluateDEPopulationFitness(problem, population);
		
		//show average initial population fitness
		DEFitness.showAverageDEPopulationFitness(problem, population);
		
		
		//Run the algorithm for maxGenerations times.
		System.out.println("GENERATION 0 : \n");
		
		for(int i = 0; i<maxGenerations; i++) {
		
		System.out.println("GENERATION :" + i + " \n");
		
		ArrayList<DEIndividual> nextPopulation = nextGenerationContinuousOptimization_DEbest2(problem, population, F, crossoverRate);
		
		System.out.println("\n_________________________");
		
		population = nextPopulation;
		}
		
		//evaluate the final population
		population = DEFitness.evaluateDEPopulationFitness(problem, population);
		
		//return the final population
		return population;
	}
	
	
	//This is the main wrapper function to be able to use for running the differential evolution (DE/current_to_best/1) with predefined hyper-parameters
	public static ArrayList<DEIndividual> runContinuousOptimization_DEcurToBest1(Problem problem, int populationSize, int maxGenerations,
			double F, double crossoverRate) {

		
		//Generate initial population
		ArrayList<DEIndividual> population = DEPopulation.generateDEPopulation(problem, populationSize);
		
		//Evaluate the initial population fitness
		DEFitness.evaluateDEPopulationFitness(problem, population);
		
		//Show the average population fitness
		DEFitness.showAverageDEPopulationFitness(problem, population);
		
		
		//Run the algorithm for maxGenerations times
		System.out.println("GENERATION 0 : \n");
		
		for(int i = 0; i<maxGenerations; i++) {
		
		System.out.println("GENERATION :" + i + " \n");
		
		ArrayList<DEIndividual> nextPopulation = nextGenerationContinuousOptimization_DEcurToBest1(problem, population, F, crossoverRate);
		
		System.out.println("\n_________________________");
		
		population = nextPopulation;
		}
		
		//evaluate the fitness of the final population
		population = DEFitness.evaluateDEPopulationFitness(problem, population);
		
		//return the final population
		return population;
	}
			
}
