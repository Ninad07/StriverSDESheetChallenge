
import java.util.*;

public class Solution {

	public static void findMedian(int arr[])  {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    
        for(int i = 0; i < arr.length; i++) {
            if(maxHeap.isEmpty()) {
                maxHeap.add(arr[i]);
            } else if(minHeap.isEmpty()) {
                if(maxHeap.peek() > arr[i]) {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(arr[i]);
                } else {
                    minHeap.add(arr[i]);
                }
            } else {
                if(arr[i] > maxHeap.peek()) {
                    minHeap.add(arr[i]);
                } else {
                    maxHeap.add(arr[i]);
                }
            }
            
            if(maxHeap.size() - minHeap.size() >= 2) {
                minHeap.add(maxHeap.poll());
            } else if(minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            } 
            
            if(maxHeap.size() > minHeap.size()) {
                System.out.print(maxHeap.peek() + " ");
            } else {
                System.out.print(((minHeap.peek() + maxHeap.peek()) / 2) + " ");
            }
        }
        
        System.out.println();
        
    }
   


}
