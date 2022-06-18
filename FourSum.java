import java.util.* ;
import java.io.*; 
public class Solution {
  public static String fourSum(int[] arr, int target, int n) {
      Arrays.sort(arr);
      for(int i = 0; i <= arr.length - 4; i++) {
          if(threeSum(arr, target - arr[i], i + 1)) return "Yes";
      }
      return "No";
  }
    
  private static boolean threeSum(int[] arr, int target, int index) {
      for(int i = index; i <= arr.length - 3; i++) {
          if(twoSum(arr, target - arr[i], i + 1)) return true;
      }
      return false;
  }
    
  private static boolean twoSum(int[] arr, int target, int index) {
      int i = index, j = arr.length - 1;
      while(i < j) {
          if(arr[i] + arr[j] == target) return true;
          else if(arr[i] + arr[j] < target) i++;
          else j--;
      }
      return false;
  }
}
