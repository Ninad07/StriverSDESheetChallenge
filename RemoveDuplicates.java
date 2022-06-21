import java.util.*;
public class Solution {
	public static int removeDuplicates(ArrayList<Integer> arr,int n) {
		int i = 0, index = 0;
        while(i < n) {
            int num = arr.get(i);
            swap(arr, i, index);
            i++;
            index++;
            while(i < n && arr.get(i) == num) i++;
        }
        
        return index;
	}
    
    private static void swap(ArrayList<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}
