package inerview;

import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.map.HashedMap;

public class MostCommon {

	public static void main(String[] args) {

		String s = "This is Pune Druva is in Pune";
		String[] words = s.split(" ");

		StringBuilder mostcommonword = null;
		int highestFrequency = 0;
		
		
		int count = 1;
		Map<String, Integer> mapofSrtring = new HashedMap();
		for (String string : words) {
			if (mapofSrtring.containsKey(string)) {
				count = mapofSrtring.get(string);
				count++;
				mapofSrtring.put(string, count);
			}
			else {
				mapofSrtring.put(string, count);
			}
				
		}

		System.out.println(mapofSrtring.entrySet());

		for (Entry<String, Integer> singleMap :mapofSrtring.entrySet()) {
			//System.out.println(singleMap.getValue());
			if(singleMap.getValue()>highestFrequency) {
				StringBuilder builder = new StringBuilder(singleMap.getKey());
				mostcommonword = builder;
				highestFrequency = singleMap.getValue();
			}
			
			else if(singleMap.getValue()>=highestFrequency && highestFrequency != 0) {
				mostcommonword.append(singleMap.getKey());
			}
		}
		
		System.out.println(mostcommonword);

	}

}
