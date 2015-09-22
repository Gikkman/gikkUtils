package com.gikk.java.math;

/**MinMax normalization of the data, ranging from 0 - 1. <br>See <a href=http://www.cs.indiana.edu/~predrag/classes/2005springi400/lecture_notes_4_1.pdf> Indiana.edu </a href> for algorithm details
 * <br><br><code>
 * Normalize (e) = ( e - min(E) ) / ( max(E) - min(E) )
 * </code>
 * 
 * 
 * @author Gikkman
 *
 */
public class MinMaxNormalizer implements Normalizer{
	
	/********************************************************************************************************/
	//													DOUBLES
	/********************************************************************************************************/
	
	/**Complexity: O( 2 * N )
	 */
	@Override
	public double[] normalize(double[] in){	
		double min = Double.POSITIVE_INFINITY, max = Double.NEGATIVE_INFINITY;
		
		//Find minimum and maximum value in the array
		for( double val : in ){
			if( val > max )
				max = val;
			if( val < min )
				min = val;
		}
		
		return normalize(in, min, max);	
	}
	
	/**Complexity: O( N )
	 */
	public double[] normalize(double[] in, double min, double max){
		//Create normalized data
		double[] out = new double[ in.length ];	
		for( int i = 0; i < out.length; i++){
			out[i] = normalize(in[i], min, max);
		}
		
		return out;
	}
	
	/**Complexity: O( 1 )
	 */
	public double normalize(double in, double min, double max){
		return (in - min) / (max - min);
	}

	/**Complexity: O( N )
	 */
	
	public double[] denormalize(double[] in, double min, double max) {
		//Create denormalized data
		double[] out = new double[ in.length ];	
		for( int i = 0; i < out.length; i++){
			out[i] = in[i] * (max - min) + min;
		}
		
		return out;
	}
	
	/**Complexity: O( 1 )
	 */
	public double denormalize(double in, double min, double max){
		return in * (max - min) + min;
	}
}
