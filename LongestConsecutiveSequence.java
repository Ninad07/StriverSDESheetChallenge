import java.util.* ;
import java.io.*; 
public class Solution {
    public static int lengthOfLongestConsecutiveSequence(int[] arr, int N) {
        HashSet<Integer> hashset = new HashSet<>();
        for(int num : arr) hashset.add(num);
        int max = 1;
        
        for(int i = 0; i < N; i++) {
            if(hashset.contains(arr[i] + 1)) continue;
            int count = 0, val = arr[i];
            while(hashset.contains(val)) {
                val--;
                count++;
            }
            
            max = Math.max(max, count);
        }
        
        return max;
    }
}
