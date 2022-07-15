
public class Solution {

    public static int minCharsforPalindrome(String string) {
        return Math.max(0, string.length() - longestPrefixSuffix(string));
    }
    
    private static int longestPrefixSuffix(String str) {
        String string = new StringBuilder(str + "#"+ new StringBuilder(str).reverse().toString()).toString();
        int[] dp = new int[string.length()];
        int i = 1, j = 0;
        while(i < string.length()) {
            if(string.charAt(i) == string.charAt(j)) {
                dp[i++] = ++j;
            } else {
                dp[i] = 0;
                if(j == 0) i++;
                else j = dp[j - 1];
            }
        }
        return dp[dp.length - 1];
    }
    
}
