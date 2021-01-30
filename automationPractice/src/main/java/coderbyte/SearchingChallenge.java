package coderbyte;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SearchingChallenge {

	  public static String SearchingChallenge(String str) {
		  Set<String> stringSet = new HashSet<String>();
		  
		  System.out.println(str.length());
		  for(int i=0;i<str.length()-1;i++) {
			  for(int j =i ; j <= str.length(); j++) {
				  System.out.println(str.substring(i, j));
				  stringSet.add(isWordPalindrome(str.substring(i, j)));
			  }
		  }
		  
		  int largestPalindrome = 0;
		  String largest_Palindrome = "none";
		  for (String string : stringSet) {
			if(largestPalindrome<string.length()) {
				largest_Palindrome= string;
				largestPalindrome= string.length();
			}
		}
		  
	    return largest_Palindrome;
	  }
	  
	  public static String isWordPalindrome(String str) {
		  if(str.length()<3) {
			  return "none";
		  }
		    
		  char chars[] = str.toCharArray();
		    for (int i = 0; i < str.length()/2; i++) {
				if(chars[i]!=chars[str.length()-i-1]) {
					//System.out.println("not a palindrome");
					
					return "none";
				}
			}
		    return str;
	  }

	  public static void main (String[] args) {  
	    // keep this function call here     
	    Scanner s = new Scanner(System.in);
	 //   System.out.print(SearchingChallenge(s.nextLine())); 
	    System.out.println(SearchingChallenge("abcdefgg"));
	  }
}
