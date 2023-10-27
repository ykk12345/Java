import java.util.LinkedList;
import java.util.Queue;

class StackUsingQueues {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();
    private int top;

    /** Initialize your data structure here. */
    public StackUsingQueues() {
        // Constructor: Initialize the two queues and top element.
    }

    /** Push element x onto the stack. */
    public void push(int x) {
        // Add the new element to an empty queue (queue1).
        queue1.add(x);
        // Update the top element.
        top = x;
        // Transfer elements from queue2 to queue1.
        while (!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }
        // Swap the names of queue1 and queue2 to maintain consistency.
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    /** Removes the element on the top of the stack and returns that element. */
    public int pop() {
        // Pop operation is equivalent to removing the top element from queue2.
        int popped = queue2.poll();
        // If queue2 is empty, update the top element to the new top.
        if (!queue2.isEmpty()) {
            top = queue2.peek();
        }
        return popped;
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue2.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();

        stack.push(1);
        stack.push(2);
        System.out.println("Top element: " + stack.top()); // Output: 2
        System.out.println("Is the stack empty? " + stack.empty()); // Output: false

        stack.pop();
        System.out.println("Top element after pop: " + stack.top()); // Output: 1
        System.out.println("Is the stack empty? " + stack.empty()); // Output: false
    }
}
