public class Solution {
	public static int uniquePaths(int m, int n) {
		return paths(0, 0, m, n, new Integer[m][n]);
	}
    
    private static int paths(int row, int col, int m, int n, Integer[][] dp) {
        if(row < 0 || col < 0 || row >= m || col >= n) return 0;
        if(row == m - 1 && col == n - 1) {
            return 1;
        }
        
        if(dp[row][col] != null) return dp[row][col];
        return dp[row][col] = paths(row + 1, col, m, n, dp) + paths(row, col + 1, m, n, dp);
    }
}
