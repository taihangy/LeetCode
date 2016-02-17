public class Solution {
    public String removeDuplicateLetters(String s) {
        StringBuilder res = new StringBuilder();
        if (s == null || s.length() == 0) return "";
        Stack<Character> stack = new Stack<Character>();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        boolean[] marked = new boolean[26];
        for (int i = 0; i < s.length(); count[s.charAt(i) - 'a']--, i++) {
            char c = s.charAt(i);
            if (marked[c - 'a'] || (!stack.isEmpty() && stack.peek() == c)) continue;
            while (!stack.isEmpty() && count[stack.peek() - 'a'] > 0 && stack.peek() > c) {
                char t = stack.pop();
                marked[t - 'a'] = false;
            }
            stack.push(c);
            marked[c - 'a'] = true;
        }
        for (char c : stack) {
            res.append(c);
        }
        return res.toString();
    }
}