
public class Solution {

    public static int cutLogs(int k, int n) {
        return cutLogs(n, k, new Integer[n + 1][k + 1]);
    }
    
    private static int cutLogs(int n, int k, Integer[][] dp) {
        if(k == 1 || n <= 1) return n;
        if(dp[n][k] != null) return dp[n][k];
        
        int beg = 1, end = n;
        int ans = n;
        
        while(beg <= end) {
            int mid = beg + (end - beg) / 2;
            int aboveCapacity = cutLogs(mid - 1, k - 1, dp);
            int withinCapacity = cutLogs(n - mid, k, dp);
            ans = Math.min(ans, Math.max(aboveCapacity, withinCapacity) + 1);
            if(aboveCapacity == withinCapacity) break;
            else if(aboveCapacity < withinCapacity) beg = mid + 1;
            else end = mid - 1;
        }
        
        return dp[n][k] = ans;
    }

}
