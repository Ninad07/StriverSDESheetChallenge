import java.util.* ;
import java.io.*; 
public class Solution {
	public static int findMajority(int[] arr, int n) {
		int potentialAns = arr[0];
        int freq = 1;
        for(int i = 1; i < n; i++) {
            if(arr[i] == potentialAns) {
                freq++;
            } else {
                freq--;
                if(freq == 0) {
                    potentialAns = arr[i];
                    freq = 1;
                }
            }
        }
        
        freq = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] == potentialAns) {
                freq++;
                if(freq > n / 2) return potentialAns;
            }
        }
        
        return -1;
	}
}
