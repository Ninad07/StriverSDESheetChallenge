import java.util.*;
public class Solution {

	public static int[] KMostFrequent(int n, int k, int[] arr) {
		HashMap<Integer, Integer> hashmap = new HashMap<>();
        for(int num : arr) {
            hashmap.put(num, hashmap.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return hashmap.get(a) - hashmap.get(b);
        });
        
        for(int num: hashmap.keySet()) {
            if(pq.size() < k) {
                pq.add(num);
            } else if(hashmap.get(num) > hashmap.get(pq.peek())) {
                pq.poll();
                pq.add(num);
            }
        }
        
        int[] ans = new int[k];
        for(int i = k - 1; i >= 0; i--) {
            ans[i] = pq.poll();
        }
        
        return ans;
	}

}
