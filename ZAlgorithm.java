public class Solution {

	public static int zAlgorithm(String string, String pattern, int n, int m) {
		int count = 0;
        int[] dp = new int[pattern.length()];
        int j = 0, i = 1;
        while(i < pattern.length()) {
            if(pattern.charAt(i) == pattern.charAt(j)) {
                dp[i] = ++j;
                i++;
            } else {
                dp[i] = 0;
                if(j == 0) {
                    i++;
                } else {
                    j = dp[j - 1];
                }
            }
        }

        i = j = 0;
        while(i < string.length()) {
            if(string.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if(j == 0) {
                    i++;
                } else {
                    j = dp[j - 1];
                }
            }
            
            if(j >= pattern.length()) {
                count++;
                i = i - pattern.length() + 1;
                j = 0;
            }
        }
        
        
        return count;

	}

}
