package arrayOperations;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class OccurenceOfWord {

	public static void main(String[] args) {
		String objective = "To associate myself with a challenging career in organizations, where I can put my competitive edge into practice and boost my sense of accomplishment by being a part of the team that excels towards the growth of the organization. Would love to work in a developing environment where the opportunity to learn and to apply ones’ thoughts is maximum.";
		
		//split the string on the basis of the space character
		String[] words = objective.split(" ");
		
		//use Arrays.toString(arrayObject) for printing the String array
		System.out.println(Arrays.toString(words)); // for multi-dimensional array use the Arrays.deepToString(arrayObject);
		
		Integer lengthOfString = words.length;
		Map<String,Integer> map= new LinkedHashMap<String,Integer>();
				
		for(int i = 0; i < lengthOfString ; i++){
			int count = 0;
			for(int j = 0; j< lengthOfString ; j++){
				if(words[i].equalsIgnoreCase(words[j])){
					count++;
				} 
			}
			map.put(words[i],count);
		
		}
		for (Map.Entry string :map.entrySet()) {
			System.out.println(string.getKey()+" : "+string.getValue());
		}
	}

}
