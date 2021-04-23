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

public class City {

	/*
	 * 
	 * CITY IS THE OBJECT, REPRESENTING THE 2-DIMENSIONAL SPACE THAT THE TELECOMMUNICATIONS COMPANY AIMS TO WORK ON TO PUT THE BASE OBJECTS
	 *
	 * CITIES HAVE A WIDTH, REPRESENTING THE LARGENESS ON HORIZONTAL AXIS, AND A HEIGHT, REPRESENTING THE LARGENESS ON VERTICAL AXIS.
	 *
	 * CITIES CAN HAVE SPECIFIC BASE LOCATIONS OR NOT. THAT DEPENDS ON THE CHOICE OF THE USER AND IF THE CITY HAS SPECIFIC BASE LOCATIONS,
	 * THAT MEANS THAT THE BASES CAN ONLY BE PUT THERE. BUT IF THERE ISN'T, ONE CAN PUT THE BASES ANYWHERE IN THE CITY.
	 * 
	 * CITIES ALSO HAVE SPECIFIC CUSTOMER AMOUNTS AND BASE AMOUNTS THEY COULD CARRY, WHICH IS AGAIN TO THE CHOICE OF THE USER.
	 * 
	 */
	
	private int id;
	private double width;
	private double height;
	private int baseLocationAmount;
	private int customerAmount;
	private int baseAmount;
	
	private static int counter = 0;

	public City(double width, double height, int customerAmount, int baseLocationAmount, int baseAmount) {
		counter++;
		this.id = counter;
		this.width = width;
		this.height = height;
		this.customerAmount = customerAmount;
		this.baseLocationAmount = baseLocationAmount;
		this.baseAmount = baseAmount;
	}
	
	public City(double width, double height, int customerAmount, int baseAmount) {
		counter++;
		this.id = counter;
		this.width = width;
		this.height = height;
		this.customerAmount = customerAmount;
		this.baseLocationAmount = 0;
		this.baseAmount = baseAmount;
	}

	public static int getCityAmount() {
		return counter;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	public int getCustomerAmount() {
		return customerAmount;
	}

	public void setCustomerAmount(int customerAmount) {
		this.customerAmount = customerAmount;
	}

	public int getBaseLocationAmount() {
		return baseLocationAmount;
	}

	public void setBaseLocationAmount(int baseLocationAmount) {
		this.baseLocationAmount = baseLocationAmount;
	}

	public int getBaseAmount() {
		return baseAmount;
	}

	public void setBaseAmount(int baseAmount) {
		this.baseAmount = baseAmount;
	}
	
}
