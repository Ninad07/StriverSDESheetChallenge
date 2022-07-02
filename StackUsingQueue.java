import java.util.*;
public class Stack {

    ArrayDeque<Integer> queue;
    ArrayDeque<Integer> helperQueue;


    public Stack() {
        queue = new ArrayDeque<>();
        helperQueue = new ArrayDeque<>();
    }



    /*----------------- Public Functions of Stack -----------------*/


    public int getSize() { 
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void push(int element) {
        while(!queue.isEmpty()) helperQueue.add(queue.poll());
        queue.add(element);
        while(!helperQueue.isEmpty()) queue.add(helperQueue.poll());
    }

    public int pop() {
        return queue.isEmpty() ? -1 : queue.poll();
    }

    public int top() {
        return queue.isEmpty() ? -1 : queue.peek();
    }
}
