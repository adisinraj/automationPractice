package inerview;

public class Mirror {
	public static void main(String[] args) {
		String word = "abcdefghijklmnopqrstuvwxyz" ;
		word="indian";
		
		char[] chars = word.toCharArray();
		int i=0;
		for (char c : chars) {
			int decimalValue = word.charAt(i);
			if(decimalValue>96 && decimalValue<123) {
				System.out.print((char)(97+122-decimalValue));
			}
			i++;
		}
		
	}
	
	public static char mirror(char c) {
		int decimal = c;
		int mirror = c+26;
		if(mirror>122) {
			mirror = 97+(122-decimal);
		}
		
		return (char)mirror;
	}
}

