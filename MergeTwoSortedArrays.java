import java.util.* ;
import java.io.*; 
public class Solution {
    public static int[] ninjaAndSortedArrays(int arr1[], int arr2[], int m, int n) {
        int i = 0, j = 0;
        while(i < m) {
            if(arr1[i] > arr2[j]) {
                swap(arr1, arr2, i, j);
                while(j < n - 1 && arr2[j] > arr2[j + 1]) {
                    swap(arr2, arr2, j, j + 1);
                    j++;
                }
                j = 0;
            }
            i++;
        }
        
        while(i < arr1.length && j < n) {
            arr1[i++] = arr2[j++];
        }
        return arr1;
    }
    
    private static void swap(int[] arr1, int[] arr2, int i, int j) {
        int temp = arr1[i];
        arr1[i] = arr2[j];
        arr2[j] = temp;
    }
}
