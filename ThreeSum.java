import java.util.* ;
import java.io.*; 
public class Solution {

    public static ArrayList<ArrayList<Integer>> findTriplets(int[] arr, int n, int K)  {

        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        Arrays.sort(arr);
        for(int i = 0; i <= arr.length - 3; i++) {
            while(i - 1 >= 0 && i <= arr.length - 3 && arr[i] == arr[i - 1]) i++;
            if(i > arr.length - 3) break;
            twoSum(arr, i + 1, arr[i], K - arr[i], al);
        }
        
        return al;
    }
    
    private static void twoSum(int[] arr, int index, int curr, int target, ArrayList<ArrayList<Integer>> al) {
        int i = index, j = arr.length - 1;
        while(i < j) {
            if(arr[i] + arr[j] == target) {
                al.add(new ArrayList<>(Arrays.asList(curr, arr[i], arr[j])));
                i++;
                j--;
                while(i - 1 >= index && i < j && arr[i] == arr[i - 1]) i++;
                while(j + 1 < arr.length && j > i && arr[j] == arr[j + 1]) j--;
            } else if(arr[i] + arr[j] < target) {
                i++;
            } else {
                j--;
            }
        }
    }
}
