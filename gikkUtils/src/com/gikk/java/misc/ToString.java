package com.gikk.java.misc;

public class ToString {

	//*******************************************************************************************************
	//region								STATIC			
	//*******************************************************************************************************

	public static String doubleArray(double ... in){
		String out = "[ ";
		for(double d : in){
			out+= (d+" , ");
		}
		//Magic number 2 stems from the wish to remove the ", " from the end of the string.
		//If the for-loop was never entered however, out.lenght == 2. In that case, we do nothing 
		out = out.substring(0, out.length()-2 > 0 ? out.length() : 2); 
		return out + "]";
	}
	
	public static String integerArray(int ... in){
		String out = "[ ";
		for(int i : in){
			out+= (i+" , ");
		}
		//Magic number 2 stems from the wish to remove the ", " from the end of the string.
		//If the for-loop was never entered however, out.lenght == 2. In that case, we do nothing 
		out = out.substring(0, out.length()-2 > 0 ? out.length() : 2); 
		return out + "]";
	}

	public static String numberArray(Number ... in){
		String out = "[ ";
		for(Number n : in){
			out+= (n.toString()+" , ");
		}
		//Magic number 2 stems from the wish to remove the ", " from the end of the string.
		//If the for-loop was never entered however, out.lenght == 2. In that case, we do nothing 
		out = out.substring(0, out.length()-2 > 0 ? out.length() : 2); 
		return out + "]";
	}
	//endregion *********************************************************************************************
	//*******************************************************************************************************
	}
