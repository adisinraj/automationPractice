package com.persistent.basics;

import javax.management.RuntimeErrorException;

public class TryCatch {
	public static void main(String[] args) {
		try {
			
			System.out.println(1/1);
			//throw new RuntimeErrorException(null);
		}
		
		catch(Exception e) {
			System.out.println("inthe catch");
			e.printStackTrace();
		}
		
		finally {
			System.out.println("in the finally");
		}
	}

}
