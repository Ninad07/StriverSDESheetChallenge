import java.util.*;
public class Solution {
    public static boolean areAnagram(String str1, String str2){
        if(str1.length() != str2.length()) return false;
        HashMap<Character, Integer> hashmap = new HashMap<>();
        for(int i = 0; i < str1.length(); i++) {
            hashmap.put(str1.charAt(i), hashmap.getOrDefault(str1.charAt(i), 0) + 1);
            hashmap.put(str2.charAt(i), hashmap.getOrDefault(str2.charAt(i), 0) - 1);
        }
        
        for(char character : hashmap.keySet()) {
            if(hashmap.get(character) != 0) return false;
        }
        return true;
    }
}
