package arrayOperations;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ArrayOfArrays {

	public static String FindIntersection(String[] strArr) {
	   
	    Set<String> setOfChars = new HashSet();
	    StringBuilder returnstring = new StringBuilder();
	    String[] array1 = strArr[0].split(",");
	    for (String string : array1) {
	    	setOfChars.add(string.trim());
		}
	    String[] array2 = strArr[1].split(",");
	    for (String d : array2) {
			if(setOfChars.contains(d.trim())) {
				returnstring.append(d+" ");
			}
		}
	    return returnstring.toString().trim().replace(" ", ",");
	  }

	  public static void main (String[] args) {  
	    // keep this function call here     
	    Scanner s = new Scanner(System.in);
	    System.out.print(FindIntersection(new String[] {"1, 5, 6, 7, 10, 11, 12", "5, 6, 8, 11, 17"})); 
	  }
}
