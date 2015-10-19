/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        if(n <= 0) return -1;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++) stack.push(i);
        int a = 0, b = 0;
        while(stack.size() > 1) {
            a = stack.pop();
            b = stack.pop();
            if(knows(a, b)) stack.push(b);
            else stack.push(a);
        }
        int celebrity = stack.pop();
        for(int i = 0; i < n; i++) {
            if(i != celebrity && (knows(celebrity, i) || !knows(i, celebrity))) return -1;
        }
        return celebrity;
    }
}