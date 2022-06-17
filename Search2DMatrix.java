import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
	static boolean findTargetInMatrix(ArrayList<ArrayList<Integer>> mat, int m, int n, int target) {
		int row = 0, col = n - 1;
        while(row < m && col >= 0) {
            if(mat.get(row).get(col) == target) return true;
            else if(mat.get(row).get(col) < target) {
                row++;
            } else {
                col--;
            }
        }
        
        return false;
	}
}
