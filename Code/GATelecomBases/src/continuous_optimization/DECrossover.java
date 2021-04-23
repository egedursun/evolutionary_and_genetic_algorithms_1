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
import java.util.Random;

import model.Base;
import model.Problem;

public class DECrossover {

	
	/*
	 * 
	 * THIS CLASS IS USED FOR APPLYING MUTATION TO THE DIFFERENTIAL EVOLUTION POPULATION BASED ON PARAMETERS
	 * 
	 */
	
	
	
	//this method is used for mutating the differential evolution population with the specified method : DE/rand/1
	public static ArrayList<DEIndividual> mutateDEPopulation_DErand1(Problem problem, ArrayList<DEIndividual> population, double F, double crossoverRate){
		
		Random r = new Random();
		
		ArrayList<DEIndividual> mutatedPopulation = new ArrayList<DEIndividual>();
		for (int i = 0; i<population.size(); i++) {
			
			DEIndividual deiv = population.get(i);
			int r1Idx = -1;
			int r2Idx = -1;
			int r3Idx = -1;
			
			//specify indexes for the selected population individuals
			int idx = r.nextInt(population.size());
			while(idx == i)
				idx = r.nextInt(population.size());
			r1Idx = idx;
			while(idx == i || idx == r1Idx)
				idx = r.nextInt(population.size());
			r2Idx = idx;
			while(idx == i || idx == r1Idx || idx == r2Idx)
				idx = r.nextInt(population.size());
			r3Idx = idx;
			
			DEIndividual r1 = population.get(r1Idx);
			DEIndividual r2 = population.get(r2Idx);
			DEIndividual r3 = population.get(r3Idx);
			
			//mutate the individuals
			DEIndividual newIndividual = DECrossover.mutateDEIndividual_DErand1(problem, deiv, r1, r2, r3, F, crossoverRate);
			mutatedPopulation.add(newIndividual);
		}
		
		//return mutated individual
		return mutatedPopulation;
	}
	
	
	//this method is used for mutating the differential evolution population with the specified method : DE/rand/2
	public static ArrayList<DEIndividual> mutateDEPopulation_DErand2(Problem problem, ArrayList<DEIndividual> population, double F, double crossoverRate){
		
		
		Random r = new Random();
		
		ArrayList<DEIndividual> mutatedPopulation = new ArrayList<DEIndividual>();
		for (int i = 0; i<population.size(); i++) {
			
			DEIndividual deiv = population.get(i);
			int r1Idx = -1;
			int r2Idx = -1;
			int r3Idx = -1;
			int r4Idx = -1;
			int r5Idx = -1;
			
			//specify indexes for the selected population individuals
			int idx = r.nextInt(population.size());
			while(idx == i)
				idx = r.nextInt(population.size());
			r1Idx = idx;
			while(idx == i || idx == r1Idx)
				idx = r.nextInt(population.size());
			r2Idx = idx;
			while(idx == i || idx == r1Idx || idx == r2Idx)
				idx = r.nextInt(population.size());
			r3Idx = idx;
			while(idx == i || idx == r1Idx || idx == r2Idx || idx == r3Idx)
				idx = r.nextInt(population.size());
			r4Idx = idx;
			while(idx == i || idx == r1Idx || idx == r2Idx || idx == r3Idx || idx == r4Idx  )
				idx = r.nextInt(population.size());
			r5Idx = idx;
			
			DEIndividual r1 = population.get(r1Idx);
			DEIndividual r2 = population.get(r2Idx);
			DEIndividual r3 = population.get(r3Idx);
			DEIndividual r4 = population.get(r4Idx);
			DEIndividual r5 = population.get(r5Idx);
			
			//mutate the individuals
			DEIndividual newIndividual = DECrossover.mutateDEIndividual_DErand2(problem, deiv, r1, r2, r3, r4, r5, F, crossoverRate);
			mutatedPopulation.add(newIndividual);
		}
		
		//return mutated population
		return mutatedPopulation;
	}
	
	
	//this method is used for mutating the differential evolution population with the specified method : DE/best/1
	public static ArrayList<DEIndividual> mutateDEPopulation_DEbest1(Problem problem, ArrayList<DEIndividual> population, double F, double crossoverRate){
		
		Random r = new Random();
		
		DEIndividual bestDeiv = getBestDEIndividual(population);
		int bestDeivIdx = -1;
		for (int i = 0; i<population.size(); i++) {
			if( population.get(i) == bestDeiv)
				bestDeivIdx = i;
		}
		
		ArrayList<DEIndividual> mutatedPopulation = new ArrayList<DEIndividual>();
		for (int i = 0; i<population.size(); i++) {
			
			DEIndividual deiv = population.get(i);
			int r1Idx = -1;
			int r2Idx = -1;
			
			//specify different indexes for the population individuals
			int idx = r.nextInt(population.size());
			while(idx == i || idx == bestDeivIdx )
				idx = r.nextInt(population.size());
			r1Idx = idx;
			while(idx == i || idx == bestDeivIdx || idx == r1Idx )
				idx = r.nextInt(population.size());
			r2Idx = idx;
			
			DEIndividual r1 = population.get(r1Idx);
			DEIndividual r2 = population.get(r2Idx);
			
			//mutate each individual
			DEIndividual newIndividual = DECrossover.mutateDEIndividual_DEbest1(problem, deiv, bestDeiv, r1, r2, F, crossoverRate);
			mutatedPopulation.add(newIndividual);
		}
		
		//returnmutated population
		return mutatedPopulation;
	}
	
	
	//this method is used for mutating the differential evolution popoulation with the specified method : DE/best/2
	public static ArrayList<DEIndividual> mutateDEPopulation_DEbest2(Problem problem, ArrayList<DEIndividual> population, double F, double crossoverRate){
		
		
		Random r = new Random();
		
		DEIndividual bestDeiv = getBestDEIndividual(population);
		int bestDeivIdx = -1;
		for (int i = 0; i<population.size(); i++) {
			if( population.get(i) == bestDeiv)
				bestDeivIdx = i;
		}
		
		ArrayList<DEIndividual> mutatedPopulation = new ArrayList<DEIndividual>();
		for (int i = 0; i<population.size(); i++) {
			
			DEIndividual deiv = population.get(i);
			int r1Idx = -1;
			int r2Idx = -1;
			int r3Idx = -1;
			int r4Idx = -1;
			
			
			//specify different indexes for population individuals
			int idx = r.nextInt(population.size());
			while(idx == i || idx == bestDeivIdx )
				idx = r.nextInt(population.size());
			r1Idx = idx;
			while(idx == i || idx == bestDeivIdx || idx == r1Idx )
				idx = r.nextInt(population.size());
			r2Idx = idx;
			while(idx == i || idx == bestDeivIdx || idx == r1Idx || idx == r2Idx  )
				idx = r.nextInt(population.size());
			r3Idx = idx;
			while(idx == i || idx == bestDeivIdx || idx == r1Idx || idx == r2Idx || idx == r3Idx)
				idx = r.nextInt(population.size());
			r4Idx = idx;
			
			DEIndividual r1 = population.get(r1Idx);
			DEIndividual r2 = population.get(r2Idx);
			DEIndividual r3 = population.get(r3Idx);
			DEIndividual r4 = population.get(r4Idx);
			
			//mutate each individual
			DEIndividual newIndividual = DECrossover.mutateDEIndividual_DEbest2(problem, deiv, bestDeiv, r1, r2, r3, r4, F, crossoverRate);
			mutatedPopulation.add(newIndividual);
		}
		
		//return mutated population
		return mutatedPopulation;
	}
	
	
	//this method is used for mutating the differential evolution population with the specified method : DE/current_to_best/1
	public static ArrayList<DEIndividual> mutateDEPopulation_DEcurToBest1(Problem problem, ArrayList<DEIndividual> population, double F, double crossoverRate){
		
		
		Random r = new Random();
		
		DEIndividual bestDeiv = getBestDEIndividual(population);
		int bestDeivIdx = -1;
		for (int i = 0; i<population.size(); i++) {
			if( population.get(i) == bestDeiv)
				bestDeivIdx = i;
		}
		
		ArrayList<DEIndividual> mutatedPopulation = new ArrayList<DEIndividual>();
		for (int i = 0; i<population.size(); i++) {
			
			DEIndividual deiv = population.get(i);
			int r1Idx = -1;
			int r2Idx = -1;
			
			//specify different indexes for population individuals
			int idx = r.nextInt(population.size());
			while(idx == i || idx == bestDeivIdx )
				idx = r.nextInt(population.size());
			r1Idx = idx;
			while(idx == i || idx == bestDeivIdx || idx == r1Idx )
				idx = r.nextInt(population.size());
			r2Idx = idx;
			
			DEIndividual r1 = population.get(r1Idx);
			DEIndividual r2 = population.get(r2Idx);
			
			//mutate each individual
			DEIndividual newIndividual = DECrossover.mutateDEIndividual_DEbest1(problem, deiv, bestDeiv, r1, r2, F, crossoverRate);
			mutatedPopulation.add(newIndividual);
		}
		
		//return mutated population
		return mutatedPopulation;
	}
	
	
	//this method is used for mutating a single individual inside the population with DE/rand/1 method
	public static DEIndividual mutateDEIndividual_DErand1(Problem problem,
														DEIndividual deiv, 
														DEIndividual r1, 
														DEIndividual r2, 
														DEIndividual r3,
														double F,
														double crossoverRate) {
		
		
		DEIndividual mutatedIndividual = new DEIndividual(problem);
		
		ArrayList<Base> mutatedChromosome = new ArrayList<Base>();
		
		Random r = new Random();
		crossoverRate = crossoverRate * 100;
		
		//define the mutaton index
		int mutationIndex = r.nextInt(deiv.getChromosome().size());
		
		
		for (int i = 0; i<deiv.getChromosome().size(); i++) {
			
			int coDie = r.nextInt(100);
			
			//create the mutant vectors
			double mutantX = r1.getChromosome().get(i).getX() + (F * (r2.getChromosome().get(i).getX() - r3.getChromosome().get(i).getX()));
			double mutantY = r1.getChromosome().get(i).getY() + (F * (r2.getChromosome().get(i).getY() - r3.getChromosome().get(i).getY()));
			
			double trialX;
			double trialY;
			
			//create the trial vector
			if (coDie < crossoverRate || i == mutationIndex) {
				
				trialX = mutantX;
				trialY = mutantY;
				
			}
			else {
				
				trialX = deiv.getChromosome().get(i).getX();
				trialY = deiv.getChromosome().get(i).getY();
				
			}
			
			//create the mutated base and add to chromosome
			Base mutatedBase = new Base(trialX, trialY, problem.getCoverRadius());
			
			mutatedChromosome.add(mutatedBase);
		}
		
		mutatedIndividual.setChromosome(mutatedChromosome);
		
		double newFitness = DEFitness.evaluateDEIndividualFitness(problem, mutatedIndividual);
		double oldFitness = deiv.getFitness();
		
		//if the new fitness is better, save it
		if(newFitness <= oldFitness) {
			mutatedIndividual = deiv;
		}
		else {
			mutatedIndividual.setChromosome(mutatedChromosome);
		}
		
		//return mutated individual
		return mutatedIndividual;
		
	}
	
	
	//this method is used for mutating a single individual in the population with DE/rand/2 method
	public static DEIndividual mutateDEIndividual_DErand2(Problem problem,
														DEIndividual deiv, 
														DEIndividual r1,
														DEIndividual r2,
														DEIndividual r3,
														DEIndividual r4,
														DEIndividual r5,
														double F,
														double crossoverRate) {
		
		DEIndividual mutatedIndividual = new DEIndividual(problem);
		
		ArrayList<Base> mutatedChromosome = new ArrayList<Base>();
		
		Random r = new Random();
		crossoverRate = crossoverRate * 100;
		
		int mutationIndex = r.nextInt(deiv.getChromosome().size());
		
		
		for (int i = 0; i<deiv.getChromosome().size(); i++) {
			
			int coDie = r.nextInt(100);
			
			//define the mutant vectors
			double mutantX = r1.getChromosome().get(i).getX() + (F * (r2.getChromosome().get(i).getX() - r3.getChromosome().get(i).getX()) +
							F * (r4.getChromosome().get(i).getX() - r5.getChromosome().get(i).getX()));
			
			
			double mutantY = r1.getChromosome().get(i).getY() + (F * (r2.getChromosome().get(i).getY() - r3.getChromosome().get(i).getY()) + 
					F * (r4.getChromosome().get(i).getY() - r5.getChromosome().get(i).getY()));
			
			double trialX;
			double trialY;
			
			
			//create the trial vectors
			if (coDie < crossoverRate || i == mutationIndex) {
				
				trialX = mutantX;
				trialY = mutantY;
				
			}
			else {
				
				trialX = deiv.getChromosome().get(i).getX();
				trialY = deiv.getChromosome().get(i).getY();
				
			}
			
			//create the mutated base and add it to the chromosome
			Base mutatedBase = new Base(trialX, trialY, problem.getCoverRadius());
			
			mutatedChromosome.add(mutatedBase);
		}
		
		mutatedIndividual.setChromosome(mutatedChromosome);
		
		double newFitness = DEFitness.evaluateDEIndividualFitness(problem, mutatedIndividual);
		double oldFitness = deiv.getFitness();
		
		//if the new fitness is better, save it
		if(newFitness <= oldFitness) {
			mutatedIndividual = deiv;
		}
		else {
			mutatedIndividual.setChromosome(mutatedChromosome);
		}
		
		//return the mutated individual
		return mutatedIndividual;
		
	}
	
	
	//this method is used for mutating a single individual with DE/best/1 method
	public static DEIndividual mutateDEIndividual_DEbest1(Problem problem,
														DEIndividual deiv,
														DEIndividual bestDeiv, 
														DEIndividual r1,
														DEIndividual r2,
														double F,
														double crossoverRate) {
		
		
		DEIndividual mutatedIndividual = new DEIndividual(problem);
		
		ArrayList<Base> mutatedChromosome = new ArrayList<Base>();
		
		Random r = new Random();
		crossoverRate = crossoverRate * 100;
		
		int mutationIndex = r.nextInt(deiv.getChromosome().size());
		
		
		for (int i = 0; i<deiv.getChromosome().size(); i++) {
			
			int coDie = r.nextInt(100);
			
			//create the mutant vectors
			double mutantX = bestDeiv.getChromosome().get(i).getX() + (F * (r1.getChromosome().get(i).getX() - r2.getChromosome().get(i).getX()));
			double mutantY = bestDeiv.getChromosome().get(i).getY() + (F * (r1.getChromosome().get(i).getY() - r2.getChromosome().get(i).getY()));
			
			double trialX;
			double trialY;
			
			
			//create the trial vectors
			if (coDie < crossoverRate || i == mutationIndex) {
				
				trialX = mutantX;
				trialY = mutantY;
				
			}
			else {
				
				trialX = deiv.getChromosome().get(i).getX();
				trialY = deiv.getChromosome().get(i).getY();
				
			}
			
			//create the mutated base and add it to the chromosome
			Base mutatedBase = new Base(trialX, trialY, problem.getCoverRadius());
			
			mutatedChromosome.add(mutatedBase);
		}
		
		mutatedIndividual.setChromosome(mutatedChromosome);
		
		double newFitness = DEFitness.evaluateDEIndividualFitness(problem, mutatedIndividual);
		double oldFitness = deiv.getFitness();
		
		//if the new fitness is better, save it
		if(newFitness <= oldFitness) {
			mutatedIndividual = deiv;
		}
		else {
			mutatedIndividual.setChromosome(mutatedChromosome);
		}
		
		//return mutated individual
		return mutatedIndividual;
	}
	
	
	//this method is used for mutating a single individual in the population with DE/best/2 method
	public static DEIndividual mutateDEIndividual_DEbest2(Problem problem,
														DEIndividual deiv,
														DEIndividual bestDeiv, 
														DEIndividual r1,
														DEIndividual r2,
														DEIndividual r3,
														DEIndividual r4,
														double F,
														double crossoverRate) {
		
		
		DEIndividual mutatedIndividual = new DEIndividual(problem);
		
		ArrayList<Base> mutatedChromosome = new ArrayList<Base>();
		
		Random r = new Random();
		crossoverRate = crossoverRate * 100;
		
		int mutationIndex = r.nextInt(deiv.getChromosome().size());
		
		
		for (int i = 0; i<deiv.getChromosome().size(); i++) {
			
			int coDie = r.nextInt(100);
			
			//create mutant vectors
			double mutantX = bestDeiv.getChromosome().get(i).getX() + (F * (r1.getChromosome().get(i).getX() - r2.getChromosome().get(i).getX()) + 
					(F * (r3.getChromosome().get(i).getX() - r4.getChromosome().get(i).getX())));
			double mutantY = bestDeiv.getChromosome().get(i).getY() + (F * (r1.getChromosome().get(i).getY() - r2.getChromosome().get(i).getY()) + 
					(F * (r3.getChromosome().get(i).getY() - r4.getChromosome().get(i).getY())));
			
			double trialX; 
			double trialY;
			
			
			//create trial vectors
			if (coDie < crossoverRate || i == mutationIndex) {
				
				trialX = mutantX;
				trialY = mutantY;
				
			}
			else {
				
				trialX = deiv.getChromosome().get(i).getX();
				trialY = deiv.getChromosome().get(i).getY();
				
			}
			
			//create the mutated base and save it to the chromosome
			Base mutatedBase = new Base(trialX, trialY, problem.getCoverRadius());
			
			mutatedChromosome.add(mutatedBase);
		}
		
		mutatedIndividual.setChromosome(mutatedChromosome);
		
		double newFitness = DEFitness.evaluateDEIndividualFitness(problem, mutatedIndividual);
		double oldFitness = deiv.getFitness();
		
		//if the new fitness is better, save it
		if(newFitness <= oldFitness) {
			mutatedIndividual = deiv;
		}
		else {
			mutatedIndividual.setChromosome(mutatedChromosome);
		}
		
		//return the mutated individual
		return mutatedIndividual;
	}
	
	
	//this method is used for applying mutation to a single individual with DE/current_to_best/1 method
	public static DEIndividual mutateDEIndividual_DEcurToBest1(Problem problem,
															DEIndividual deiv,
															DEIndividual bestDeiv,
															DEIndividual r1,
															DEIndividual r2,
															double F,
															double crossoverRate) {
		
		
		DEIndividual mutatedIndividual = new DEIndividual(problem);
		
		ArrayList<Base> mutatedChromosome = new ArrayList<Base>();
		
		Random r = new Random();
		crossoverRate = crossoverRate * 100;
		
		int mutationIndex = r.nextInt(deiv.getChromosome().size());
		
		
		for (int i = 0; i<deiv.getChromosome().size(); i++) {
			
			int coDie = r.nextInt(100);
			
			//create the mutant vectors
			double mutantX = deiv.getChromosome().get(i).getX() + (F * (bestDeiv.getChromosome().get(i).getX() - deiv.getChromosome().get(i).getX()) + 
					(F * (r1.getChromosome().get(i).getX() - r2.getChromosome().get(i).getX())));
			double mutantY = deiv.getChromosome().get(i).getY() + (F * (bestDeiv.getChromosome().get(i).getY() - deiv.getChromosome().get(i).getY()) + 
					(F * (r1.getChromosome().get(i).getY() - r2.getChromosome().get(i).getY())));
			
			double trialX;
			double trialY;
			
			
			//create the trial vectors
			if (coDie < crossoverRate || i == mutationIndex) {
				
				trialX = mutantX;
				trialY = mutantY;
				
			}
			else {
				
				trialX = deiv.getChromosome().get(i).getX();
				trialY = deiv.getChromosome().get(i).getY();
				
			}
			
			//create the mutated base and save it to the chromosome
			Base mutatedBase = new Base(trialX, trialY, problem.getCoverRadius());
			
			mutatedChromosome.add(mutatedBase);
		}
		
		mutatedIndividual.setChromosome(mutatedChromosome);
		
		double newFitness = DEFitness.evaluateDEIndividualFitness(problem, mutatedIndividual);
		double oldFitness = deiv.getFitness();
		
		//if the new fitness is better, save it
		if(newFitness <= oldFitness) {
			mutatedIndividual = deiv;
		}
		else {
			mutatedIndividual.setChromosome(mutatedChromosome);
		}
		
		//return mutated individual
		return mutatedIndividual;
		
	}
	
	
	//this method is used for achieving the individual with the best fitness level in a population
	public static DEIndividual getBestDEIndividual(ArrayList<DEIndividual> population) {
		
		DEIndividual maxDeiv = population.get(0);
		double max = 0;
		for(int i = 0; i<population.size(); i++) {
			
			//find the individual with the maximum fitness level
			if(population.get(i).getFitness() > max) {
				max = population.get(i).getFitness();
				maxDeiv = population.get(i);
			}
		}
		
		//return individual with the maximum fitness score
		return maxDeiv;
	}
}
