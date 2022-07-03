import java.util.*;
public class Solution {

	public static int minTimeToRot(int[][] arr, int n, int m) {
		ArrayDeque<Cell> queue = new ArrayDeque<>();
        int freshCount = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 2) {
                    queue.add(new Cell(i, j, 0));
                } else if(arr[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        if(freshCount == 0) return 0;
        
        Cell cell = new Cell(-1, -1, 0);
        while(!queue.isEmpty()) {
            cell = queue.poll();
            int row = cell.row;
            int col = cell.col;
            
            if(isValid(arr, row, col - 1)) {
                freshCount--;
                arr[row][col - 1] = 2;
                queue.add(new Cell(row, col - 1, cell.time + 1));
            }
            
            if(isValid(arr, row - 1, col)) {
                freshCount--;
                arr[row - 1][col] = 2;
                queue.add(new Cell(row - 1, col, cell.time + 1));
            }
            
            if(isValid(arr, row, col + 1)) {
                freshCount--;
                arr[row][col + 1] = 2;
                queue.add(new Cell(row, col + 1, cell.time + 1));
            }
            
            if(isValid(arr, row + 1, col)) {
                freshCount--;
                arr[row + 1][col] = 2;
                queue.add(new Cell(row + 1, col, cell.time + 1));
            }
            
            if(freshCount == 0) return cell.time + 1;
            
        }
        
        return -1;
    }
    
    private static boolean isValid(int[][] arr, int row, int col) {
        return row >= 0 && col >= 0 && row < arr.length && col < arr[0].length && arr[row][col] == 1;
    }
    
    private static class Cell {
        int row, col, time;
        public Cell(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
}
