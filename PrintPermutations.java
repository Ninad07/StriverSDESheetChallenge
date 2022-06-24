import java.util.*;
public class Solution {
    public static List<String> findPermutations(String string) {
        List<String> al = new ArrayList<>();
        permutations(string, "", al);
        return al;
    }
    
    private static void permutations(String string, String ans, List<String> al) {
        if(string.length() == 0) {
            al.add(ans);
            return;
        }
        
        for(int i = 0; i < string.length(); i++) {
            String curr = new StringBuilder(string.substring(0, i)).append(string.substring(i + 1)).toString();
            permutations(curr, ans + string.charAt(i), al);
        }
    }
}
