public class Solution 
{
    public static int compareVersions(String a, String b) 
    {
        String[] num1 = a.split("\\.");
        String[] num2 = b.split("\\.");
        int i = 0;
        for(i = 0; i < Math.min(num1.length, num2.length); i++) {
            int compare = compare(num1[i], num2[i]);
            if(compare < 0) return -1;
            else if(compare > 0) return 1;
        }
        
        while(i < num1.length) {
            for(char character : num1[i].toCharArray()) {
                if(character != '0') return 1;
            }
            i++;
        }
        while(i < num2.length) {
            for(char character : num2[i].toCharArray()) {
                if(character != '0') return -1;
            }
            i++;
        }
        return 0;
    }
    
    private static int compare(String string1, String string2) {
        if(string1.length() > string2.length()) return 1;
        if(string2.length() > string1.length()) return -1;
        for(int i = 0; i < string1.length(); i++) {
            if(string1.charAt(i) > string2.charAt(i)) return 1;
            else if(string1.charAt(i) < string2.charAt(i)) return -1;
        }
        
        return 0;
    }
}
