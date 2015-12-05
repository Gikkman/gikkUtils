package com.gikk.java.debug;

public class StackTrace {
	/**Returns a link to a code position
	 * Intended to be inserted in an error message. 
	 * 
	 * The "depth" decides how many stack-images up you want displayed.
	 * <br><b>Example:</b>
	 * <br>I call a method foo() and in foo() i call method bar()
	 * from bar(), I want a message with a link to foo().
	 * In that case, depth is 1 (since foo() is one image
	 * 	"up" from bar() ). If I wanted it to point to the
	 *  line which caused the error in bar(), depth is 0.
	 * @return 
	 */
	public static String getStackPos(){
		String out = "   ";
		StackTraceElement[] e = new Exception().getStackTrace();
		
		for( int i = 1; i < e.length && i < 5; i++){
			String s = e[i].toString();
			int f = s.indexOf("(");
			int l = s.lastIndexOf(")")+1;
			out += s.substring( f , l)+" ";
		}
		return out;
	}
}
