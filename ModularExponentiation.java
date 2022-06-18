import java.util.* ;
import java.io.*; 
public class Solution {
    public static long modularExponentiation(int k, int n, int m) {
        long ans = 1;
        long y = Math.abs(n);
        long x = (long)k;
        while(y > 0) {
            if(y % 2 == 1) {
                ans = (ans * x) % m;
                y--;
            } else {
                x = (x * x) % m;
                y /= 2;
            }
        }
        
        return ans;
    }
}
