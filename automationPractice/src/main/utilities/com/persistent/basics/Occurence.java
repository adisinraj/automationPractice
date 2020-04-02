package com.persistent.basics;

import java.util.HashMap;
import java.util.Map;

public class Occurence {
public static void main(String[] args) {
	String string = "asdlkfjasfo";
	char ch[] = string.toCharArray();
	Map map = new HashMap();
	for (char c : ch) {
		int count=1;
		if(map.containsKey(c)) {
			count = (Integer) map.get(c);
			count ++;
			map.put(c, count);
		}
		else
			map.put(c, count);
	}
	
	System.out.println(map.entrySet());
}
}
