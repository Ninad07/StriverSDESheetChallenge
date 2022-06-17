import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
    public static void rotateMatrix(ArrayList<ArrayList<Integer>> al, int n, int m) {
        if(n == 1 || m == 1) return;
        int minRow = 0, minCol = 0, maxRow = al.size() - 1, maxCol = al.get(0).size() - 1;
        int totalCells = al.size() * al.get(0).size();
        while(totalCells > 0) {
            int prev = al.get(minRow).get(minCol);
            int curr = prev;
            for(int col = minCol; col <= maxCol && totalCells > 0; col++) {
                curr = al.get(minRow).get(col);
                al.get(minRow).set(col, prev);
                prev = curr;
                totalCells--;
            }
            minRow++;
            
            for(int row = minRow; row <= maxRow && totalCells > 0; row++) {
                curr = al.get(row).get(maxCol);
                al.get(row).set(maxCol, prev);
                prev = curr;
                totalCells--;
            }
            maxCol--;
            
            for(int col = maxCol; col >= minCol && totalCells > 0; col--) {
                curr = al.get(maxRow).get(col);
                al.get(maxRow).set(col, prev);
                prev = curr;
                totalCells--;
            }
            maxRow--;
            
            for(int row = maxRow; row >= minRow && totalCells > 0; row--) {
                curr = al.get(row).get(minCol);
                al.get(row).set(minCol, prev);
                prev = curr;
                totalCells--;
            }
            minCol++;
            al.get(minRow - 1).set(minCol - 1, prev);
            if(minRow == maxRow || minCol == maxCol) break;
        }
    }
}
