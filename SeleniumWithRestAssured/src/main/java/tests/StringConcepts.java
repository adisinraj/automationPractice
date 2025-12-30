package tests;

import org.apache.commons.collections.comparators.ComparableComparator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringConcepts {
    public static void main(String[] args) {
       /* String str = " Hi, My Name is Aditya ";
        String str2 = new String(" Hi, My Name is Aditya ");
        System.out.println(str == str2);
        str2 = str2.intern();
        System.out.println(str == str2);

        System.out.println(str.trim());
        System.out.println(str.strip());

        String a = "hello";
        String b = "he" + "llo";
        System.out.println(a == b);

        System.out.println("12343243".matches("[0-9]"));*/
        String str = "Hello";
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c: str.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        map.entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .forEach(System.out::println);

    }
}

 class AnagramChecker {

    public static boolean isAnagram(String str1, String str2) {
        // Step 1: Check length
        if (str1.length() != str2.length()) {
            return false;
        }


        // Step 3: Count character frequencies
        for (int i = 0; i < str1.length(); i++) {

            if (str1.replaceAll(String.valueOf(str1.charAt(i)),"").length() != str2.replaceAll(String.valueOf(str1.charAt(i)),"").length()){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("wrap", "warp"));   // true
        System.out.println(isAnagram("aab", "abb"));     // false
        System.out.println(isAnagram("silent", "listen")); // true
    }
}

/*
*
 * 5. 	Write a method to check if two strings are anagrams of each other.
 * 6. 	How would you reverse a string in Java without using built-in methods?
 * 7. 	Write a function to find the first non-repeating character in a string.
 * 8. 	How do you remove duplicate characters from a string while preserving order?
 * 9. 	Given a string, write code to count the number of vowels and consonants.
 * 10. 	How would you validate if a string is a palindrome, ignoring case and non-alphabetic characters?

*/


class ReverseAMethod {

    public static String reverse(String str){
        String newstr = "";
        for(int i=str.length()-1;i>=0;i--){
            newstr += str.charAt(i);
        }

        return newstr;
    }

    public static void main(String[] args) {
       System.out.println(reverse("silent")); // true
    }
}

class NonRepeatingCharInString {

    public static String getChar(String str){
        for (int i = 0; i < str.length()-1; i++) {
            char c = str.charAt(i);
            if(str.replaceAll(c+"","").length() == str.length()-1){
                return  c+"";
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getChar("ssilentent")); // true
    }
}

class RemoveDuplicatePreservingOrder {

    public static String removeDuplicate(String str){
        StringBuilder newstr= new StringBuilder();
        for (int i = 0; i < str.length()-1; i++) {
            char c = str.charAt(i);
            if(str.replaceAll(c+"","").length() != str.length()-1){
                newstr.append(c);
            }
        }
        return str.replaceAll("["+newstr+"]","");
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicate("ssilentent")); // true
    }
}

class VowelsConsonents {

    public static int countVowels(String str){
        return str.replaceAll("[^aeiouAEIOU]","").length();
    }

    public static void main(String[] args) {
        System.out.println( "Vowels are :"+countVowels("ssilentent")+
                " and cons are :"+("ssilentent".length()-countVowels("ssilentent"))); // true
    }
}

class Palindrome {

    public static boolean checkPalindrome(String str){
        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i) != str.charAt(str.length()-1-i)){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkPalindrome("abbaabba")); // true
    }
}

/*
 * 1. 	How would you check if a string contains only digits without using regex or built-in methods like matches()?
 * 2. 	Write a method to find the longest substring without repeating characters. What’s the time complexity of your solution?
 * 3. 	How do you efficiently count the frequency of each character in a string? What data structure would you use?
 * 4. 	Given a string, how would you find the most frequently occurring character?
 * 5. 	How would you reverse the words in a sentence without using split()? Example:  → java is fun -> fun is java
 * 6. 	Write a method to check if two strings are rotations of each other. Example: abcd  → cdab true
 * 7. 	How do you remove all occurrences of a given character from a string without using replace() ?
 * 8. 	Explain the difference between ==  and .equals()  when comparing strings. Why is one preferred over the other?
 * 9. 	How would you compress a string using counts of repeated characters? Example: aaabbc → a3b2c1
 * 10. 	Write a method to check if a string contains only unique characters. What’s the space complexity of your solution?

*/

class OnlyDigits {

    private static boolean checkDigits(String str){
        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i)>=65){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(checkDigits("abbaa123bba")); // false
        System.out.println(checkDigits("433466")); // true
    }
}
//TODO
class LongestSubstring {

