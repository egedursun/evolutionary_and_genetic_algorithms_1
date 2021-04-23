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

import model.Base;
import model.BaseLocation;
import model.City;
import model.Customer;
import model.Problem;

import java.util.ArrayList;

import continuous_optimization.DEIndividual;
import continuous_optimization.DEPopulation;
import genetic_algorithm.Individual;
import genetic_algorithm.Population;
import genetic_algorithm.Selection;
import genetic_algorithm.Fitness;
import genetic_algorithm.Mating;
import genetic_algorithm.Mutation;

import continuous_optimization.DECrossover;
import continuous_optimization.DEFitness;
import opt_builder.OptimizationBuilder;


public class UnitTests {

	public static void main(String[] args) {

		/*
		 * 	THIS CLASS IS USED FOR TESTING THE FUNCTIONALITY OF THE DIFFERENT MICRO AND MACRO UNITS OF THE PROGRAM

		 *
		 *	BY USING THIS PAGE, YOU CAN TEST THE USAGE OF THE MICRO AND MACRO PARTS AND FUNCTIONS OF THE PROGRAM.
		 * 
		 */
		
		//Creating Base Objects
		Base base1 = new Base(10, 10, 5);
		Base base2 = new Base(-5, 20, 10);
		Base base3 = new Base(30, 100, 5);
		System.out.println("BASE 1 - X: " + base1.getX() + " / Y: "+ base1.getY());
		System.out.println("BASE 1 COVER RADIUS : "+base1.getCoverRadius());
		System.out.println();
		System.out.println("BASE 2 - X: " + base2.getX() + " / Y: "+ base2.getY());
		System.out.println("BASE 2 COVER RADIUS : "+base2.getCoverRadius());
		System.out.println();
		System.out.println("BASE 3 - X: " + base3.getX() + " / Y: "+ base3.getY());
		System.out.println("BASE 3 COVER RADIUS : "+base3.getCoverRadius());
		System.out.println();
		
		
		//Creating Customer Objects
		Customer customer1 = new Customer(10, 10);
		Customer customer2 = new Customer(20, -5);
		Customer customer3 = new Customer(100, 50);
		System.out.println("CUSTOMER 1 - X: " + customer1.getX() + " / Y: "+ customer1.getY());
		System.out.println();
		System.out.println("CUSTOMER 2 - X: " + customer2.getX() + " / Y: "+ customer2.getY());
		System.out.println();
		System.out.println("CUSTOMER 3 - X: " + customer3.getX() + " / Y: "+ customer3.getY());
		System.out.println();
		
		
		//Creating and Manipulating BaseLocation Objects
		BaseLocation loc1 = new BaseLocation(10, 10);
		BaseLocation loc2 = new BaseLocation(-50, 150);
		BaseLocation loc3 = new BaseLocation(100, 500);
		loc2.setOccupied(true);
		System.out.println("BASE LOCATION 1 - X: " + loc1.getX() + " / Y: "+ loc1.getY());
		System.out.println("BASE LOCATION 1 OCCUPATION : "+loc1.isOccupied());
		System.out.println();
		System.out.println("BASE LOCATION 2 - X: " + loc2.getX() + " / Y: "+ loc2.getY());
		System.out.println("BASE LOCATION 2 OCCUPATION : "+loc2.isOccupied());
		System.out.println();
		System.out.println("BASE LOCATION3 - X: " + loc3.getX() + " / Y: "+ loc3.getY());
		System.out.println("BASE LOCATION 3 OCCUPATION : "+loc3.isOccupied());
		System.out.println();
		
		
		//Creating City Objects
		City city1 = new City(400, 400, 250, 100, 50);
		City city2 = new City(500, 500, 50, 100, 50 );
		City city3 = new City(500, 500, 300, 35);
		System.out.println("CITY 1 - WIDTH: " + city1.getWidth() + " / HEIGHT: "+ city1.getHeight());
		System.out.println("CITY 1 - CUSTOMER AMOUNT : " + city1.getCustomerAmount() + " / LOCATION AMOUNT : "+ city1.getBaseLocationAmount());
		System.out.println("CITY 1 - MAXIMUM BASE NUMBER : " + city1.getBaseAmount());
		System.out.println();
		System.out.println("CITY 2 - WIDTH: " + city2.getWidth() + " / HEIGHT: "+ city2.getHeight());
		System.out.println("CITY 2 - CUSTOMER AMOUNT : " + city2.getCustomerAmount() + " / LOCATION AMOUNT : "+ city2.getBaseLocationAmount());
		System.out.println("CITY 1 - MAXIMUM BASE NUMBER : " + city2.getBaseAmount());
		System.out.println();
		System.out.println("CITY 3 - WIDTH: " + city3.getWidth() + " / HEIGHT: "+ city3.getHeight());
		System.out.println("CITY 3 - CUSTOMER AMOUNT : " + city3.getCustomerAmount() + " / LOCATION AMOUNT : "+ city3.getBaseLocationAmount());
		System.out.println("CITY 1 - MAXIMUM BASE NUMBER : " + city3.getBaseAmount());
		System.out.println();
		
		
		//Creating Problem Object
		double coverRadius1 = 30;
		double coverRadius2 = 100;
		Problem p1 = new Problem(city1, coverRadius1);
		Problem p2 = new Problem(city2, coverRadius2);
		Problem p3 = new Problem(city3, coverRadius1);
		System.out.println("PROBLEM 1 COVER RADIUS : " + p1.getCoverRadius());
		System.out.println();
		System.out.println("PROBLEM 2 COVER RADIUS : " + p2.getCoverRadius());
		System.out.println();
		System.out.println("PROBLEM 3 COVER RADIUS : " + p3.getCoverRadius());
		System.out.println();
		
		
		//Creating and Using Individual Object
		Individual iv1 = new Individual(p1);
		Individual iv2 = new Individual(p1);
		Individual iv3 = new Individual(p2);
		Individual iv4 = new Individual(p2);
		iv1.showChromosome();
		iv2.showChromosome();
		iv3.showChromosome();
		iv4.showChromosome();
		
		
		//Creating a Population
		int populationSize1 = 100;
		int populationSize2 = 500;
		int populationSize3 = 1000;
		ArrayList<Individual> population1 = new ArrayList<Individual>();
		ArrayList<Individual> population2 = new ArrayList<Individual>();
		ArrayList<Individual> population3 = new ArrayList<Individual>();
		population1 = Population.generatePopulation(p1, populationSize1);
		population2 = Population.generatePopulation(p2, populationSize2);
		population3 = Population.generatePopulation(p3, populationSize3);
		Population.showPopulationData(population1);
		Population.showPopulationData(population2);
		Population.showPopulationData(population3);
		
		
		//Calculating Fitness Level of a Population
		population1 = Fitness.evaluatePopulationFitness(p1, population1);
		Fitness.showPopulationFitnessScores(p1, population1);
		double avgFitness = Fitness.getAveragePopulationFitness(population1);
		System.out.println("Average Fitness : "+avgFitness);
		Fitness.showAveragePopulationFitness(p1, population1);
			
		
		//Selecting of Parents among Elite Individuals for children generation and directly passing to next generation
		double elitismAmount = 40; //best 40% genes will be selected
		ArrayList<Individual> elites = Selection.selectElitesByFitness(population1, elitismAmount);
		
		
		//Select the elders for next generation
		double elderAmount = 20; //20% of the population will be elite elders
		ArrayList<Individual> elders = Selection.selectElders(population1, elites, elderAmount);
		
		
		//Selecting Random Individuals for next generation
		double randomIndividualAmount = 5;
		ArrayList<Individual> randomIvs = Selection.randomlySelectIndividuals(population1, randomIndividualAmount);
		
		
		//Produce the children from the elites
		double childrenAmount = 75;
		double crossoverRate = 0.9;
		ArrayList<Individual> children = Mating.breedPopulation(p1, elites, childrenAmount, crossoverRate);
		
		
		//Combine the population
		ArrayList<Individual> combinedPopulation = Population.combinePopulation(elders, children, randomIvs);
		
		
		//Mutate the children 
		double mutationRate = 0.2;
		children = Mutation.mutatePopulation(p1, combinedPopulation, mutationRate);		
		
		
		//Running genetic algorithm
		int maxGenerations = 25;
		OptimizationBuilder.runGA(p1, populationSize1, maxGenerations, 
									elitismAmount, elderAmount, randomIndividualAmount,
									childrenAmount, crossoverRate, mutationRate);
		
		
		//Create an Individual for Differential Evolution (DE)
		DEIndividual deiv1 = new DEIndividual(p3);
		DEIndividual r1 = new DEIndividual(p3);
		DEIndividual r2 = new DEIndividual(p3);
		DEIndividual r3 = new DEIndividual(p3);
		DEIndividual r4 = new DEIndividual(p3);
		DEIndividual r5 = new DEIndividual(p3);
		
		
		//Generate a population for DE
		int populationSize = 100;
		ArrayList<DEIndividual> pop1 = DEPopulation.generateDEPopulation(p3, populationSize);
		ArrayList<DEIndividual> pop2 = DEPopulation.generateDEPopulation(p3, 100);
		
		DEPopulation.showDEPopulationData(pop1);
		DEPopulation.showDEPopulationData(pop2);
		
		
		//Test mutation methods for DE/rand/1
		double F = 0.5;
		crossoverRate = 0.5;
		double oldFitness = DEFitness.evaluateDEIndividualFitness(p3, deiv1);
		DEIndividual newDeiv1 = DECrossover.mutateDEIndividual_DErand1(p3, deiv1, r1, r2, r3, F, crossoverRate);
		double newFitness = DEFitness.evaluateDEIndividualFitness(p3, newDeiv1);
		
		System.out.println("DE/rand/1 ----> Old Fitness : " + oldFitness + "  --- New Fitness : " + newFitness);
		
		
		//Test population mutation methods for DE/rand/1
		DEFitness.evaluateDEPopulationFitness(p3, pop1);
		DEFitness.showAverageDEPopulationFitness(p3, pop1);
		ArrayList<DEIndividual> mutatedPopulation = DECrossover.mutateDEPopulation_DErand1(p3, pop1, F, crossoverRate);
		DEFitness.evaluateDEPopulationFitness(p3, mutatedPopulation);
		DEFitness.showAverageDEPopulationFitness(p3, mutatedPopulation);
		
		
		//Test mutation methods for DE/rand/2
		oldFitness = DEFitness.evaluateDEIndividualFitness(p3, deiv1);
		newDeiv1 = DECrossover.mutateDEIndividual_DErand2(p3, deiv1, r1, r2, r3, r4, r5, F, crossoverRate);
		newFitness = DEFitness.evaluateDEIndividualFitness(p3, newDeiv1);
		
		System.out.println("DE/rand/2 ----> Old Fitness : " + oldFitness + "  --- New Fitness : " + newFitness);
		
		
		//Test population mutation methods for DE/rand/2
		DEFitness.evaluateDEPopulationFitness(p3, pop1);
		DEFitness.showAverageDEPopulationFitness(p3, pop1);
		mutatedPopulation = DECrossover.mutateDEPopulation_DErand2(p3, pop1, F, crossoverRate);
		DEFitness.evaluateDEPopulationFitness(p3, mutatedPopulation);
		DEFitness.showAverageDEPopulationFitness(p3, mutatedPopulation);
		
		
		//Test mutation methods for DE/best/1
		oldFitness = DEFitness.evaluateDEIndividualFitness(p3, deiv1);
		DEIndividual bestDeiv = DECrossover.getBestDEIndividual(pop1);
		newDeiv1 = DECrossover.mutateDEIndividual_DEbest1(p3, deiv1, bestDeiv, r1, r2, F, crossoverRate);
		newFitness = DEFitness.evaluateDEIndividualFitness(p3, newDeiv1);
		
		System.out.println("DE/best/1 ----> Old Fitness : " + oldFitness + "  --- New Fitness : " + newFitness);
		
		
		//Test population mutation methods for DE/best/1
		DEFitness.evaluateDEPopulationFitness(p3, pop1);
		DEFitness.showAverageDEPopulationFitness(p3, pop1);
		mutatedPopulation = DECrossover.mutateDEPopulation_DEbest1(p3, pop1, F, crossoverRate);
		DEFitness.evaluateDEPopulationFitness(p3, mutatedPopulation);
		DEFitness.showAverageDEPopulationFitness(p3, mutatedPopulation);
		
		
		//Test mutation methods for DE/best/2
		oldFitness = DEFitness.evaluateDEIndividualFitness(p3, deiv1);
		bestDeiv = DECrossover.getBestDEIndividual(pop1);
		newDeiv1 = DECrossover.mutateDEIndividual_DEbest2(p3, deiv1, bestDeiv, r1, r2, r3, r4, F, crossoverRate);
		newFitness = DEFitness.evaluateDEIndividualFitness(p3, newDeiv1);
		
		System.out.println("DE/best/2 ----> Old Fitness : " + oldFitness + "  --- New Fitness : " + newFitness);
		
		
		//Test population mutation methods for DE/best/2
		DEFitness.evaluateDEPopulationFitness(p3, pop1);
		DEFitness.showAverageDEPopulationFitness(p3, pop1);
		mutatedPopulation = DECrossover.mutateDEPopulation_DEbest2(p3, pop1, F, crossoverRate);
		DEFitness.evaluateDEPopulationFitness(p3, mutatedPopulation);
		DEFitness.showAverageDEPopulationFitness(p3, mutatedPopulation);
		
		
		//Test mutation methods for DE/current_to_best/1
		oldFitness = DEFitness.evaluateDEIndividualFitness(p3, deiv1);
		bestDeiv = DECrossover.getBestDEIndividual(pop1);
		newDeiv1 = DECrossover.mutateDEIndividual_DEcurToBest1(p3, deiv1, bestDeiv, r1, r2, F, crossoverRate);
		newFitness = DEFitness.evaluateDEIndividualFitness(p3, newDeiv1);
		
		System.out.println("DE/current_to_best/1 ----> Old Fitness : " + oldFitness + "  --- New Fitness : " + newFitness);
		
		
		//Test population mutation methods for DE/current_to_best/1
		DEFitness.evaluateDEPopulationFitness(p3, pop1);
		DEFitness.showAverageDEPopulationFitness(p3, pop1);
		mutatedPopulation = DECrossover.mutateDEPopulation_DEcurToBest1(p3, pop1, F, crossoverRate);
		DEFitness.evaluateDEPopulationFitness(p3, mutatedPopulation);
		DEFitness.showAverageDEPopulationFitness(p3, mutatedPopulation);
		
	}

}
