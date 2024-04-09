package Project_1B;

//import java.util.Arrays;

public class CalcReport {
	
	//Gets array, sums, and averages it
	public static double getAverage(double[] data) {
	    double sum = 0;
	     int i;
	     for (i = 0; i < data.length; i++) {
	    	 sum += data[i];
	     }
	     return sum / data.length;
	}

	 //Creates array of random numbers from 0 and 999
	 public static int[] generateData(int rand) {
	     int[] data = new int[rand];
	     for (int i = 0; i < rand; i++)
	         data[i] = (int) (Math.random() * 1000);
	     return data;
	 }

	 //Calculates the standard deviation which is how close the data is to average.
	 public static double getStandardDeviation(double[] data) {
	    double sum = 0;
	        
	    for (int i = 0; i < data.length; i++) {
	        double um = data[i];
	        sum += (um - getAverage(data)) * (um - getAverage(data));
	    }	            
	    return Math.sqrt(sum / (data.length - 1));
	  }
	    
	 //Shows the extent of variability in relation to the average.
	 public static double getCoefficientOfVariance(double[] data) {
	    	
	     return ((getStandardDeviation(data)) / getAverage(data)) * 100;
	 }		
}//End of CalcReport Class
