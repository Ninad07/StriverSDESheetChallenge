import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution 
{
    private static int count;
    public static int reversePairs(ArrayList<Integer> arr) 
    {
        count = 0;
        mergeSort(arr, 0, arr.size() - 1);
        return count;
    }
    
    private static ArrayList<Integer> mergeSort(ArrayList<Integer> arr, int beg, int end) {
        if(beg == end) {
            return new ArrayList<>(Arrays.asList(arr.get(beg)));
        }
        int mid = (beg + end) / 2;
        ArrayList<Integer> left = mergeSort(arr, beg, mid);
        ArrayList<Integer> right = mergeSort(arr, mid + 1, end);
        return merge(left, right);
    }
    
    private static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {
        ArrayList<Integer> al = new ArrayList<>();
        int i = 0, j = 0;
        
        while(i < left.size()) {
            while(j < right.size() && (long)left.get(i) > 2 * (long)right.get(j)) j++;
            count += j;
            i++;
        }
        i = j = 0;
        while(i < left.size() && j < right.size()) {
            if(left.get(i) <= right.get(j)) {
                al.add(left.get(i++));
            } else {
                al.add(right.get(j++));
            }
        }
        
        while(i < left.size()) {
            al.add(left.get(i++));
        }
        
        while(j < right.size()) {
            al.add(right.get(j++));
        }
        
        return al;
    }
}
