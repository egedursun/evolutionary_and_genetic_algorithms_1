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


package genetic_algorithm;

import java.util.ArrayList;

import model.Problem;

public class Population {

	
	/*
	 * 
	 * THIS CLASS IS USED FOR GENERATING POPULATIONS FOR GENETIC ALGORITHMS WITH SPECIFIED PARAMETERS
	 * 
	 */
	
	
	//This method is used for generating a population for the genetic algorithm
	public static ArrayList<Individual> generatePopulation(Problem problem, int populationSize){
		
		ArrayList<Individual> population = new ArrayList<Individual>();
		for(int i = 0; i<populationSize; i++) {
			Individual individual = new Individual(problem);
			population.add(individual);
		}
		
		return population;
	}
	
	
	//This method is used for showing the basic data about the population including fitness scores.
	public static void showPopulationData(ArrayList<Individual> population) {
		
		System.out.println();
		System.out.println("PRINTING THE INFORMATION OF THE POPULATION ... ");
		System.out.println();
		for(int i = 0; i<population.size(); i++) {
			Individual iv = population.get(i);
			System.out.println("INDIVIDUAL NUMBER: " + i);
			System.out.println("INDIVIDUAL FITNESS SCORE: " + iv.getFitness());
			iv.showChromosome();
			System.out.println("________________");
		}
	}
	
	
	//This method is used for combining the different population groups in the ga; such as the elites, elders, children and random individuals
	public static ArrayList<Individual> combinePopulation(ArrayList<Individual> elders, ArrayList<Individual> children, ArrayList<Individual> randoms){
		
		ArrayList<Individual> combinedPopulation = new ArrayList<Individual>();
		
		for(int i = 0; i<elders.size(); i++) {
			combinedPopulation.add(elders.get(i));
		}
		
		for(int i = 0; i<children.size(); i++) {
			combinedPopulation.add(children.get(i));
		}
		
		for(int i = 0; i<randoms.size(); i++) {
			combinedPopulation.add(randoms.get(i));
		}
		
		//return the combined population
		return combinedPopulation;
	}
}
