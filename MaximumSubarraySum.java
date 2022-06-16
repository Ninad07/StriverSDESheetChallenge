import java.util.* ;
import java.io.*; 

public class Solution {
	
	public static long maxSubarraySum(int[] arr, int n) {
        // Kadane's Algorithm
        // O(n)
		    long sum = 0;
        long maxSum = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i];
            maxSum = Math.max(maxSum, sum);
            if(sum < 0) {
                sum = 0;
            }
        }
        
        return maxSum;
	}

}
