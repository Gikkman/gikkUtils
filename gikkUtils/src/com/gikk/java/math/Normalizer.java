package com.gikk.java.math;

public interface Normalizer {
	
	/**Normalizes the input data using the underlying normalization algorithm.
	 * 
	 * @param in The data that'll be normalized
	 * @return A new array with normalized data. Order is retained.
	 */
	public double[] normalize(double[] in);
}
