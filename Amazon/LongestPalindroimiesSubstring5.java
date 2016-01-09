public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return null;
        int maxLeft = 0, maxRight = 0;
        int max = 1;
        for (int i = 0; i < 2 * s.length() - 1; i++) {
            if (i % 2 == 0) {
                int left = i / 2 - 1;
                int right = i / 2 + 1;
                int[] maxLen = findLongestPalindrome(left, right, max, s);
                if (maxLen[0] - maxLen[1] != 0) {
                    maxLeft = maxLen[0];
                    maxRight = maxLen[1];
                    max = maxRight - maxLeft + 1;
                }
            }
            else {
                int left = (i - 1) / 2;
                int right = (i + 1) / 2;
                int[] maxLen = findLongestPalindrome(left, right, max, s);
                if (maxLen[0] - maxLen[1] != 0) {
                    maxLeft = maxLen[0];
                    maxRight = maxLen[1];
                    max = maxRight - maxLeft + 1;
                }
            }
        }
        return s.substring(maxLeft, maxRight + 1);
    }
    
    private int[] findLongestPalindrome(int left, int right, int max, String s) {
        int[] res = new int[2];
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (left < 0 || right >= s.length() || s.charAt(left) != s.charAt(right)) {
                if (right - left - 1 > max) {
                    res[0] = left + 1;
                    res[1] = right - 1;
                }
                break;
            }
        }
        return res;
    }
}