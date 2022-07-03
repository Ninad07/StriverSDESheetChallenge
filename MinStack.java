import java.util.*;
public class Solution {

    static class MinStack {
        Stack<Integer> stack, minStack;
        // Constructor
        MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        // Function to add another element equal to num at the top of stack.
        void push(int num) {
            minStack.push(Math.min(num, minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek()));
            stack.push(num);
        }

        // Function to remove the top element of the stack.
        int pop() {
            if(stack.isEmpty()) return -1;
            minStack.pop();
            return stack.pop();
        }

        // Function to return the top element of stack if it is present. Otherwise
        // return -1.
        int top() {
            if(stack.isEmpty()) return -1;
            return stack.peek();
        }

        // Function to return minimum element of stack if it is present. Otherwise
        // return -1.
        int getMin() {
            if(stack.isEmpty()) return -1;
            return minStack.peek();
        }
    }
}
