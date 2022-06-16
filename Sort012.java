import java.util.* ;
import java.io.*; 
public class Solution 
{
    public static void sort012(int[] arr)
    {
        // O(n)
        int i = 0, j = 0, k = arr.length - 1;
        while(j <= k) {
            if(arr[j] == 0) {
                swap(arr, i, j);
                i++;
                if(i >= j) j++;
            } else if(arr[j] == 2) {
                swap(arr, j, k);
                k--;
            } else {
                j++;
            }
        }
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
