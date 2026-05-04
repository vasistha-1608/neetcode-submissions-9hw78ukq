
class MinStack {
    
    private Deque<Integer> mainStack;
    private Deque<Integer> minStack;

    public MinStack() {
        mainStack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        mainStack.push(val);
        
        // If the minStack is empty, OR the new value is a new minimum 
        // (or a tie for the minimum), push it onto the minStack!
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        // Unbox to a primitive 'int' to safely compare values.
        // (Comparing two Integer objects with == in Java can cause bugs for numbers > 127!)
        int poppedValue = mainStack.pop();
        
        // If the value we just removed was our current minimum, 
        // we must remove it from the minStack as well.
        if (poppedValue == minStack.peek()) {
            minStack.pop();
        }
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}