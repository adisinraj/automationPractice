package com.persistent.basics;

public abstract class AbstractClass1 extends AbstractClass2{
	
	public static void test() {
		System.out.println("in the test parent");
	}
	
	public void concreteMethod() {
		System.out.println("in concrete method");
	}

	public static void main(String[] args) {
		test();
	}
}
