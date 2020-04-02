package com.persistent.basics;

public class StringFunctions {
	public static void main(String[] args) {
		longestPalindromeString("1234");
	}
	public static String longestPalindromeString(String s) {
		String s1 = new String("pankaj");
		String s2 = new String("PANKAJ");
	//	System.out.println(s1 = s2);
		
		String str1 = "abc";
		StringBuffer str2 = new StringBuffer("abc");
	//	System.out.println(str1.equals(str2));
		
		String st1 = "abc";
		String st2 = new String("abc");
		st2 =st2.intern();
	//	System.out.println(st1 ==st2);
		
		
		String ss1 = new String("Hello");  
		String s_1 ="Hello";
		System.out.println(s_1 == ss1);
		String ss2 = new String("Hello");
		System.out.println(ss1 ==ss2);
	
		
		ss1= ss1.intern();
		ss2=ss2.intern();
		
		System.out.println(ss1==ss2);
		
		
		String sentence = "  this is the example of long string  ";
		System.out.println(sentence.charAt(3));	//returns the character at the mentioned index.
		System.out.println(sentence.codePointAt(14));//return the byte value at the mentioned index
		System.out.println(sentence.concat(" HELLO"));
		System.out.println(sentence.trim());		//trims the blank spaces in front and back
		System.out.println(sentence.endsWith("ng  "));
		System.out.println(String.join("hello", sentence, "bye"));
		System.out.println(sentence.contentEquals("this"));
		System.out.println(sentence.contains("this"));
		System.out.println(sentence.isEmpty());
		return s;
		
	}
}
