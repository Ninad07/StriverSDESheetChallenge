import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {

	public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {

		int max = 0;
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        int sum = 0;
        hashmap.put(0, -1);
        
        for(int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
            if(hashmap.containsKey(sum)) {
                max = Math.max(max, i - hashmap.get(sum));
            } else hashmap.put(sum, i);
        }
        
        return max;
	}
}
