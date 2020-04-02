package com.persistent.basics;

import java.util.HashSet;
import java.util.Set;

public class Reverseword {

	public static void main(String[] args) {
	  arrangeAlphabets();
	 // reverseAlphabets();
	}
	
	public static void reverseAlphabets() {
		StringBuilder string = new StringBuilder("adfasdfasdf");
		string.reverse();
		System.out.println(string);
		
	}
	
	
	public static void arrangeAlphabets() {
		String string = "asrjeaaffdssssiowhtbjAWE";
		Set<Character> characters = new HashSet();
		char chars[] = string.toCharArray();
		for (char c : chars) {
			characters.add(c);
		}
		
		System.out.println(characters.toString());
	}

}
