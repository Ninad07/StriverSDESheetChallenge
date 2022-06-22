import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
	public static int subarraysXor(ArrayList<Integer> arr, int x) {
		HashMap<Integer, Integer> hashmap = new HashMap<>();
        hashmap.put(0, 1);
        int xor = 0, count = 0;
        
        for(int num : arr) {
            xor ^= num;
            if(hashmap.containsKey(xor ^ x)) {
                count += hashmap.get(xor ^ x);
            } 
            
            hashmap.put(xor, hashmap.getOrDefault(xor, 0) + 1);
        }
        
        return count;
	}
}
