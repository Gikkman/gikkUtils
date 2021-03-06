package com.gikk.java.math;

import java.util.Arrays;

/**Z Score normalization in range 0 - 1. <br>
 * See <a href=http://www.cs.indiana.edu/~predrag/classes/2005springi400/lecture_notes_4_1.pdf> Indiana.edu </a href> for algorithm details
 * <br><br>
 * This class implements the Normalizer interface
 *
 * 
 * <br><br><code>
 * Normalize (e) = ( e - mean(E) ) / (stdDev(E) )
 * <br><br>
 * Mean (E) = ( 1 / |E| ) * ( sum( values in E ) )
 * <br><br>
 * StdDev (E) = sqrt( ( 1 / ( |E| - 1)  ) * ( sum( (e - mean(E))^2 ) ) )
 * <br><br>
 * |E| = number of elements in E
 * </code>
 * @author Gikkman
 *
 */
public class Z_ScoreNormalizer implements Normalizer{
	
	/********************************************************************************************************/
	//													DOUBLES
	/********************************************************************************************************/
	
	/**Complexity: O( 3 * N )
	 */
	@Override
	public double[] normalize(double[] in){
		double mean = calcMean(in);
		double stdDev = calcStdDev(in, mean);
		
		return normalize(in, mean, stdDev);
	}

	/**Complexity: O( N )
	 */
	public double[] normalize(double[] in, double mean, double stdDev) {
		double[] out = new double[in.length];
		
		for(int i = 0; i < in.length; i++){
			out[i] = normalize(in[i], mean, stdDev);
		}
		
		return out;
	}

	/**Complexity: O( 1 )
	 */
	public double normalize(double in, double mean, double stdDev) {
		return (in - mean) / stdDev;
	}

	/**Complexity: O( N )
	 */
	public double[] denormalize(double[] in, double mean, double stdDev) {
		double[] out = new double[in.length];
		
		for(int i = 0; i < in.length; i++){
			out[i] = denormalize(in[i], mean, stdDev);
		}
		
		return out;
	}

	/**Complexity: O( 1 )
	 */
	public double denormalize(double in, double mean, double stdDev) {
		return in * stdDev + mean;
	}

	private double calcMean(double[] in) {
		return Arrays.stream(in).sum() / in.length;
	}
	
	private double calcStdDev(double[] in, double mean) {
		double val = 0;
		for( double d : in )
			val += (d - mean)*(d-mean);
		return Math.sqrt( val / (in.length - 1) );
	}
}
