package tests;

import java.util.HashMap;
import java.util.Map;

public class CharFrequency {
    public static void main(String[] args) {
        String input = "hello world";
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char c : input.toCharArray()) {
            if (c != ' ') {
                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
