public class Solution {
    public static int minSumPath(int[][] grid) {
    	return minPathSum(grid, 0, 0, new Integer[grid.length][grid[0].length]);
    }
    
    private static int minPathSum(int[][] arr, int row, int col, Integer[][] dp) {
        if(row < 0 || col < 0 || row >= arr.length || col >= arr[0].length) return 10000000;
        if(row == arr.length - 1 && col == arr[0].length - 1) return arr[row][col];
        if(dp[row][col] != null) return dp[row][col];
        return dp[row][col] = arr[row][col] + Math.min(minPathSum(arr, row, col + 1, dp), minPathSum(arr, row + 1, col, dp));
    }
}
