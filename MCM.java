
public class Solution {
	public static int matrixMultiplication(int[] arr , int N) {
		return mcm(arr, 0, arr.length - 2, new Integer[N][N]);
	}
    
    private static int mcm(int[] arr, int beg, int end, Integer[][] dp) {
        if(beg >= end) return 0;
        if(dp[beg][end] != null) return dp[beg][end];
        int min = Integer.MAX_VALUE;
        
        for(int i = beg; i < end; i++) {
            min = Math.min(min, mcm(arr, beg, i, dp) + (arr[beg] * arr[i + 1] * arr[end + 1]) + mcm(arr, i + 1, end, dp));
        }
        
        return dp[beg][end] = min;
    }
}
