import java.util.*;
public class Solution {

	public static int longestIncreasingSubsequence(int arr[]) {
		List<Integer> al = new ArrayList<>();
        int length = 1;
        al.add(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > al.get(length - 1)) {
                al.add(arr[i]);
                length++;
            } else {
                int index = binarySearch(al, arr[i]);
                al.set(index, arr[i]);
            }
        }
        return length;
	}
    
    private static int binarySearch(List<Integer> al, int target) {
        int beg = 0, end = al.size() - 1;
        while(beg <= end) {
            int mid = (beg + end) / 2;
            if(al.get(mid) < target) beg = mid + 1;
            else end = mid - 1;
        }
        return beg;
    }

}
