package concepts;

public class StringConcepts {
	public static void main(String[] args) {
		String s ="this is a string";
		String newString="";
		String[] sarray = s.split(" ");
		for (String string : sarray) {
			if(string.contains("t")) {
			//	System.out.println(string);
				newString = newString+" " + reverse(string);
			}
			else
			newString = newString+" "+ string;
		}
		
		System.out.println("out string = "+s);
		System.out.println("new string = "+newString);
	}
	
	public static String reverse(String word) {
		char[] chars = word.toCharArray();
		String news = " ";
		for(int i=chars.length-1; i>= 0; i--) {
			news=news+chars[i];
		}
		System.out.println(news);
		return news;	
	}
}
