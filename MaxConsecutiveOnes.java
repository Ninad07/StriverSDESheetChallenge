import java.util.ArrayList;

public class Solution {
	public static int longestSubSeg(ArrayList<Integer> arr , int n, int k) {
		int i = 0, j = 0;
        int max = 0;
        while(i < n) {
            if(arr.get(i) == 1) {
                i++;
            } else {
                if(k <= 0) {
                    while(j < i && arr.get(j) == 1) {
                        j++;
                    }
                    j++;
                } else {
                    k--;
                }
                
                i++;
            }
            
            max = Math.max(max, i - j);
        }
        
        return max;
	}
}
