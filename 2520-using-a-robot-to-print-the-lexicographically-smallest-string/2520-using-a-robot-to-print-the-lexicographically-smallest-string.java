import java.util.*;

class Solution {
    public String robotWithString(String s) {
        Stack<Character> stack = new Stack<>();
        int[] freq = new int[26];
        
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        
        StringBuilder t = new StringBuilder();

        for (char ch : s.toCharArray()) {
            stack.push(ch);
            freq[ch - 'a']--;

            while (!stack.isEmpty() && stack.peek() <= smallestChar(freq)) {
                t.append(stack.pop());
            }
        }

        while (!stack.isEmpty()) {
            t.append(stack.pop());
        }

        return t.toString();
    }

    private char smallestChar(int[] freq) {
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                return (char) ('a' + i);
            }
        }
        return 'a';
    }
}