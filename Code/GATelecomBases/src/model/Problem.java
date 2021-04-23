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


package model;

import java.util.ArrayList;
import java.util.Random;

public class Problem {

	
	/*
	 * 
	 * PROBLEM IS THE OBJECT THAT ACTS AS A WRAPPER OF THE PROBLEM DEFINITION FOR OUR OPTIMIZATION PROBLEMS
	 * IT CAN WORK WITH DIFFERENT RANDOMIZED SETS OF PARAMETERS AND IT CAN ALSO WORK ON DIFFERENT CITIES WITH DIFFERENT PARAMETERS,
	 * DIFFERENT COVER RADIUS -> WHICH IS THE MAXIMUM DISTANCE A BASE CAN SERVE.
	 * 
	 */
	
	private City city;
	private ArrayList<Customer> customers;
	private ArrayList<BaseLocation> baseLocations;
	private double coverRadius;
	
	
	public Problem(City city, double coverRadius) {
		this.city = city;
		this.customers = randomizeCustomers();
		System.out.println("\n PROBLEM - CUSTOMERS AND BASE LOCATIONS : ");
		
		//Show customer coordinates on problem creation
		showCustomerCoordinates();
		this.baseLocations = randomizeBaseLocations();
		
		//Show base location coordinates on problem creation (if exists)
		showBaseLocationCoordinates();
		this.coverRadius = coverRadius;
	}
	
	
	//This method randomizes customer objects and their locations on the specified city.
	public ArrayList<Customer> randomizeCustomers(){
		
		Random r = new Random();
		ArrayList<Customer> customers = new ArrayList<Customer>();
		double x;
		double y;
		for(int i =0; i<city.getCustomerAmount(); i++) {
			x = city.getWidth() * r.nextDouble();
			y = city.getHeight() * r.nextDouble();
			Customer customer = new Customer(x, y);
			customers.add(customer);
		}
		
		return customers;
	}
	
	
	//this method randomizes base location objects and their locations on the specified city.
	public ArrayList<BaseLocation> randomizeBaseLocations(){
		
		if(city.getBaseLocationAmount() == 0) {
			return null;
		}
		else {
			
			Random r = new Random();
			ArrayList<BaseLocation> baseLocations = new ArrayList<BaseLocation>();
			double x;
			double y;
			for(int i = 0; i<city.getBaseLocationAmount(); i++) {
				x = city.getWidth() * r.nextDouble();
				y = city.getHeight() * r.nextDouble();
				BaseLocation baseLocation = new BaseLocation(x, y);
				baseLocations.add(baseLocation);
			}
			
			return baseLocations;
		}
		
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public ArrayList<BaseLocation> getBaseLocations() {
		return baseLocations;
	}

	public void setBaseLocations(ArrayList<BaseLocation> baseLocations) {
		this.baseLocations = baseLocations;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	public double getCoverRadius() {
		return coverRadius;
	}

	public void setCoverRadius(double coverRadius) {
		this.coverRadius = coverRadius;
	}
	
	
	//This method makes us be able to see the coordinates of the randomized customers on creation
	public void showCustomerCoordinates() {
		
		System.out.println("\n CUSTOMER LOCATIONS (X / Y) : ");
		for(int i = 0; i<this.customers.size(); i++) {
			System.out.println("Customer "+i+" ("+
								String.format("%.2f", customers.get(i).getX())+
								" / "+
								String.format("%.2f", customers.get(i).getY())+
								") , ");
		}
		System.out.println();
	}
	
	//This method makes us able to see the coordinates of the randomized base locations on creation (if exists)
	public void showBaseLocationCoordinates() {
		
		if(city.getBaseLocationAmount() != 0) {
			System.out.println("\n BASE LOCATION COORDINATES (X / Y) : ");
			for(int i = 0; i<baseLocations.size(); i++) {
				System.out.println("Base Location "+i+" ("+
						String.format("%.2f", baseLocations.get(i).getX())+
						" / "+
						String.format("%.2f", baseLocations.get(i).getY())+
						") , ");
			}
			System.out.println();
		}
		else {
			
			//If there is no base location, inform the user that the system is continuous.
			System.out.println("\n This city does not have mandatory base locations! The problem is continuous!");
			System.out.println();
		}
	}
	
}
