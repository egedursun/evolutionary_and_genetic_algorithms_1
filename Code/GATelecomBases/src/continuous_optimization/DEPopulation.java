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


package continuous_optimization;

import java.util.ArrayList;

import model.Problem;

public class DEPopulation {

	
	/*
	 * 
	 * THIS CLASS IS USED FOR GENERATING RANDOMIZED POPULATIONS FOR DIFFERENTIAL EVOLUTION ALGORITHM AND PRINTING SPECIFIC DATA ABOUT THEM
	 * 
	 */
	
	
	
	//this method is used for generating an initial population for the differential evolution algorithm
	public static ArrayList<DEIndividual> generateDEPopulation(Problem problem, int populationSize){
		
		ArrayList<DEIndividual> population = new ArrayList<DEIndividual>();
		for(int i = 0; i<populationSize; i++) {
			DEIndividual individual = new DEIndividual(problem);
			population.add(individual);
		}
		
		return population;
	}
	
	
	//this method is used for showing the general data about the population
	public static void showDEPopulationData(ArrayList<DEIndividual> population) {
		
		System.out.println();
		System.out.println("PRINTING THE INFORMATION OF THE POPULATION ... ");
		System.out.println();
		for(int i = 0; i<population.size(); i++) {
			DEIndividual iv = population.get(i);
			System.out.println("INDIVIDUAL NUMBER: " + i);
			System.out.println("INDIVIDUAL FITNESS SCORE: " + iv.getFitness());
			iv.showChromosome();
			System.out.println("________________");
		}
	}
	
}
