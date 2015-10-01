package com.gikk.java.misc;

public class Box {
	//*******************************************************************************************************
	//region								STATIC			
	//*******************************************************************************************************
	public static Double[] doubleArray(double ... in){
		Double[] out = new Double[in.length];
		for(int i = 0; i < in.length; i++)
			out[i] = in[i];
		return out;
	}	
	
	public static Integer[] integerArray(int ... in){
		Integer[] out = new Integer[in.length];
		for(int i = 0; i < in.length; i++)
			out[i] = in[i];
		return out;
	}
	//endregion *********************************************************************************************
	//*******************************************************************************************************

}
