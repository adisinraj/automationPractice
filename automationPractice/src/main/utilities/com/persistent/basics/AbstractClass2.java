package com.persistent.basics;

public class AbstractClass2  {

	public void test2() {
		System.out.println("in implemented method");
		
	}
	
	public static void main(String... args) {
		AbstractClass1.test();
		System.out.println("in child class");
	}

}
