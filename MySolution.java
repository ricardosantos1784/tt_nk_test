/*
ATTENTION - Attention: do not consider the code below as part of the test; it was just for study purposes.
this is my fixed solution. 

Smallest window in a String containing all characters of other String
Given two strings, string and pattern, the task is to find the smallest substring in string containing all characters of pattern.

Examples:

Input: string = “this is a test string”, pattern = “tist”
Output: “t stri”
Explanation: “t stri” contains all the characters of pattern.
Input: string = “geeksforgeeks”, pattern = “ork”
Output: “ksfor”
*/


import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String response = smallestWindow("geeksforgeeks", "ork");
        System.out.println("result: " + response);
    }

    public static String smallestWindow(String input, String pattern) {
        int inputLen = input.length();
        int minWindowLen = Integer.MAX_VALUE;
        String result = "";

        // frequency of chars
        Map<Character, Integer> patternFreq = new HashMap<>();
        for (char c : pattern.toCharArray()) {
            patternFreq.put(c, patternFreq.getOrDefault(c, 0) + 1);
        }

        // test all possible windows
        for (int start = 0; start < inputLen; start++) {
            for (int end = start + 1; end <= inputLen; end++) {
                String window = input.substring(start, end);

                if (containsAllChars(window, patternFreq)) {
                    if (window.length() < minWindowLen) {
                        minWindowLen = window.length();
                        result = window;
                    }
                }
            }
        }

        return result;
    }

    private static boolean containsAllChars(String window, Map<Character, Integer> patternFreq) {
        Map<Character, Integer> windowFreq = new HashMap<>();
        for (char c : window.toCharArray()) {
            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : patternFreq.entrySet()) {
            char key = entry.getKey();
            int requiredCount = entry.getValue();
            if (windowFreq.getOrDefault(key, 0) < requiredCount) {
                return false;
            }
        }

        return true;
    }
}