    public static boolean checkDigits(String str){
       int start=0,left= 0,right =0;
       String newstr ="";

        while (right <str.length()-1 && left<right) {
            if(!newstr.contains(str.charAt(right)+"")){
                 newstr = str.substring(left,right);
                 right++;
            }else if(!newstr.contains(str.charAt(left)+"")){
                left++;

            }

         }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(checkDigits("aditya")); // false
    }
}

class Frequency {

    public static int countFreq(String str){
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : str.toCharArray()){
            Integer value = map.putIfAbsent(c, 1);
            if( value != null) {
                value++;
                map.put(c,value);
            }
        }
        int maxVal = 0;
        char mostFreq =' ';
        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            if(entry.getValue() > maxVal){
                maxVal = entry.getValue();
                mostFreq = entry.getKey();
            }
        }
        System.out.println(map.toString());
        System.out.println(maxVal);
        System.out.println(mostFreq);
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(countFreq("abba123bba")); // false
    }
}

class Reverse {

    public static String reverse(String str){
       StringBuilder stringBuilder= new StringBuilder();
       char[] chars = str.toCharArray();
           int end = str.length();
       for(int i = str.length()-1; i>=0; i--){
           if(chars[i]==' '){
               stringBuilder.append(str.substring(i+1,end)).append(' ');
               end = i;
           }else if(i==0){
               stringBuilder.append(str.substring(i,end));
           }
       }
       return stringBuilder+"";
    }
    public static void main(String[] args) {
        System.out.println(reverse("This is fun")); // false
    }
}

class Compress {

    public static String compress(String str) {
        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                result.append(str.charAt(i - 1)).append(count);
                count = 1;
            }
        }
        result.append(str.charAt(str.length() - 1)).append(count);
        return result.toString();
    }
    public static void main(String[] args) {
        System.out.println(compress("aaabbcccc")); // false
    }
}

 class LocalVariableTest {
    public void print() {
        int num=0;
        System.out.println("The number is: " + num);
    }
    public static void main(String[] args) {
        LocalVariableTest obj = new LocalVariableTest();
        obj.print();
    }
}

 class Main
{
    public static void main(String[] args) {
 /*  Input 1:  1  1  5  0
          2  3  7  2
          8  9  1  3
          6  7  8  2

*/
        int[][] arr = new int[][]{{1,1,5,0},{2,3,7,2},{8,9,1,3},{6,7,8,2}};
        int[] temparr1 = new int[4];
        for(int i=0; i<4 ;i++){
            for(int j=0;j<4 ; j++){
                temparr1[j] = arr[i][j];
                if(i==0){
                    arr[i][j] = arr[3][j];
                    arr[3][j] = temparr1[j];
                }else
                    break;
            }
        }

        for (int[] row : arr) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

}

class StringAlgos{
     public static void main(String[] args) {
/*
         * - How do you reverse a string in Java?
         * - How do you check if two strings are anagrams?
         * - How do you remove duplicate characters from a string?
         * - How do you count the number of vowels and consonants in a string?
         * - How do you check if a string is a palindrome?

*/
        System.out.println(reverses("reverse"));
        System.out.println(areAnagram("tweset","weetet"));
        System.out.println(removeDuplicateCharacterFromString("parallel"));
        System.out.println(countVowelsAndConsonents("consonants"));
        System.out.println(palindrom("papap"));
    }

    private static boolean palindrom(String str) {
         for(int i=0;i<str.length()/2;i++){
             if(str.charAt(i)!=str.charAt(str.length()-1-i)){
                 return false;
             }
         }
             return true;
    }

    private static String countVowelsAndConsonents(String word) {
         Map<String, Integer> map = new HashMap<>();
        for(char c: word.toCharArray()){
            if((c+"").matches("[aeiouAEIOU]")){
                map.put("Vowels",map.getOrDefault("Vowels",0)+1);
            }else  map.put("Cons",map.getOrDefault("Cons",0)+1);
        }
        return map.entrySet().toString();

    }

    private static String removeDuplicateCharacterFromString(String str) {
        String strn="";
         for (int i = 0; i < str.length()-1; i++) {
            if(str.replaceAll(str.charAt(i)+"","").length() == str.length()-1){
                strn = strn+str.charAt(i);
            }
        }
         return strn;
    }

    private static boolean areAnagram(String str1, String str2) {
        if( str1.length() != str2.length()) return false;

        for(int i=0;i<str1.length();i++){
            if(str1.replaceAll(str1.charAt(i)+"","").length()
                    != str2.replaceAll(str1.charAt(i)+"","").length())
                return false;
        }
        return true;
    }

