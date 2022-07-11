import java.util.*;
public class Solution {
    public static Boolean wordBreak(String[] arr, int n, String target) {
        HashSet<String> hashset = new HashSet<>();
        for(String word : arr) hashset.add(word);
        return wordBreak(hashset, target, 0, new Boolean[target.length()]);
    }
    
    private static Boolean wordBreak(HashSet<String> hashset, String string, int index, Boolean[] dp) {
        if(index >= string.length()) return true;
        if(dp[index] != null) return dp[index];
        
        for(int i = index; i < string.length(); i++) {
            String prefix = string.substring(index, i + 1);
            if(hashset.contains(prefix)) {
                if(wordBreak(hashset, string, i + 1, dp)) return dp[index] = true;
            }
        }
        
        return dp[index] = false;
    }
}
