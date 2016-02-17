public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                else if ((c == ')' && stack.peek() != '(') ||
                         (c == ']' && stack.peek() != '[') ||
                         (c == '}' && stack.peek() != '{')) {
                             return false;
                         }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}