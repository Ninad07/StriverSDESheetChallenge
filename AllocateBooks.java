public class Solution {
    public static long ayushGivesNinjatest(int n, int m, int[] time) {
        long min = Long.MAX_VALUE, sum = 0L;
        for(int t : time) {
            min = Math.min(min, (long)t);
            sum += (long)t;
        }
        
        long beg = min, end = sum;
        long ans = 0L;
        while(beg <= end) {
            long mid = beg + (end - beg) / 2;
            if(isAllocationPossible(time, mid, n)) {
                ans = mid;
                end = mid - 1;
            } else {
                beg = mid + 1;
            }
        }
        
        return ans;
    }
    
    private static boolean isAllocationPossible(int[] arr, long mid, int n) {
        int totalDays = 1;
        long time = 0L;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > mid) return false;
            time += arr[i];
            if(time > mid) {
                time = arr[i];
                totalDays++;
            }
            
            if(totalDays > n) return false;
        }
        
        return true;
    }
}



