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

public class GlobalGAVariables {

	/*
	 * 	THESE VARIABLES DEFINE THE "CITY A" THAT WAS MENTIONED IN THE HOMEWORK (PART : 2)
	 * 
	 * */
	
	//Problem parameters
	private static double width = 400;
	private static double height = 400;
	private static int customerAmount = 250;
	private static int baseLocationAmount = 100;
	private static double coverRadius = 30;
	private static int baseAmount = 50;
	
	//Defining the city and the problem for CITY A
	public static City cityA = new City(width, height, customerAmount, baseLocationAmount, baseAmount);
	public static Problem problemA = new Problem(cityA, coverRadius);
}
