import java.util.*;
public class Solution {

    public static int chessTournament(int[] positions, int n,  int c) 
	{
        Arrays.sort(positions);
        int beg = 0, end = positions[n - 1] - positions[0];
        int ans = 0;
        while(beg <= end) {
            int mid = (beg + end) / 2;
            if(canBePlaced(positions, mid, c)) {
                ans = mid;
                beg = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return ans;
    }
    
    private static boolean canBePlaced(int[] arr, int dist, int c) {
        int totalPlaced = 1;
        int lastIndex = 0;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] - arr[lastIndex] >= dist) {
                totalPlaced++;
                lastIndex = i;
            }
        }
        
        return totalPlaced >= c;
    }
}



