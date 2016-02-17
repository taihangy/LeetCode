public class Solution {
    public String shortestPalindrome(String s) {
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(j)) j++;
        }
        if (j == s.length()) return s;
        return new StringBuilder(s.substring(j)).reverse().toString() + shortestPalindrome(s.substring(0, j)) + s.substring(j);
    }
}