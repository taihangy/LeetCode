public class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        s = s.trim();
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int number = 0;
        int sign = 1;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                number = 10 * number + (int)(c - '0');
            }
            else if(c == '+' || c == '-') {
                res += sign * number;
                number = 0;
                sign = c == '+'?1 : -1;
            }
            else if(c == '(') {
                stack.push(res);
                stack.push(sign);
                sign = 1;
                res = 0;
            }
            else if(c == ')') {
                res += sign * number;
                number = 0;
                res *= stack.pop();
                res += stack.pop();
            }
            else if(c == ' ') continue;
        }
        if(number != 0) res += sign * number;
        return res;
    }
}