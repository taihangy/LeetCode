public class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) return true;
        LinkedList<Character> stack = new LinkedList<Character>();
        for(char c : s.toCharArray()) {
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if(!stack.isEmpty()) {
                char d = stack.pop();
                if(c == ')' && d != '(') return false;
                if(c == ']' && d != '[') return false;
                if(c == '{' && d != '{') return false;
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}