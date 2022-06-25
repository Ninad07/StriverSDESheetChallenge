public class Solution {

	public static boolean isItSudoku(int arr[][]) {
        return solve(arr, 0);
	}
    
    private static boolean solve(int[][] arr, int cell) {
        if(cell > 80) return true;
        int row = cell / 9;
        int col = cell % 9;
        
        if(arr[row][col] != 0) {
            return solve(arr, cell + 1);
        } else {
            for(int i = 1; i <= 9; i++) {
                if(isValid(arr, row, col, i)) {
                    arr[row][col] = i;
                    if(solve(arr, cell + 1)) return true;
                    arr[row][col] = 0;
                }
            }
        }
        
        return false;
    }
    
    private static boolean isValid(int[][] arr, int row, int col, int val) {
        for(int j = 0; j < arr.length; j++) {
            if(arr[row][j] == val) return false;
        }
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i][col] == val) return false;
        }
        
        int subRow = (row / 3) * 3;
        int subCol = (col / 3) * 3;
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(arr[i + subRow][j + subCol] == val) return false;
            }
        }
        
        return true;
    }
}
