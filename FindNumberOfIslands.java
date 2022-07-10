public class Solution 
{
    public static int getTotalIslands(int[][] arr) 
	{
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 1) {
                    count++;
                    dfs(arr, i, j);
                }
            }
        }
        
        return count;
    }
    
    private static void dfs(int[][] arr, int row, int col) {
        if(row < 0 || col < 0 || row >= arr.length || col >= arr.length || arr[row][col] == 0) return;
        arr[row][col] = 0;
        dfs(arr, row - 1, col - 1);
        dfs(arr, row - 1, col);
        dfs(arr, row - 1, col + 1);
        dfs(arr, row, col + 1);
        dfs(arr, row + 1, col + 1);
        dfs(arr, row + 1, col);
        dfs(arr, row + 1, col - 1);
        dfs(arr, row, col - 1);
    }
}
