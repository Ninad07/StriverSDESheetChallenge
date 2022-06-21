import java.util.* ;
import java.io.*; 
public class Solution {
    public static long getTrappedWater(long[] arr, int n) {
        long trappedWater = 0L;
        long[] leftGreater = new long[n];
        long[] rightGreater = new long[n];
        
        for(int i = 0; i < n; i++) {
            leftGreater[i] = (i == 0 ? arr[i] : Math.max(arr[i], leftGreater[i - 1]));
            rightGreater[n - 1 - i] = (i == 0 ? arr[n - 1 - i] : Math.max(arr[n - 1 - i], rightGreater[n - i]));
        }
        
        for(int i = 0; i < n; i++) {
            trappedWater += Math.min(leftGreater[i], rightGreater[i]) - arr[i];
        }
        
        return trappedWater;
        
    }
}
