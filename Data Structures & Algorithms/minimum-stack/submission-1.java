class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int val) {
        if(minStack.isEmpty())
            minStack.push(val);
        else
            if(val <= minStack.peek())
                minStack.push(val);
        stack.push(val);
    }
    
    public void pop() {
        if(!minStack.isEmpty() && !stack.isEmpty()) { 
            int poppedValue = stack.pop();
            if(poppedValue == minStack.peek())
                minStack.pop();
        }
    }
    
    public int top() {
        if(!stack.isEmpty())
            return stack.peek();
        return 0;
    }
    
    public int getMin() {
        return minStack.isEmpty() ? 0 : minStack.peek();
    }
}
