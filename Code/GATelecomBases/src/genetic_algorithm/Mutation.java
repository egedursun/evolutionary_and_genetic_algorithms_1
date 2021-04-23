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
import model.BaseLocation;

public class Mutation {

	/*
	 * 
	 * THIS CLASS IS USED FOR DEFINING THE METHODS FOR APPLYING MUTATION TO THE GENETIC ALGORITHM INDIVIDALS AND POPULATION
	 * 
	 */
	
	
	
	//this method is used for mutating the whole genetic algorithm population and acts as a wrapper function that reaches the individual mutation function
	public static ArrayList<Individual> mutatePopulation(Problem problem, ArrayList<Individual> population, double mutationRate) {
		
		ArrayList<Individual> mutatedPopulation = new ArrayList<Individual>();
		for (int i = 0; i<population.size(); i++) {
			
			//mutate each individual
			Individual mutatedIv = mutateIndividual(problem, population.get(i), mutationRate);
			mutatedPopulation.add(mutatedIv);
		}
		
		return mutatedPopulation;
	}
	
	
	//this method is used for mutating a single individual with a given mutation rate.
	public static Individual mutateIndividual(Problem problem, Individual iv, double mutationRate) {
		
		Random r = new Random();
		int muteDie = r.nextInt(100);
		Individual mutatedIv = new Individual(problem);
		mutationRate = mutationRate*100;
		
		//if the mutation die is smaller than the mutation rate, apply mutation; otherwise leave as it is.
		if(muteDie < mutationRate) {
			
			int mutationIndex = r.nextInt(iv.getChromosome().size());
			ArrayList<Base> mutatedChromosome = mutateGene(problem, iv.getChromosome(), mutationIndex);
			mutatedIv.setChromosome(mutatedChromosome);

		}
		else {
			
			mutatedIv = iv;
			
		}
		
		return mutatedIv;
	}
	
	
	//this method is used for mutating a single gene in a chromosome.
	public static ArrayList<Base> mutateGene(Problem problem, ArrayList<Base> chromosome, int mutationIndex) {
		
		Random r = new Random();
		double x;
		double y;
		double coverRadius = problem.getCoverRadius();
		Base base;
		
		//apply mutation according to the problem structure.
		if(problem.getCity().getBaseLocationAmount() == 0) {
			
			x = problem.getCity().getWidth() * r.nextDouble();
			y = problem.getCity().getHeight() * r.nextDouble();
			base = new Base(x, y, coverRadius);
		}
		else {
			
			ArrayList<BaseLocation> baseLocations = problem.getBaseLocations();
			int baseChoice = r.nextInt(baseLocations.size()); 
			BaseLocation baseLoc = baseLocations.get(baseChoice);
			
			x = baseLoc.getX();
			y = baseLoc.getY();
			base = new Base(x, y, coverRadius);
		}
		
		chromosome.set(mutationIndex, base);
		return chromosome;
	}
}
