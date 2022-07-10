import java.util.ArrayList;

public class Solution {
    public static int maxIncreasingDumbbellsSum(ArrayList<Integer> rack, int n) {
        int[] dp = new int[n];
        int omax = rack.get(0);
        dp[0] = rack.get(0);
        
        for(int i = 1; i < n; i++) {
            int max = 0;
            for(int j = 0; j < i; j++) {
                if(rack.get(j) < rack.get(i)) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = rack.get(i) + max;
            omax = Math.max(omax, dp[i]);
        }
        
        return omax;
    }
}
