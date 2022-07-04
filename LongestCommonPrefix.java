
public class Solution {
	public static String longestCommonPrefix(String[] arr, int n) {
		String string = arr[0];
        int beg = 0, end = string.length() - 1;
        String ans = "";
        while(beg <= end) {
            int mid = (beg + end) / 2;
            String prefix = string.substring(0, mid + 1);
            if(isCommon(prefix, arr)) {
                ans = prefix;
                beg = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
	}
    
    private static boolean isCommon(String prefix, String[] arr) {
        for(int i = 1; i < arr.length; i++) {
            if(!arr[i].substring(0, prefix.length()).equals(prefix)) return false;
        }
        return true;
    }

}