    private static String reverses(String str){
        String newStr ="";
        for (int i = str.length()-1; i >=0; i--) {
            newStr = newStr+str.charAt(i);
        }
        return newStr;
    }
}

class Algo2{
/*
     * 6.	How do you find the first non-repeating character in a string?
     * 7. 	How do you capitalize the first letter of each word in a sentence?
     * 8. 	How do you convert a string to a character array and vice versa?. str.toCharAray() and new String(char[])
     * 9. 	How do you count the number of words in a string?
     * 10. 	How do you remove all whitespaces from a string? trim() and strip()

*/
    public static void main(String[] args) {
        System.out.println(firstNonRepeatingCharacter("Banana"));
        System.out.println(capitalizeFirstLetterOfEachWord("capitalize the first letter of each word in a sentence"));
        System.out.println(checkIfStringContainOnlyDigit("1234123"));
        System.out.println(longestSubStringWithoutRepeatingCharacter("algebra"));
        System.out.println(longestSubStringWithoutRepeatingCharacter("capitalzer"));
        System.out.println(countNumberOfWordsInString("aditya"));
    }

    private static String countNumberOfWordsInString(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
       return map.entrySet().toString();
    }

    private static int longestSubStringWithoutRepeatingCharacter(String str) {
        int left=0, right=0;
        int maxsize=0;
        Set st = new HashSet();
        String maxSub ="";
        for (right = 0; right < str.length() && left<=right; right++ ) {
            if(st.contains(str.charAt(right))){
                left = str.indexOf(str.charAt(right));
            }
            if(right-left>maxsize){
                maxsize= right-left;
                maxSub = str.substring(left+1,right+1);
            }
            st.add(str.charAt(right));
        }
        System.out.println(maxSub);
        return maxsize;

    }

    private static boolean checkIfStringContainOnlyDigit(String str) {
        return str.matches("[0-9]+");
    }

    private static String capitalizeFirstLetterOfEachWord(String s) {
        StringBuilder builder = new StringBuilder();
        String[] arr = s.split(" ");
        for(String word: arr){
            builder.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1))
                    .append(" ");
        }
        return builder.toString().trim();
    }

    private static char firstNonRepeatingCharacter(String str) {
        for(char c: str.toCharArray()){
            if(str.replaceAll(c+"","").length() == str.length()-1){
                return c;
            }
        }
        return ' ';
    }
}

class Algo3{
    public static void main(String[] args) {
        System.out.println(compressString("aaabbccdee"));
        System.out.println(checkOneStringIsRotationOfOther("waterbottle","terbottlewa"));
        System.out.println(mostFrequentCharacterInString("aabbbbbcccc"));
        System.out.println(reverseLettersKeepDigits("abcd1efgh3hijk45lnmo"));

    }

    private static String reverseLettersKeepDigits(String str) {
        List<Character> list = new ArrayList<>();

        int i =0;
        for(char c : str.toCharArray()){
            if(!Character.isDigit(c)){
                list.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();

        for(char c : str.toCharArray()){
            if(Character.isDigit(c)){
                sb.append(c);
            }else{
                sb.append(list.get(list.size()-1-i));
                i++;
            }
        }
        return sb.toString();
    }

    private static char mostFrequentCharacterInString(String str) {
        int count = 1;
        int maxCount = 0;
        char mostfreq = ' ';
        Set chars = new HashSet();
        for (int i = 0; i < str.length(); i++) {
            if (!chars.contains(str.charAt(i))) {
                chars.add(str.charAt(i));
            } else {
                count++;
            }
            if (count > maxCount) {
                maxCount = count;
                mostfreq = str.charAt(i);
            }
        }


        //alternate approch using Map
       /* Map<Character, Integer> map = new HashMap<>();
        for (char uniC : str.toCharArray()) {
            map.put(uniC, map.getOrDefault(uniC, 0) + 1);
        }


        Collections.max(map.entrySet(), new ComparableComparator());*/
        return mostfreq;
    }

    private static boolean checkOneStringIsRotationOfOther(String s1, String s2) {
        return s1.length()==s2.length() && (s1+s1).contains(s2);
    }

    private static String compressString(String str) {
        StringBuilder builder = new StringBuilder();
        int count = 1;
        for (int i = 0; i < str.length()-1; i++) {
            if(str.charAt(i+1)==str.charAt(i)){
                count++;
            }else{
                builder.append(str.charAt(i)).append(count);
                count=1;
            }
        }
        builder.append(str.charAt(str.length()-1)).append(count);
        return builder.toString();
    }

    private static List<String> allPermutationOfString(String str){
        return null;
    }

}

class Second{
    public static void main(String[] args) {
        String str ="Automation";
        int counter =0;
        Character second =null ,first =null;
        List<Character> list = new ArrayList<>();
        for(char c: str.toCharArray()){
            if(list.contains(c)){
                second = first;
                first = c;
                counter++;
            }
            if(counter==2)break;

            list.add(c);
        }
        System.out.println(second);
    }
}


