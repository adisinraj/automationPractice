package com.persistent.basics;

public class Palindrome {
public static void main(String[] args) {
	String string = "abrarba";
	char[] chars = string.toCharArray();
	System.out.println(string.length()/2);
	for (int i = 0; i < string.length()/2; i++) {
		if(chars[i]!=chars[string.length()-i-1]) {
			System.out.println("not a palindrome");
			return;
		}
	}
}
}
