import java.util.* ;
import java.io.*; 
public class Solution {
    public static void setZeros(int matrix[][]) {
        boolean[] columns = new boolean[matrix[0].length];
        boolean[] rows = new boolean[matrix.length];
        
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }
        
        for(int col = 0; col < columns.length; col++) {
            if(columns[col]) {
                for(int row = 0; row < rows.length; row++) {
                    matrix[row][col] = 0;
                }
            }
        }
        
        for(int row = 0; row < rows.length; row++) {
            if(rows[row]) {
                for(int col = 0; col < columns.length; col++) {
                    matrix[row][col] = 0;
                }
            }
        }
    }

}
