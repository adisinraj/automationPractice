package TestVagrant;

public class Test1 {
/*
 * String str = "Bangalore is capital of Karnataka"
 
 O/p -  Berolagna Is Clatipa Of Kakatanra
  Berolagna Is Clatipa Of Kakatanra
 * 
 */
	
	public static void main(String[] args) {
		String str = "Bangalore is capital of Karnataka where";
		String[] words = str.split(" ");
		String newString="";
			
		for(String word: words) {
	
				newString= newString+reverse(word);
		}
		
		System.out.println(newString);
	}
	public static String reverse(String word) {
		char[] words = word.toCharArray();
		String newWord = null;
		for(int i=0; i<words.length;i++) {
			if(i==0) {
				newWord = " "+words[i];
				newWord = newWord.toUpperCase();
			}
			else
			{
				newWord= newWord+words[words.length-i];
			}
	 }
	//	System.out.println(newWord);
		return newWord;
	}
}
