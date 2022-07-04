public class Solution 
{
    public static String writeAsYouSpeak(int n) 
    {
        StringBuilder ans = new StringBuilder("1");
        for(int i = 1; i < n; i++) {
            int j = 0;
            StringBuilder sb = new StringBuilder();
            while(j < ans.length()) {
                char character = ans.charAt(j);
                int freq = 0;
                while(j < ans.length() && ans.charAt(j) == character) {
                    j++;
                    freq++;
                }
                sb.append(freq).append(character);
            }
            
            ans = sb;
        }
        
        return ans.toString();
    }
}
