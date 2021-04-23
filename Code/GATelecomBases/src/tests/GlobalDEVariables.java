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


package tests;

import model.City;
import model.Problem;

public class GlobalDEVariables {

	/*
	 * 	THESE VARIABLES DEFINE THE "CITY B" THAT WAS MENTIONED IN THE HOMEWORK (PART : 3)
	 * 
	 * */
	
	
	//Problem parameters
	private static double width = 500;
	private static double height = 500;
	private static int customerAmount = 300;
	private static int baseLocationAmount = 0;
	private static double coverRadius = 35;
	private static int baseAmount = 50;
	
	//Defining the City and Problem Objects for CITY B
	public static City cityB = new City(width, height, customerAmount, baseLocationAmount, baseAmount);
	public static Problem problemB = new Problem(cityB, coverRadius);
	
}
