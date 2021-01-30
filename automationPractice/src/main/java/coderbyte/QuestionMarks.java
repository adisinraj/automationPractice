package coderbyte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//STRING MANUPULATION

/*
 * Questions Marks
Have the function QuestionsMarks(str) take the str string parameter, 
which will contain single digit numbers, letters, and question marks, 
and check if there are exactly 3 question marks between every pair of two numbers 
that add up to 10. If so, then your program should return the string true, 
otherwise it should return the string false. If there aren't any two numbers 
that add up to 10 in the string, then your program should return false as well.

For example: if str is "arrb6???4xxbl5???eee5" then your program should return true 
because there are exactly 3 question marks between 6 and 4, and 3 question marks 
between 5 and 5 at the end of the string.

Examples
Input: "aa6?9"
Output: false
Input: "acc?7??sss?3rr1??????5"
Output: true
 * */
public class QuestionMarks {
	public static boolean QuestionsMarks(String str) {
		if(str.equals(null)) {
			return false;
		}
		
	    final int QuestionsMarks =3;
	    char[] stringChars = str.toCharArray();
	    
	    List positionOfNubers = new ArrayList<>();
	    List positionOfQMark = new ArrayList<>();
	    	    
	  
	    
	    for(int i=0; i<stringChars.length; i++){
	    	if(stringChars[i]>47 && stringChars[i]<58) {
	    		positionOfNubers.add(i);
	    	}
	    	
	    	if(stringChars[i] == '?') {
	    		positionOfQMark.add(i);
	    	}
	    	
	    }
	    
	    System.out.println(positionOfNubers);
	    System.out.println(positionOfQMark);
	    
	    System.out.println((stringChars[(int) positionOfNubers.get(0)]-'0'+stringChars[(int) positionOfNubers.get(1)]-'0'));
	    int questCount =0;
	   for(int j=0; j<positionOfNubers.size()-1;j++) {
		   if((stringChars[(int) positionOfNubers.get(j)]-'0'+stringChars[(int) positionOfNubers.get(j+1)]-'0') == 10) {
			  
			   //check for presence of 3 ?s
			   for(int i=0;i< positionOfQMark.size() ;i++) {
				   if((int)positionOfQMark.get(i) > (int) positionOfNubers.get(j) && (int)positionOfQMark.get(i) < (int)positionOfNubers.get(j+1)) {
					   questCount++;
				   }
			   }
			   
		   }
	   }
	   
	   System.out.println("Ques count="+questCount);
	    
	   if(questCount == QuestionsMarks) return true;
	   else  return false;
	  }

	  public static void main (String[] args) {  
	    // keep this function call here     
	    Scanner s = new Scanner(System.in);
	  //  System.out.print(QuestionsMarks(s.nextLine())); 
	     System.out.print(QuestionsMarks("arrb6???4xxbl5???eee5")); 
	  }
}
