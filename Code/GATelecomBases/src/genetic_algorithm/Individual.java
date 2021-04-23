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

import model.Problem;

import java.util.ArrayList;
import java.util.Random;

import model.Base;
import model.BaseLocation;

public class Individual implements Comparable<Individual> {

	/*
	 * 
	 * THIS CLASS IS USED FOR DEFINING THE INDIVIDUAL OBJECT, WHICH IS THE MAIN POPULATION ACTOR IN THE GENETIC ALGORITHM
	 * 
	 * IT CONTAINS A PROBLEM OBJECT, WHICH IS DEFINING THE PROBLEM TO BE SOLVED, A FITNESS VARIABLE WHICH DEFINES FITNESS LEVEL,
	 * AND A CHROMOSOME THAT CONTAINS THE BASE COORDINATES THE INDIVIDUAL POSSESS.
	 * 
	 */
	
	
	private int id;
	private Problem problem;
	private ArrayList<Base> chromosome;
	private Double fitness;
	
	private static int counter = 0;
	
	public Individual(Problem problem) {
		counter++;
		this.id = counter;
		this.problem = problem;
		this.chromosome = randomizeChromosome();
		this.fitness = 0.0;
	}
	
	
	//This method is used for randomizing the chromosome of the individual on creation
	public ArrayList<Base> randomizeChromosome(){
		
		Random r = new Random();
		double x;
		double y;
		ArrayList<Base> bases = new ArrayList<Base>();
		if(problem.getCity().getBaseLocationAmount() == 0) {
			
			for(int i = 0; i<problem.getCity().getBaseAmount(); i++) {
				
				//create random coordinates in continuous space if there are no base locations
				x = problem.getCity().getWidth() * r.nextDouble();
				y = problem.getCity().getHeight() * r.nextDouble();
				Base base = new Base(x, y, problem.getCoverRadius());
				bases.add(base);
			}	
			
			return bases;
		}
		else {
			
			for(BaseLocation location  : problem.getBaseLocations()) {
				location.setOccupied(false);
			}
			
			int choice;
			for(int i = 0; i<problem.getCity().getBaseAmount(); i++) {
				
				choice = r.nextInt(problem.getBaseLocations().size());
				if(problem.getBaseLocations().get(choice).isOccupied() == true) {
					i = i -1;
					continue;
				}
				else {
					
					//select from baselocations if they are defined.
					x = problem.getBaseLocations().get(choice).getX();
					y = problem.getBaseLocations().get(choice).getY();
					Base base = new Base(x, y, problem.getCoverRadius());
					bases.add(base);
					problem.getBaseLocations().get(choice).setOccupied(true);
				}
			}
			
			return bases;
		}
	}
	
	
	//This method is used for showing the chromosome values of the individual
	public void showChromosome() {
		System.out.println();
		System.out.println("\n INDIVIDUAL BASE COORDINATES : ");
		for(int i = 0; i<chromosome.size(); i++) {
			Base base = chromosome.get(i);
			System.out.print("Base "+i+" ("+
								String.format("%.2f", base.getX())+
								" / "+
								String.format("%.2f", base.getY())+
								") , ");
		}
		System.out.println();
	}
	
	public static int getIndividualAmount() {
		return counter;
	}

	public Problem getProblem() {
		return problem;
	}

	public void setProblem(Problem problem) {
		this.problem = problem;
	}

	public ArrayList<Base> getChromosome() {
		return chromosome;
	}

	public void setChromosome(ArrayList<Base> chromosome) {
		this.chromosome = chromosome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getFitness() {
		return fitness;
	}

	public void setFitness(Double fitness) {
		this.fitness = fitness;
	}

	@Override
	public int compareTo(Individual o) {
		
		if (getFitness() == 0 || o.getFitness() == 0) {
			return 0;
		}
		
		return getFitness().compareTo(o.getFitness());
	}
	
}
