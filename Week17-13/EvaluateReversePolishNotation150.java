public class Solution {
    /**
    * Using stack to keep track of number
    * Time O(n), Space O(n)
    */
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        
        for(String s : tokens) {
            switch(s) {
                case "+":
                    int sum = stack.pop() + stack.pop();
                    stack.push(sum);
                    break;
                case "-":
                    int temp = stack.pop();
                    int minus = stack.pop() - temp;
                    stack.push(minus);
                    break;
                case "*":
                    int mul = stack.pop() * stack.pop();
                    stack.push(mul);
                    break;
                case "/":
                    int divisor = stack.pop();
                    int shang = stack.pop() / divisor;
                    stack.push(shang);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}