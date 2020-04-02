package com.persistent.basics;

public class factorial {
/**
 * @param args
 */
public static void main(String[] args) {
	int factorial=01;
	int number =3;
	while(number!=0) {
		factorial = factorial*number;
		number--;
	}
	System.out.println(factorial);
}
}
