import java.util.*;
public class Solution {
    public static ArrayList<ArrayList<Integer>> solveNQueens(int n) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        int[][] arr = new int[n][n];
        boolean[] cols = new boolean[n];
        boolean[] diagonals = new boolean[2 * n - 1];
        boolean[] reverseDiagonals = new boolean[2 * n - 1];
        nQueens(arr, 0, al, cols, diagonals, reverseDiagonals);
        return al;
    }
    
    private static void nQueens(int[][] arr, int row, ArrayList<ArrayList<Integer>> al, boolean[] cols, boolean[] diagonals, boolean[] reverseDiagonals) {
        if(row >= arr.length) {
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < arr.length; i++) {
                for(int j = 0; j < arr.length; j++) {
                    list.add(arr[i][j]);
                }
            }
            
            al.add(list);
            return;
        }
        
        for(int col = 0; col < arr.length; col++) {
            if(!cols[col] && !diagonals[row + col] && !reverseDiagonals[row - col + arr.length - 1]) {
                cols[col] = true;
                diagonals[row + col] = true;
                reverseDiagonals[row - col + arr.length - 1] = true;
                arr[row][col] = 1;
                nQueens(arr, row + 1, al, cols, diagonals, reverseDiagonals);
                cols[col] = false;
                diagonals[row + col] = false;
                reverseDiagonals[row - col + arr.length - 1] = false;
                arr[row][col] = 0;
            }
        }
    }
}
