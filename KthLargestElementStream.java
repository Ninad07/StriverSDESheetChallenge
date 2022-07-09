import java.util.*;
public class Kthlargest {
    PriorityQueue<Integer> pq;
    int k;
    Kthlargest(int k, int[] arr) {
        pq = new PriorityQueue<>();
        this.k = k;
        for(int num : arr) {
            if(pq.size() < k) pq.add(num);
            else if(pq.peek() < num) {
                pq.poll();
                pq.add(num);
            }
        }
    }

    void add(int num) {
        if(pq.size() < k) pq.add(num);
            else if(pq.peek() < num) {
                pq.poll();
                pq.add(num);
            }
    }

    int getKthLargest() {
        return pq.peek();
    }
}
