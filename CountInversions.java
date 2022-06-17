import java.util.* ;
import java.io.*; 
public class Solution {
    private static long inversions;
    public static long getInversions(long arr[], int n) {
        inversions = 0L;
        mergeSort(arr, 0, n - 1);
        return inversions;
    }
    
    private static long[] mergeSort(long[] arr, int beg, int end) {
        if(beg == end) return new long[] {arr[beg]};
        int mid = (beg + end) / 2;
        long[] left = mergeSort(arr, beg, mid);
        long[] right = mergeSort(arr, mid + 1, end);
        return merge(left, right);
    }
    
    private static long[] merge(long[] left, long[] right) {
        long[] arr = new long[left.length + right.length];
        int i = 0, j = 0;
        int index = 0;
        while(i < left.length && j < right.length) {
            if(left[i] <= right[j]) {
                arr[index++] = left[i++];
            } else {
                inversions += left.length - i;
                arr[index++] = right[j++];
            }
        }
        
        while(i < left.length) {
            arr[index++] = left[i++];
        }
        
        while(j < right.length) {
            arr[index++] = right[j++];
        }
        
        return arr;
    }
}

