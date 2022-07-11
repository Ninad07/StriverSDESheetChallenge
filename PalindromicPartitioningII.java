public class Solution {

	public static int palindromePartitioning(String string) {
	    return palindromicPartitioning(string, 0, new Integer[string.length()]) - 1;
	}
    
    private static int palindromicPartitioning(String string, int index, Integer[] dp) {
        if(index >= string.length()) return 0;
        if(dp[index] != null) return dp[index];
        
        int minCuts = string.length();
        for(int i = index; i < string.length(); i++) {
            String prefix = string.substring(index, i + 1);
            if(isPalindrome(prefix)) {
                minCuts = Math.min(minCuts, 1 + palindromicPartitioning(string, i + 1, dp));
            }
        }
        return dp[index] = minCuts;
    }
    
    private static boolean isPalindrome(String string) {
        int i = 0, j = string.length() - 1;
        while(i < j) {
            if(string.charAt(i) != string.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }
}
