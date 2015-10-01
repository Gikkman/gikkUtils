package com.gikk.java.math;

/**Decimal scaling normalization of the data, ranging from 0 - 1. <br>See <a href=http://www.cs.indiana.edu/~predrag/classes/2005springi400/lecture_notes_4_1.pdf> Indiana.edu </a href> for algorithm details
 * <br><br>
 * This class implements the Normalizer interface
 * <br><br><code>
 * Normalize (e) =  e / (10 ^ c) where c = Log10( max(E) ) + 1
 * </code>
 * 
 * 
 * @author Gikkman
 *
 */
public class DecimalScalingNormalizer implements Normalizer{

	/** Complexity: O( 2 * n )
	 */
	@Override
	public double[] normalize(double[] in){
		int scale  = findScale(in);
		
		return normalize(in, scale);
	}

	/** Complexity: O( n )
	 */
	public double[] normalize(double[] in, int scale) {
		double[] out  = new double[in.length];
		
		for(int i = 0; i < in.length; i++)
			out[i] = normalize(in[i], scale);
		
		return out;
	}

	/** Complexity: O( 1 )
	 */
	public double normalize(double in, int scale) {
		return in / Math.pow(10, scale);
	}	

	/** Complexity: O( n )
	 */
	public double[] denormalize(double[] in, int scale) {
		double[] out  = new double[in.length];
		
		for(int i = 0; i < in.length; i++)
			out[i] = denormalize(in[i], scale);
		
		return out;
	}

	/** Complexity: O( 1 )
	 */
	public double denormalize(double in, int scale) {
		return in * Math.pow(10, scale);
	}

	/** Complexity: O( n )
	 */
	private int findScale(double[] in) {
		double max = Double.NEGATIVE_INFINITY;
		for( double val : in)
			if( Math.abs(val) > max )
				max = val;
		
		return (int) Math.log10(max) + 1;
	}
}
