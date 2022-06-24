import java.util.*;
public class Solution {
    public static List<List<String>> partition(String string) {
        List<List<String>> al = new ArrayList<>();
        partition(string, 0, new ArrayList<>(), al);
        return al;
    }
    
    private static void partition(String string, int index, List<String> list, List<List<String>> al) {
        if(index >= string.length()) {
            al.add(new ArrayList<>(list));
            return;
        }
        
        for(int i = index; i < string.length(); i++) {
            String prefix = string.substring(index, i + 1);
            if(isPalindrome(prefix)) {
                list.add(prefix);
                partition(string, i + 1, list, al);
                list.remove(list.size() - 1);
            }
        }
    }
    
    private static boolean isPalindrome(String string) {
        int i = 0, j = string.length() - 1;
        while(i < j) {
            if(string.charAt(i++) != string.charAt(j--)) return false;
        }
        return true;
    }
}
