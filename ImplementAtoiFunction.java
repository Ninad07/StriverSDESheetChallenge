public class Solution {
    public static int atoi(String string) {
        int num = 0, sign = string.charAt(0) == '-' ? -1 : 1;
        for(int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            if(Character.isDigit(character)) {
                num = (num * 10) + Character.getNumericValue(character);
            } 
        }
        
        return num * sign;
    }
}
