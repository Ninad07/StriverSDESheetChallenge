import java.util.*;
public class Solution {

	static int kthLargest(ArrayList<Integer> arr, int size, int K) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : arr) {
            if(pq.size() < K) pq.add(num);
            else if(pq.peek() < num) {
                pq.poll();
                pq.add(num);
            }
        }
        
        return pq.peek();
	}
}
