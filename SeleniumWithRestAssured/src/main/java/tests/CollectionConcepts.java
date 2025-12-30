package tests;

import java.util.*;

public class CollectionConcepts {
    public static void main(String[] args) {


    }
}

class CommonInBothStrings{
    public static void main(String[] args) {
        String s1 = "Programming";
        String s2 = "gaming";
        Set<Character> finalList = new HashSet<>();
        for (int i = 0; i < s2.length(); i++) {
            if(s1.contains(s1.charAt(i)+"")){
                finalList.add(s2.charAt(i));
            }
        }
        System.out.println(finalList);
    }
}
