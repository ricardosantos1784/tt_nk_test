import java.util.HashMap;

/* Attention: do not consider the code below as part of the test; it was just for study purposes. 

Solution created with AI assistence

*/


public class BestSolution {

    public static String findSmallestWindow(String str, String pattern) {
        if (str.length() < pattern.length()) {
            return "";
        }
        
        HashMap<Character, Integer> patFreq = new HashMap<>();
        for (char c : pattern.toCharArray()) {
            patFreq.put(c, patFreq.getOrDefault(c, 0) + 1);
        }

        int start = 0, minLen = Integer.MAX_VALUE, startIndex = -1;
        int count = 0; 
        HashMap<Character, Integer> windowFreq = new HashMap<>();

        for (int end = 0; end < str.length(); end++) {
            char c = str.charAt(end);
            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);
            
            if (patFreq.containsKey(c) && windowFreq.get(c) <= patFreq.get(c)) {
                count++;
            }
            
            //when all char of pattern are in window
            while (count == pattern.length()) {
                int windowSize = end - start + 1;
                if (windowSize < minLen) {
                    minLen = windowSize;
                    startIndex = start;
                }

                // try to reduce the window size by left
                char startChar = str.charAt(start);
                windowFreq.put(startChar, windowFreq.get(startChar) - 1);

                if (patFreq.containsKey(startChar) && windowFreq.get(startChar) < patFreq.get(startChar)) {
                    count--;
                }
                start++;
            }
        }

        if (startIndex == -1) {
            return "";
        }

        return str.substring(startIndex, startIndex + minLen);
    }

    public static void main(String[] args) {
        System.out.println(findSmallestWindow("this is a test string", "tist")); // t stri
        System.out.println(findSmallestWindow("geeksforgeeks", "ork"));          // ksfor
    }
}
