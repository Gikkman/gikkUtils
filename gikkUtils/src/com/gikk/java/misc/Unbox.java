package com.gikk.java.misc;

public class Unbox {
	//*******************************************************************************************************
	//region								STATIC			
	//*******************************************************************************************************
	public static double[] doubleArray(Double ... in){
		double[] out = new double[in.length];
		for(int i = 0; i < in.length; i++)
			out[i] = in[i];
		return out;
	}	
	
	public static int[] integerArray(Integer ... in){
		int[] out = new int[in.length];
		for(int i = 0; i < in.length; i++)
			out[i] = in[i];
		return out;
	}	
	//endregion *********************************************************************************************
	//*******************************************************************************************************

}
