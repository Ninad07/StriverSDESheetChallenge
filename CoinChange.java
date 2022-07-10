
public class Solution {

	public static long countWaysToMakeChange(int arr[], int value){
        return count(arr, 0, value, new Long[arr.length][value + 1]);
	}
    
    private static long count(int[] arr, int index, int value, Long[][] dp) {
        if(value == 0) return 1;
        if(index >= arr.length || value < 0) return 0;
        if(dp[index][value] != null) return dp[index][value];
        return dp[index][value] = count(arr, index, value - arr[index], dp) + count(arr, index + 1, value, dp);
    }
	
}
