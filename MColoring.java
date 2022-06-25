import java.util.*;
public class Solution {
	public static String graphColoring(int[][] graph, int m) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
		return mColoring(graph, 0, m, color) ? "YES" : "NO";
	}
    
    private static boolean mColoring(int[][] graph, int source, int m, int[] color) {
        if(source == graph.length) return true;
        
        for(int i = 0; i < m; i++) {
            if(canBeColored(graph, source, i, color)) {
                color[source] = i;
                if(mColoring(graph, source + 1, m, color)) return true;
                color[source] = -1;
            }
        }
        
        return false;
    }
    
    private static boolean canBeColored(int[][] arr, int source, int currColor, int[] color) {
        for(int j = 0; j < arr.length; j++) {
            if(arr[source][j] == 1 && color[j] == currColor) return false;
        }
        return true;
    }
}
