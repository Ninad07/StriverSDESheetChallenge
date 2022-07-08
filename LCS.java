
public class Solution {

	public static int lcs(String string1, String string2) {
		return lcs(string1, string2, 0, 0, new Integer[string1.length()][string2.length()]);
    }
    
    private static int lcs(String string1, String string2, int i, int j, Integer[][] dp) {
        if(i >= string1.length() || j >= string2.length()) return 0;
        if(dp[i][j] != null) return dp[i][j];
        if(string1.charAt(i) == string2.charAt(j)) {
            return dp[i][j] = 1 + lcs(string1, string2, i + 1, j + 1, dp);
        } else {
            return dp[i][j] = Math.max(lcs(string1, string2, i + 1, j, dp), lcs(string1, string2, i, j + 1, dp));
        }
    }

}
