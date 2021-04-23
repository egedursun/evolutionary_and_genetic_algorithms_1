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

public class Base {
	
	/*
	 * 
	 * THIS CLASS DEFINES THE BASE OBJECT THAT WILL BE USED FOR DESCRIBING THE GENE IN THE CHROMOSOME OF THE INDIVIDUAL
	 * 
	 * EACH BASE HAS A LOCATION IN THE 2-DIMENSIONAL SPACE SUCH THAT X -> HORIZONTAL  &  Y -> VERTICAL AXIS.
	 * 
	 * EACH BASE ALSO HAS A COVER RADIUS WHICH MEANS HOW FAR THEY CAN SERVE THE TELECOMMUNICATION SERVICES AT MAXIMUM.
	 * 
	 */

	private int id;
	private double x;
	private double y;
	private double coverRadius;
	
	
	private static int counter = 0;


	public Base(double x, double y, double coverRadius) {
		counter ++;
		this.id = counter;
		this.x = x;
		this.y = y;
		this.coverRadius = coverRadius;
	}
	
	public static int getBaseAmount() {
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

	public double getCoverRadius() {
		return coverRadius;
	}

	public void setCoverRadius(double coverRadius) {
		this.coverRadius = coverRadius;
	}
	
	
}
