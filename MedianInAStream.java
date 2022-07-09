import java.util.*;
public class Solution {
    public static int[] findMedian(int[] arr, int n) {
        int[] ans = new int[arr.length];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < arr.length; i++) {
            if(maxHeap.isEmpty()) {
                maxHeap.add(arr[i]);
            } else if(maxHeap.peek() > arr[i]) {
                minHeap.add(maxHeap.poll());
                maxHeap.add(arr[i]);
            } else {
                minHeap.add(arr[i]);
            }
            
            if(minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
            
            if(maxHeap.size() == minHeap.size()) {
                ans[i] = (minHeap.peek() + maxHeap.peek()) / 2;
            } else {
                ans[i] = maxHeap.peek();
            }
        }
        
        return ans;
    }
}


