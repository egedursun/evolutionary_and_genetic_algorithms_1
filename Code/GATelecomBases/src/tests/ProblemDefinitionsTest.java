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

import model.Problem;

public class ProblemDefinitionsTest {

	/*
	 * 
	 * THIS CLASS IS USED FOR TESTING THE PRINTING OF THE PROBLEM DEFINITIONS WHICH WAS MENTIONED ON HOMEWORK -> PART 1
	 * 
	 */
	
	public static void main(String[] args) {
		
		//Achieving PROBLEM A -> solves the problem in CITY A
		Problem problemA = GlobalGAVariables.problemA;
		problemA.toString();
		
		//Achieving PROBLEM B -> solved the problem in CITY B
		Problem problemB = GlobalDEVariables.problemB;
		problemB.toString();

	}
}
