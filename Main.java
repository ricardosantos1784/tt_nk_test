package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
/*
Smallest window in a String containing all characters of other String
Given two strings, string and pattern, the task is to find the smallest substring in string containing all characters of pattern.

Examples:

Input: string = “this is a test string”, pattern = “tist”
Output: “t stri”
Explanation: “t stri” contains all the characters of pattern.
Input: string = “geeksforgeeks”, pattern = “ork”
Output: “ksfor”
*/


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String response = smallestWindow("anything a b c", "abc");

        System.out.printf(response);


    }

    public static String smallestWindow(String input, String pattern) {
        //separeted the tokens of pattern
        List tokens = new ArrayList();
        tokens.add("a");
        tokens.add("b");
        tokens.add("c");
        //array of tokens
        int windowSize = pattern.length();
        String response = "";


        for (int x = windowSize; x < input.length(); x++) {

            for (int i = 0; i < input.length(); i++) {

                for (int j = 0; i < tokens.size(); j++) {
                    int patternFound = 0;
                    int endIndex = i + windowSize;
                    //validation of endIndex
                    if (endIndex + 1 > input.length()) {
                        endIndex = input.length() - 1;
                    }
                    if (input.substring(i, endIndex).contains(tokens.get(j) + "")) {
                        patternFound++;
                    }
                    if (patternFound == tokens.size()) {
                        return input.substring(i, endIndex);
                    }
                }
            }
        }

        return response;
    }
}