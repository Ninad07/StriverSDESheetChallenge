import java.util.*;
public class Solution 
{
	public static String reverseString(String string) 
	{
		String[] arr = string.split(" ");
        StringBuilder ans = new StringBuilder();
        for(int i = arr.length - 1; i >= 0; i--) {
            if(arr[i].length() == 0) continue;
            ans.append(arr[i]).append(" ");
        }
        
        if(ans.charAt(ans.length() - 1) == ' ') ans.deleteCharAt(ans.length() - 1);
        return ans.toString();
	}
}
