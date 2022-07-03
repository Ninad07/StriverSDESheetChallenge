public class Solution {	
	public static String longestPalinSubstring(String string) {
		int beg = -1, end = -1;
        boolean[][] dp = new boolean[string.length()][string.length()];
        
        for(int gap = 0; gap < string.length(); gap++) {
            for(int j = gap, i = 0; j < string.length(); i++, j++) {
                if(gap == 0) {
                    dp[i][j] = true;
                    if(beg == -1 || i < beg) {
                        beg = i;
                        end = j;
                    }
                } else if(gap == 1) {
                    dp[i][j] = string.charAt(i) == string.charAt(j);
                    if(dp[i][j]) {
                        if(j - i > end - beg) {
                            beg = i;
                            end = j;
                        } else if(j - i == end - beg && i < beg) {
                            beg = i;
                            end = j;
                        }
                    }
                } else {
                    if(string.charAt(i) == string.charAt(j) && dp[i + 1][j - 1]) {
                        if(j - i > end - beg) {
                            beg = i;
                            end = j;
                        } else if(j - i == end - beg && i < beg) {
                            beg = i;
                            end = j;
                        }
                        dp[i][j] = true;
                    } else dp[i][j] = false;
                }
            }
        }
        
        return string.substring(beg, end + 1);
	}
}
