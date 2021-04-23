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

import model.Base;
import model.Customer;
import model.Problem;

public class DEFitness {
	
	
	/*
	 * 
	 * THIS CLASS IS USED FOR EVALUATING THE FITNESS LEVEL OF THE INDIVIDUALS FOR DIFFERENTIAL EVOLUTION ALGORITHM
	 * 
	 */
	
	
	
	//this method is used for evaluating the fitness score of a single individual
	public static double evaluateDEIndividualFitness(Problem problem, DEIndividual iv) {
		
		ArrayList<Customer> customers = problem.getCustomers();
		
		double fitness = 0;
		for(int j = 0; j<customers.size(); j++) {
			
			Customer customer = customers.get(j);
			for(int k = 0; k<iv.getChromosome().size(); k++) {
				
				Base base = iv.getChromosome().get(k);
				
				//take distance and coverage status of each customer in the city.
				double deltaXPow = Math.pow(customer.getX() - base.getX(), 2);
				double deltaYPow = Math.pow(customer.getY() - base.getY(), 2);
				double sqrtSum = Math.sqrt((deltaXPow + deltaYPow));
				
				//evaluate fitnesss score
				if(sqrtSum <= problem.getCoverRadius()){
					fitness = fitness + 1;
					break;
				}else {
					continue;
				}
			}
		}
		
		iv.setFitness(fitness);
		
		return fitness;
	}
	
	
	//this method is used for evaluating the fitness score of the entire differential evoliton population arraylist
	public static ArrayList<DEIndividual> evaluateDEPopulationFitness(Problem problem, ArrayList<DEIndividual> population){
		
		for(int i = 0; i<population.size(); i++) {
			
			DEIndividual iv = population.get(i);
			
			//evaluate the fitness of each individual
			double fitness = evaluateDEIndividualFitness(problem, iv);
			
			
			//set fitness score of each individual
			iv.setFitness(fitness);
		}
		
		return population;
	}
	
	
	//this method is used for showing the population scores of the each individual in the differential evolution population
	public static void showDEPopulationFitnessScores(Problem problem, ArrayList<DEIndividual> population) {
		
		System.out.println();
		System.out.println("SHOWING POPULATION FITNESS SCORES ...");
		System.out.println();
		for(int i = 0; i<population.size(); i++) {
			double prc = (population.get(i).getFitness()/problem.getCity().getCustomerAmount())*100;
			System.out.println("INDIVIDUAL "+i+" FITNESS SCORE : " + population.get(i).getFitness() + " / "+ problem.getCity().getCustomerAmount() + " ( %" + prc + " )");
		}
		System.out.println();
	}
	
	
	//this method is used for getting the average population fitenss score in the given population
	public static double getAverageDEPopulationFitness(ArrayList<DEIndividual> population) {
		
		double summation = 0;
		for(int i = 0; i<population.size(); i++) {
			
			summation = summation + population.get(i).getFitness();
		}
		
		double average = (double) (summation/population.size());
		
		return average;
	}
	
	
	//this method is used for printing the average population fitness score in the given population
	public static void showAverageDEPopulationFitness(Problem problem, ArrayList<DEIndividual> population) {
		
		double summation = 0;
		for(int i = 0; i<population.size(); i++) {
			
			summation = summation + population.get(i).getFitness();
		}
		
		double average = summation/population.size();
		
		double prc = (average/problem.getCity().getCustomerAmount())*100;
		System.out.println("AVERAGE FITNESS OF POPULATION : "+average+" / "+problem.getCity().getCustomerAmount() + " ( %" + prc + " )");
	}
	
}
