
public class Stack {
    int[] stack;
    int top, capacity;
    
    public Stack(int capacity) {
        stack = new int[capacity];
        top = -1;
        this.capacity = capacity;
    }
    
    void push(int num) {
        if(isFull() == 0) {
            stack[++top] = num;
            capacity--;
        }
    }
    int pop() {
        if(isEmpty() == 0) {
            capacity++;
            return stack[top--];
        } else return -1;
    }
    int top() {
        if(isEmpty() == 0) {
            return stack[top];
        } 
        return -1;
    }
    int isEmpty() {
        return top == -1 ? 1 : 0;
    }
    int isFull() {
        return capacity == 0 ? 1 : 0;
    }
}
