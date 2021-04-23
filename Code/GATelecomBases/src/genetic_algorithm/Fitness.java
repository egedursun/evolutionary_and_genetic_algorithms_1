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

import model.Base;
import model.Customer;
import model.Problem;

public class Fitness {

	
	/*
	 * 
	 * THIS CLASS IS USED FOR FITNESS EVALUATION AND REPRESENTATION OF THE GENETIC ALGORITHM POPULATION
	 * 
	 * IT CONTAINS THE METHODS THAT ARE RELATED WITH FITNESS EVALUATION AND REPRESENTATION
	 * 
	 */
	
	//This method is used for evaluating the fitness score of an individual in genetic algorithm population
	public static double evaluateIndividualFitness(Problem problem, Individual iv) {
		
		ArrayList<Customer> customers = problem.getCustomers();
		
		double fitness = 0;
		for(int j = 0; j<customers.size(); j++) {
			
			Customer customer = customers.get(j);
			for(int k = 0; k<iv.getChromosome().size(); k++) {
				
				Base base = iv.getChromosome().get(k);
				
				//calculating the distance of a customer and checking if he/she is covered by a base
				double deltaXPow = Math.pow(customer.getX() - base.getX(), 2);
				double deltaYPow = Math.pow(customer.getY() - base.getY(), 2);
				double sqrtSum = Math.sqrt((deltaXPow + deltaYPow));
				
				
				//increate the fitness score if he/she is covered
				if(sqrtSum <= problem.getCoverRadius()){
					fitness = fitness + 1;
					break;
				}else {
					continue;
				}
			}
		}
		
		//set the fitness level of the individual
		iv.setFitness(fitness);
		
		return fitness;
	}
	
	
	//This method is used for evaluating the fitness level of a whole genetic algorithm population. It is a wrapper function that uses the individual evaluation method
	public static ArrayList<Individual> evaluatePopulationFitness(Problem problem, ArrayList<Individual> population){
		
		for(int i = 0; i<population.size(); i++) {
			
			Individual iv = population.get(i);
			
			
			//evaluate and get the fitness level of the individual and set it
			double fitness = evaluateIndividualFitness(problem, iv);
			
			iv.setFitness(fitness);
		}
		
		return population;
	}
	
	
	//This method is used for showing the fitness scores of the individuals in a population one by one
	public static void showPopulationFitnessScores(Problem problem, ArrayList<Individual> population) {
		
		System.out.println();
		System.out.println("SHOWING POPULATION FITNESS SCORES ...");
		System.out.println();
		for(int i = 0; i<population.size(); i++) {
			double prc = (population.get(i).getFitness()/problem.getCity().getCustomerAmount())*100;
			System.out.println("INDIVIDUAL "+i+" FITNESS SCORE : " + population.get(i).getFitness() + " / "+ problem.getCity().getCustomerAmount() + " ( %" + prc + " )");
		}
		System.out.println();
	}
	
	
	//This method is used for getting the average population score in a population
	public static double getAveragePopulationFitness(ArrayList<Individual> population) {
		
		double summation = 0;
		for(int i = 0; i<population.size(); i++) {
			
			summation = summation + population.get(i).getFitness();
		}
		
		double average = (double) (summation/population.size());
		
		return average;
	}
	
	
	//This method is used for printing the average population score in a genetic algorithm population
	public static void showAveragePopulationFitness(Problem problem, ArrayList<Individual> population) {
		
		double summation = 0;
		for(int i = 0; i<population.size(); i++) {
			
			summation = summation + population.get(i).getFitness();
		}
		
		double average = summation/population.size();
		
		double prc = (average/problem.getCity().getCustomerAmount())*100;
		System.out.println("AVERAGE FITNESS OF POPULATION : "+average+" / "+problem.getCity().getCustomerAmount() + " ( %" + prc + " )");
	}
}
