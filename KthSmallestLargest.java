import java.util.*;


public class Solution {
	public static ArrayList<Integer> kthSmallLarge(ArrayList<Integer> arr, int n, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int num : arr) {
            if(minHeap.size() < k) {
                minHeap.add(num);
            } else if(minHeap.peek() < num) {
                minHeap.poll();
                minHeap.add(num);
            }
            
            if(maxHeap.size() < k) {
                maxHeap.add(num);
            } else if(maxHeap.peek() > num) {
                maxHeap.poll();
                maxHeap.add(num);
            }
        }
        
        return new ArrayList<>(Arrays.asList(maxHeap.peek(), minHeap.peek()));
	}
}
