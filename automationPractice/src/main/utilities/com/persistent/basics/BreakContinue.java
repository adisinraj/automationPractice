package com.persistent.basics;

public class BreakContinue {
	public static void main(String[] args) {
		for(int j=0;j<2;j++) {
		for(int i=0;i<2;i++) {
			System.out.println("Before if");
			if(i==1) {
				continue;
			}
			System.out.println("After if");
		 }
		System.out.println("outer loop");
		}
	}
}