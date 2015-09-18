class MinStack {
    private LinkedList<Integer> stack = new LinkedList<Integer>();
    private LinkedList<Integer> min = new LinkedList<Integer>();
    public void push(int x) {
        stack.push(x);
        if(min.isEmpty() || min.peek() >= x) 
            min.push(x);
    } 

    public void pop() {
        if(stack.isEmpty()) return;
        int peek = stack.pop();
        if(!min.isEmpty() && peek <= min.peek())
            min.pop();
    }

    public int top() {
        if(stack.isEmpty()) return 0;
        int peek = stack.peek();
        return peek;
    }

    public int getMin() {
        if(!min.isEmpty()) return min.peek();
        return 0;
    }
}