public class Solution {
    public boolean isNumber(String s) {
        if (s == null) return false;
        s = s.trim();
        if (s.length() == 0) return false;
        int i = 0, end = s.length();
        if (s.charAt(i) == '+' || s.charAt(i) == '-') i++;
        boolean num = false, dot = false, exp = false;
        while (i < end) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = true;
            }
            else if (c == '.') {
                if (dot || exp) return false;
                dot = true;
            }
            else if (c == 'e') {
                if (!num || exp) return false;
                exp = true;
                num = false;
            }
            else if (c == '+' || c == '-') {
                if (s.charAt(i - 1) != 'e') return false; 
            }
            else {
                return false;
            }
            i++;
        }
        return num;
    }
}