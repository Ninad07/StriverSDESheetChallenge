import java.util.ArrayList;

public class Solution {
	public static ArrayList<Integer> stringMatch(String string, String pattern) {
		ArrayList<Integer> al = new ArrayList<>();
        if(pattern.length() > string.length()) return al;
        int hash1 = getHashCode(pattern);
        int hash2 = getHashCode(string.substring(0, pattern.length()));
        if(hash1 == hash2 && string.substring(0, pattern.length()).equals(pattern)) al.add(0);
        
        for(int i = pattern.length(); i < string.length(); i++) {
            hash2 += getHashCode(string.charAt(i) + "") - getHashCode(string.charAt(i - pattern.length()) + "");
            if(hash1 == hash2 && string.substring(i - pattern.length() + 1, i + 1).equals(pattern)) al.add(i - pattern.length() + 1);
        }
        return al;
	}
    
    private static int getHashCode(String string) {
        int code = 0;
        for(char character : string.toCharArray()) code += character - 'A' + 1;
        return code;
    }
}
