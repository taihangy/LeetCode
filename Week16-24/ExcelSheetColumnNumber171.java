public class Solution {
    public int titleToNumber(String s) {
        if(s == null || s.length() == 0) return -1;
        int num = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int digit = c - 'A' + 1;
            num = num * 26 + digit;
        }
        return num;
    }
}