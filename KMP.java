import java.util.*;
public class Solution {
    public static boolean findPattern(String pattern, String string) {
        if(pattern.length() == 1) {
            return string.indexOf(pattern) != -1;
        }
        int[] dp = new int[pattern.length()];
        int j = 0, i = 1;
        while(i < pattern.length()) {
            if(pattern.charAt(i) == pattern.charAt(j)) {
                dp[i++] = ++j;
            } else {
                dp[i] = 0;
                if(j == 0) {
                    i++;
                } else {
                    j = dp[j - 1];
                }
            }
        }
        
        j = i = 0;
        while(i < string.length() && j < pattern.length()) {
            if(string.charAt(i) == pattern.charAt(j)) {
                j++;
                i++;
            } else {
                if(j == 0) {
                    i++;
                } else {
                    j = dp[j - 1];
                }
            }
        }
        
        return j >= pattern.length();
    }
}
