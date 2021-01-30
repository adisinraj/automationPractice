package inerview;

import java.util.Arrays;

//arrange the words in string according to the word length.
public class Interview {
	
	public static void main(String[] args) {
		String s = "Second most a commonly occurring word in a string This will be arranged based on the words length";
		String[] arrayOfWords = s.split(" ");
		
		for (int j = 0; j < arrayOfWords.length; j++) {
			for(int i =0;i<arrayOfWords.length-1;i++) {
				String temp = arrayOfWords[i];
				
				if(arrayOfWords[i+1].length() > arrayOfWords[i].length()) {
					arrayOfWords[i] = arrayOfWords[i+1];
					arrayOfWords[i+1]=temp;
				}
				
				System.out.println(Arrays.toString(arrayOfWords));
			}
		}
		//System.out.println(arrayOfWords[2]);
		System.out.println(Arrays.toString(arrayOfWords));
		
			
		}
	
}
