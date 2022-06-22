import java.util.*;
public class Solution
{
    public static int jobScheduling(int[][] jobs)
    {
        Arrays.sort(jobs, (a, b) -> {
            return b[1] - a[1];
        });
        
        int profit = 0;
        int[] jobsPerformed = new int[maxDeadline(jobs)];
        Arrays.fill(jobsPerformed, -1);
        for(int i = 0; i < jobs.length; i++) {
            int deadline = jobs[i][0];
            while(deadline >= 1 && jobsPerformed[deadline] != -1) {
                deadline--;
            }
            if(deadline >= 1) {
                profit += jobs[i][1];
                jobsPerformed[deadline]++;
            }
        }
        
        return profit;
    }
    
    private static int maxDeadline(int[][] jobs) {
        int max = 0;
        for(int[] arr : jobs) max = Math.max(max, arr[0]);
        return max + 1;
    }
}
