public class Solution {
    public static int search(int arr[], int key) {
        int beg = 0, end = arr.length - 1;
        while(beg <= end) {
            int mid = (beg + end) / 2;
            if(arr[mid] == key) return mid;
            
            if(arr[beg] <= arr[mid]) {
                if(key >= arr[beg] && key <= arr[mid]) end = mid - 1;
                else beg = mid + 1;
            } else {
                if(key >= arr[mid] && key <= arr[end]) beg = mid + 1;
                else end = mid - 1;
            }
        }
        
        return -1;
    }
}
