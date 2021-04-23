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
import java.util.Collections;
import java.util.Random;

import genetic_algorithm.Individual;

public class Selection {

	
	/*
	 * 
	 * THIS CLASS IS USED FOR DEFINING THE SELECTION METHODS FOR THE GENETIC ALGORITHM 
	 * 
	 */
	
	
	
	//this method is used for selecting elite individuals from the population according to their fitness level.
	public static ArrayList<Individual> selectElitesByFitness(ArrayList<Individual> population,
																double elitesAmount){
		
		//define the elites group and the sorted population (by fitness score)
		ArrayList<Individual> elites = new ArrayList<Individual>();
		ArrayList<Individual> sortedPopulation = sortPopulationByFitness(population);
		
		for(int i = 0; i<elitesAmount; i++) {
			
			elites.add(sortedPopulation.get(i));
		}
		
		return elites;
	}
	
	
	//this method is used for selecting successful elders that will pass to other generation by their fitness score.
	public static ArrayList<Individual> selectElders(ArrayList<Individual> population,
								ArrayList<Individual> elites,
								double eldersAmount) {
		
		ArrayList<Individual> elders = new ArrayList<Individual>();
		
		for(int i = 0; i<eldersAmount; i++) {
			
			elders.add(elites.get(i));
		}
		
		return elders;
	}
	
	
	//this method is used for randomly selecting individuals from the population to pass to next generation
	public static ArrayList<Individual> randomlySelectIndividuals(ArrayList<Individual> population,
															double randomAmount){
		
		ArrayList<Individual> randomIvs = new ArrayList<Individual>();
		
		Random r = new Random();
		for(int i = 0; i<randomAmount; i++) {
			
			int choice = r.nextInt(population.size());
			randomIvs.add(population.get(choice));
		}
		
		return randomIvs;
	}
	
	
	//this method is used for sorting the population arraylist by fitness score.
	public static ArrayList<Individual> sortPopulationByFitness(ArrayList<Individual> population){
		
		Collections.sort(population);
		Collections.reverse(population);
		
		return population;
	}
}
