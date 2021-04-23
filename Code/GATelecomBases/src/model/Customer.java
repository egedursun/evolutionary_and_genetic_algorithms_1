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

public class Customer {

	/*
	 * 
	 * CUSTOMERS ARE REPRESENTING THE MAJOR FACTOR THAT AFFECTS THE FITNESS AS THE AIM IS TO OPTIMIZE THE NUMBER OF CUSTOMERS
	 * WHO CAN ACHIEVE SIGNALS FROM THE TELECOMMUNICATION BASES.
	 * 
	 * EACH CUSTOMER HAS SPECIFIC COORDINATES IN THE CITY / 2-DIMENSIONAL SPACE SUCH THAT X -> HORIZONTAL AXIS & Y -> VERTICAL AXIS
	 * 
	 * 
	 */
	
	private int id;
	private double x;
	private double y; 
	
	private static int counter = 0;

	public Customer(double x, double y) {
		counter++;
		this.id = counter;
		this.x = x;
		this.y = y;
	}
	
	public static int getCustomerAmount() {
		return counter;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
}
