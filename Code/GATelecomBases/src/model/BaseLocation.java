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

public class BaseLocation {

	/*
	 * 
	 * THIS CLASS DEFINES THE BASE LOCATION OBJECT WHICH IS REPRESENTING THE POSSIBLE LOCATIONS INSIDE A CITY
	 * THAT THE TELECOMMUNICATIONS COMPANY CAN USE TO PUT THE BASE OBJECTS.
	 * 
	 * EACH BASELOCATION HAS 2-DIMENSIONAL COORDINATES IN THE CITY SUCH THAT X -> HORIZONTAL & Y -> VERTICAL AXIS.
	 * 
	 * EACH BASELOCATION ALSO HAS AN ASPECT CALLED isOccupied, SO WHILE RANDOMIZING THE BASES, THERE CAN'T BE MORE THAN 1 BASES AT THE SAME BASE LOCATIONS
	 * 
	 */
	
	private int id;
	private double x;
	private double y;
	private boolean isOccupied;
	
	private static int counter = 0;

	public BaseLocation(double x, double y) {
		counter++;
		this.id = counter;
		this.x = x;
		this.y = y;
		this.isOccupied = false;
	}
	
	public static int getBaseLocationAmount() {
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

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}
	
}
