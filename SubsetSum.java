import java.util.*;
public class Solution {
    public static ArrayList<Integer> subsetSum(int arr[]) {
        ArrayList<Integer> al = new ArrayList<>();
        for(int size = 1; size <= arr.length; size++) {
            subset(arr, 0, size, 0, al);
            
        }
        al.add(0);
        Collections.sort(al);
        return al;
    }
    
    private static void subset(int[] arr, int index, int size, int sum, ArrayList<Integer> al) {
        if(size == 0) {
            al.add(sum);
            return;
        }
        
        for(int i = index; i < arr.length; i++) {
            subset(arr, i + 1, size - 1, sum + arr[i], al);
        }
    }

}
