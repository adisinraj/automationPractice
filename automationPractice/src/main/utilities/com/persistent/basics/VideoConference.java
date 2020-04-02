package com.persistent.basics;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class VideoConference {
	
	 static Map<String,String> prefixTable = new HashMap();
	 static Set<String> prefixes=new TreeSet();

	public static void main(String[] args) {
		
		String[] arrayOfNames = {"alvin","alice","alvin","Joe","Harry","alice","alvin","Jo","alice"};

		for (String name : arrayOfNames) {
			generatePrefix(name);
		}
		
		
//		System.out.println("Aditya".substring(0,1));
	}
	
	private static void generatePrefix(String name) {
		String prefix="";
		
		
		if(prefixTable.containsKey(name)) {
			prefix = prefixTable.get(name);
		} 
		else
		{
			prefix = name.substring(0, 1);
		}
	//	prefixTable.putIfAbsent(name, prefix); // prefixTable.put(name, prefix); When we will try to add duplicate key
												// then put() method will replace existing key to new key; putIfAbsent()
												// method will not replace existing key to new key.
		if(prefixes.contains(prefix)) {
		//	String temp =name.substring(0,2);
			if(prefix.equals(name.substring(0,2)))
				prefix = name.substring(0);
			else
				if(name.length()>3)
			prefix = name.substring(0,3);
				else
					prefix = name.substring(0,2);
		}
	
		prefixes.add(prefix);
		prefixTable.putIfAbsent(name, prefix);
		
		System.out.println(prefix);
	}


	/*
	 * private static void generatePrefix(String name) { String prefix;
	 * if(prefixTable.containsKey(name)) { String tempName = prefixTable.get(name);
	 * Integer lastNo = tempName.indexOf(tempName.length()-1); if (lastNo instanceof
	 * Integer) { lastNo++; } prefix = name+ Math.round(Math.random()+lastNo); }
	 * else { if(name.length()<3) { prefix = name.substring(0); } else prefix =
	 * name.substring(0,1); prefixTable.putIfAbsent(name, prefix); //
	 * prefixTable.put(name, prefix); When we will try to add duplicate key then
	 * put() method will replace existing key to new key; putIfAbsent() method will
	 * not replace existing key to new key. prefixes.add(prefix); }
	 * 
	 * System.out.println(prefix); }
	 */
}
