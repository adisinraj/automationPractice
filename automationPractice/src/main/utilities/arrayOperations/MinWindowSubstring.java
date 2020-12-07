package arrayOperations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class MinWindowSubstring {

	public static String MiniWindowSubstring(String[] strArr) {
		String fromStrings = strArr[0];
		String toStrings = strArr[1];
		char[] charArray = toStrings.toCharArray();
		
		int containsAllElement = 0;
		Set<String> stringSet = new HashSet();
		Set<String> sortedCharSet = new LinkedHashSet();

		for (int i = 0; i < fromStrings.length(); i++) {
			for (int j = i; j <= fromStrings.length(); j++) {
				stringSet.add(fromStrings.substring(i, j));
			}
		}
		System.out.println(stringSet);
		for (String string : stringSet) {
			containsAllElement = 0;
			for (char c : charArray) {
				if (string.contains(Character.toString(c))) {
					containsAllElement++;
				}

				if (charArray.length == containsAllElement) {
					sortedCharSet.add(string);
				}
			}
		}
		
		/*
		 * System.out.println(sortedCharSet); String[] arrayOfString =
		 * sortedCharSet.toArray(new String[0]); for (int i=1 ;i< sortedCharSet.size();
		 * i++) { String temp = arrayOfString[i];
		 * 
		 * // Insert s[j] at its correct position int j = i - 1; while (j >= 0 &&
		 * temp.length() < arrayOfString[j].length()) { arrayOfString[j+1] =
		 * arrayOfString[j]; j--; } arrayOfString[j+1] = temp; }
		 */
		return sortedCharSet.iterator().next();
	}

	public static void main(String[] args) {
		// keep this function call here
		System.out.print(MiniWindowSubstring(new String[] { "aabdccdbcacd", "aad" }));
	}

}