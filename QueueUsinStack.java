import java.util.*;
public class Queue {
    Stack<Integer> stack, helperStack;

    Queue() {
        stack = new Stack<>();
        helperStack = new Stack<>();
    }

    void enQueue(int val) {
        while(!stack.isEmpty()) helperStack.push(stack.pop());
        stack.push(val);
        while(!helperStack.isEmpty()) stack.push(helperStack.pop());
    }

    int deQueue() {
        return stack.isEmpty() ? -1 : stack.pop();
    }

    int peek() {
        return stack.isEmpty() ? -1 : stack.peek();
    }

    boolean isEmpty() {
        return stack.isEmpty();
    }
}
