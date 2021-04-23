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
import java.util.Random;

import model.Problem;
import model.Base;

public class Mating {

	
	/*
	 * 
	 * THIS CLASS IS FOR DEFINING THE METHODS THAT ARE USED FOR GENETIC ALGORITHM INDIVIDUAL AND POPULATION BREEDING FUNCTIONS
	 * 
	 */
	
	
	
	//This method is used for breeding a population and applying crossover in a given rate. It is actually a wrapper function that uses individual breeding function.
	public static ArrayList<Individual> breedPopulation(Problem problem, ArrayList<Individual> population, double amountChildren, double crossoverRate) {
		
		Random r = new Random();
		ArrayList<Individual> children = new ArrayList<Individual>();
		Individual child = new Individual(problem);
		
		for(int i = 0; i<amountChildren; i++) {
			
			//select parents from the population
			int parent1Index = r.nextInt(population.size());
			int parent2Index = r.nextInt(population.size());
			
			Individual parent1 = population.get(parent1Index);
			Individual parent2 = population.get(parent2Index);
			
			//produce the children
			child = produceChildrenByCrossover(problem, parent1, parent2, crossoverRate);
			children.add(child);
		}
		
		return children;
	}
	
	
	//This method is used for producing children from parent individuals and applies crossover in the given rate.
	public static Individual produceChildrenByCrossover(Problem problem, Individual parent1, Individual parent2, double crossoverRate) {
		
		Random r = new Random();
		int coDie = r.nextInt(100);
		Individual child = new Individual(problem);
		ArrayList<Base> chromosome = new ArrayList<Base>();
		crossoverRate = crossoverRate*100;
		
		//apply crossover if the die is lower than the rate
		if(coDie < crossoverRate) {
			
			int coIndex = r.nextInt(parent1.getChromosome().size());
			
			//split and merge the chromosomes of the parents
			for(int i = 0; i<coIndex; i++) {
				chromosome.add(parent1.getChromosome().get(i));
			}
			
			for(int i =coIndex; i<parent1.getChromosome().size(); i++) {
				chromosome.add(parent2.getChromosome().get(i));
			}
			
			child.setChromosome(chromosome);

		}
		else {
			int choice = r.nextInt(2);
			
			//dont apply crossover and select a random parents chromosome 
			if(choice == 1) {
				chromosome = parent1.getChromosome();
			}
			else {
				chromosome = parent2.getChromosome();
			}
			
			child.setChromosome(chromosome);
			
		}
		
		return child;
	}
	
}
