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


public class MathSupport {

	/*
	 * 	THIS CLASS CONTAINS THE MATHEMATICAL SUPPORT FUNCTIONS THAT THE PROGRAM USES FOR EVALUATING METRICS FOR SOLUTIONS.
	 * 
	 */
	
	
	//This method calculates the standard deviation of the given elements in an arraylist
	public static double sd (ArrayList<Double> results)
	{
		
	    double average = average(results);
	    double temp = 0;

	    for (int i = 0; i < results.size(); i++)
	    {
	        double val = results.get(i);

	        double squrDiffToMean = Math.pow(val - average, 2);

	        temp += squrDiffToMean;
	    }

	    double meanOfDiffs = (double) temp / (double) (results.size());

	    return Math.sqrt(meanOfDiffs);
	}
	
	
	//This method calculates the median of the given elements in an arraylist
	public static double median (ArrayList<Double> results) {
		
		double median = (results.get(results.size()/2) + results.get(results.size()/2 - 1))/2;
		return median;
	}
	
	
	//This method takes the average of the given elements in an arraylist
	public static double average (ArrayList<Double> results) {
		
		double summation = 0;
		for (int i = 0; i<results.size(); i++) {
			summation = summation + results.get(i);
		}
		
		double average = summation/results.size();
		return average;
	}
	
	
	//This method takes the best result in a given arraylist and mainly used for taking the maximum fitness value in a metrics array.
	public static double getBestResult(ArrayList<Double> results){
		
		double max = 0;
		for(int i = 0; i<results.size(); i++) {
			
			if(results.get(i) > max) {
				max = results.get(i);
			}
			else {
				continue;
			}
		}
		
		return max;
	}
	
	
	//This method takes the worst result in a given arraylist and mainly used for taking the minimum fitness value in a metrics array.
	public static double getWorstResult(ArrayList<Double> results){
		
		double min = results.get(0);
		for(int i = 0; i<results.size(); i++) {
			
			if(results.get(i) < min) {
				min = results.get(i);
			}
			
		}
		
		return min;
	}
	
}
