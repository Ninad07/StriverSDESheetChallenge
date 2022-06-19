import java.util.* ;
import java.io.*; 
public class Solution 
{
	public static int uniqueSubstrings(String string) 
    {
		HashMap<Character, Integer> hashmap = new HashMap<>();
        int i = -1, j = -1;
        int max = 0;
        
        while(true) {
            while(i < string.length() - 1) {
                i++;
                char character = string.charAt(i);
                hashmap.put(character, hashmap.getOrDefault(character, 0) + 1);
                if(hashmap.get(character) > 1) {
                    break;
                } else {
                    max = Math.max(i - j, max);
                }
            }
            
            if(i == string.length() - 1 && hashmap.size() == i - j) break;
            
            while(j < i) {
                j++;
                char character = string.charAt(j);
                hashmap.put(character, hashmap.get(character) - 1);
                if(hashmap.get(character) == 0) hashmap.remove(character);
                
                if(hashmap.get(string.charAt(i)) == 1) {
                    break;
                } else {
                    max = Math.max(max, i - j);
                }
            }
        }
        
        return max;
	}
}
