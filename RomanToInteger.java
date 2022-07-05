public class Solution {
    public static int romanToInt(String string) {
        int num = 0;
        int i = 0;
        while(i < string.length()) {
            char character = string.charAt(i);
            if(character == 'I') {
                if(i + 1 < string.length() && string.charAt(i + 1) == 'V') {
                    num += 4;
                    i++;
                } else if(i + 1 < string.length() && string.charAt(i + 1) == 'X') {
                    num += 9;
                    i++;
                } else {
                    num += 1;
                }
            } else if(character == 'X') {
                if(i + 1 < string.length() && string.charAt(i + 1) == 'L') {
                    num += 40;
                    i++;
                } else if(i + 1 < string.length() && string.charAt(i + 1) == 'C') {
                    num += 90;
                    i++;
                } else {
                    num += 10;
                }
            } else if(character == 'C') {
                if(i + 1 < string.length() && string.charAt(i + 1) == 'D') {
                    num += 400;
                    i++;
                } else if(i + 1 < string.length() && string.charAt(i + 1) == 'M') {
                    num += 900;
                    i++;
                } else {
                    num += 100;
                }
            } else if(character == 'V') {
                num += 5;
            } else if(character == 'L') {
                num += 50;
            } else if(character == 'D') {
                num += 500;
            } else if(character == 'M') {
                num += 1000;
            }
            i++;
        }
        
        return num;
    }
}
