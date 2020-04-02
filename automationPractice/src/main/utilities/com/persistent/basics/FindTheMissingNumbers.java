package com.persistent.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTheMissingNumbers {
	public static void main(String[] args) {
		Integer[] array1= {1,2,3,4,5,8,9,10};
		List missingNumbers =  new ArrayList();
		List<Integer> array2 = Arrays.asList(array1);
		for(int i = 1;i<=10;i++) {
			if(array2.contains(i))
				continue;
			else
				missingNumbers.add(i);
		}
		
		System.out.println(missingNumbers.toString());
	}

}
