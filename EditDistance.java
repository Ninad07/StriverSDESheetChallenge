
public class Solution {

    public static int editDistance(String str1, String str2) {
        return editDistance(str1, str2, 0, 0, new Integer[str1.length()][str2.length()]);
    }
    
    private static int editDistance(String string1, String string2, int i, int j, Integer[][] dp) {
        if(i >= string1.length()) {
            return string2.length() - j;
        } else if(j >= string2.length()) {
            return string1.length() - i;
        }
        if(dp[i][j] != null) return dp[i][j];
        if(string1.charAt(i) == string2.charAt(j)) {
            return dp[i][j] = editDistance(string1, string2, i + 1, j + 1, dp);
        } else {
            return dp[i][j] = 1 + Math.min(editDistance(string1, string2, i + 1, j, dp), Math.min(editDistance(string1, string2, i, j + 1, dp), editDistance(string1, string2, i + 1, j + 1, dp)));
        }
    }
}
