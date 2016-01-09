public class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        String s = str.trim();
        int sign = 1, base = 0, i = 0;
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            if (s.charAt(i++) == '-') sign = -1;
        }
        while (i < s.length()) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && s.charAt(i) > '7')) {
                    if(sign == -1) return Integer.MIN_VALUE;
                    else return Integer.MAX_VALUE;
                }
                base = 10 * base + s.charAt(i) - '0';
                i++;
            }
            else {
                break;
            }
        }
        return sign * base;
    }
}