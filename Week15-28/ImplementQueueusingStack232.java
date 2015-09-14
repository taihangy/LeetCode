class MyQueue {
    private LinkedList<Integer> stack1 = new LinkedList<Integer>();
    private LinkedList<Integer> stack2 = new LinkedList<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        stack1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(stack1.isEmpty()) return;
        while(stack1.size() > 0) {
            int element = stack1.pop();
            stack2.push(element);
        }
        stack2.pop();
        transfer(stack1, stack2);
    }

    // Get the front element.
    public int peek() {
        if(stack1.isEmpty()) return 0;
        while(stack1.size() > 1) {
            int element = stack1.pop();
            stack2.push(element);
        }
        int res = stack1.peek();
        stack2.push(stack1.pop());
        transfer(stack1, stack2);
        return res;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack1.isEmpty();
    }
    
    private void transfer(LinkedList<Integer> stack1, LinkedList<Integer> stack2) {
        while(stack2.size() > 0) {
            stack1.push(stack2.pop());
        }
    }
}