import java.util.*;
public class Solution {
    public static int calculateMinPatforms(int arrival[], int departure[], int n) {
        Arrays.sort(arrival);
        Arrays.sort(departure);
        
        int i = 1, j = 0, platforms = 1, max = 1;
        while(i < arrival.length) {
            if(arrival[i] > departure[j]) {
                platforms--;
                j++;
            } else {
                platforms++;
                max = Math.max(max, platforms);
                i++;
            }
        }
        
        return max;
    }
}     


