import java.util.*;
public class Solution {

	public static ArrayList<String> wordBreak(String string, ArrayList<String> dictionary) {
		ArrayList<String> al = new ArrayList<>();
        HashSet<String> hashset = new HashSet<>(dictionary);
        wordBreak(string, 0, new StringBuilder(), hashset, al);
        return al;
	}
    
    private static void wordBreak(String string, int index, StringBuilder ans, HashSet<String> hashset, ArrayList<String> al) {
        if(index >= string.length()) {
            al.add(ans.toString());
            return;
        }
        
        for(int i = index; i < string.length(); i++) {
            String prefix = string.substring(index, i + 1);
            if(hashset.contains(prefix)) {
                StringBuilder newAns = new StringBuilder(ans);
                newAns.append(prefix).append(" ");
                wordBreak(string, i + 1, newAns, hashset, al);
            }
        }
    }
}
