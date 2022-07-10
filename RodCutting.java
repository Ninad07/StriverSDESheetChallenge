public class Solution {
	public static int cutRod(int price[], int n) {
		return rodCutting(price, n, new Integer[n + 1]);
	}
    
    private static int rodCutting(int[] price, int n, Integer[] dp) {
        if(n == 0) return 0;
        if(dp[n] != null) return dp[n];
        int maxCost = 0;
        for(int i = 1; i <= n; i++) {
            maxCost = Math.max(maxCost, price[i - 1] + rodCutting(price, n - i, dp));
        }
        return dp[n] = maxCost;
    }
}
