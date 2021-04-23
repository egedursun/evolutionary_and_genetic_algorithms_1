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


package support;

import java.util.ArrayList;

import model.Problem;

public class PrintSupport {

	/*
	 * 
	 * 	THIS CLASS CONTAINS THE METHODS THAT IS USED FOR PRINTING THE METRICS FOR DIFFERENT SETS OF CALCULATIONS WITH DIFFERENT PARAMETERS
	 * 
	 * */
	
	
	//This method prints the multi-metrics for an increased number of calculations with different parameter sets.
	public static void printMultiMetrics(Problem problem, ArrayList<ArrayList<Double>> multiResultsAvg, ArrayList<ArrayList<Double>> multiMetrics) {
		
		for(int i = 0; i<multiResultsAvg.size(); i++) {
			
			System.out.println("RESULTS FOR PARAMETER SET - "+i+" : ");
			
			ArrayList<Double> resultsAvg = multiResultsAvg.get(i);
			
			for(int j = 0; j<resultsAvg.size(); j++ ) {
				System.out.println("RUN "+ (j+1) + " : " + resultsAvg.get(j)  + " / "+ problem.getCity().getCustomerAmount() + " ( %" + (resultsAvg.get(j)/problem.getCity().getCustomerAmount())*100 + " )");
			}
			System.out.println("_____________________");
			
			ArrayList<Double> metrics = multiMetrics.get(i);
		
		
			System.out.println("AVERAGE : " + metrics.get(0)  + " / "+ problem.getCity().getCustomerAmount() + " ( %" + (metrics.get(0)/problem.getCity().getCustomerAmount())*100 + " )");
			System.out.println("STANDARD DEVIATION : "+ metrics.get(1) + " / "+ problem.getCity().getCustomerAmount() + " ( %" + (metrics.get(1)/problem.getCity().getCustomerAmount())*100 + " )");
			System.out.println("BEST RESULT : "+ metrics.get(2)  + " / "+ problem.getCity().getCustomerAmount() + " ( %" + (metrics.get(2)/problem.getCity().getCustomerAmount())*100 + " )");
			System.out.println("WORST RESULT : " + metrics.get(3)  + " / "+ problem.getCity().getCustomerAmount() + " ( %" + (metrics.get(3)/problem.getCity().getCustomerAmount())*100 + " )");
			System.out.println("MEDIAN : " + metrics.get(4)  + " / "+ problem.getCity().getCustomerAmount() + " ( %" + (metrics.get(4)/problem.getCity().getCustomerAmount())*100 + " )");
			
			System.out.println("**********************");
			System.out.println();
			
			
			}
		
	}
}
