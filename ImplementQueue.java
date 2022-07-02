public class Queue {
    int[] arr;
    int front, back;
    Queue() {
        arr = new int[100005];
        front = back = -1;
    }

    /*----------------- Public Functions of Queue -----------------*/

    boolean isEmpty() {
        return front == -1;
    }

    void enqueue(int data) {
        arr[++back] = data;
        if(front == -1) front = 0;
    }

    int dequeue() {
        if(!isEmpty()) {
            int val = arr[front];
            front++;
            if(front > back) {
                front = back = -1;
            }
            return val;
        } else return -1;
    }

    int front() {
        if(!isEmpty()) {
            return arr[front];
        } else return -1;
    }

}
