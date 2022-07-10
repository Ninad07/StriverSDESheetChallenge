import java.util.*;

public class Solution {
	public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
		return maxProfit(values, weights, 0, w, new Integer[values.size()][w + 1]);
	}
    
    private static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int index, int capacity, Integer[][] dp) {
        if(capacity == 0 || index >= values.size()) return 0;
        if(capacity < 0) return Integer.MIN_VALUE;
        if(dp[index][capacity] != null) return dp[index][capacity];
        
        if(capacity < weights.get(index)) {
            return dp[index][capacity] = maxProfit(values, weights, index + 1, capacity, dp);
        }
        
        return dp[index][capacity] = Math.max(values.get(index) + maxProfit(values, weights, index + 1, capacity - weights.get(index), dp), maxProfit(values, weights, index + 1, capacity, dp));
    }
}
