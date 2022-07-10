public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        return subsetSum(arr, 0, k, new Boolean[arr.length][k + 1]);
    }
    
    private static boolean subsetSum(int[] arr, int index, int k, Boolean[][] dp) {
        if(k == 0) return true;
        if(index >= arr.length || k < 0) return false;
        if(dp[index][k] != null) return dp[index][k];
        
        return dp[index][k] = subsetSum(arr, index + 1, k - arr[index], dp) || subsetSum(arr, index + 1, k, dp);
    }
}
