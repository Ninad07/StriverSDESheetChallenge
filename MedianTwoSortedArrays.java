public class Solution {
    public static double median(int[] arr1, int[] arr2) {
        if(arr1.length > arr2.length) return median(arr2, arr1);
        int beg = 0, end = arr1.length;
        
        while(beg <= end) {
            int partition1 = (beg + end) / 2;
            int partition2 = ((arr1.length + arr2.length + 1) / 2) - partition1;
            
            int left1 = partition1 == 0 ? Integer.MIN_VALUE : arr1[partition1 - 1];
            int left2 = partition2 == 0 ? Integer.MIN_VALUE : arr2[partition2 - 1];
            
            int right1 = partition1 == arr1.length ? Integer.MAX_VALUE : arr1[partition1];
            int right2 = partition2 == arr2.length ? Integer.MAX_VALUE : arr2[partition2];
            
            if(left1 <= right2 && left2 <= right1) {
                if((arr1.length + arr2.length) % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    return Math.max(left1, left2);
                }
            } else if(left1 > right2) {
                end = partition1 - 1;
            } else {
                beg = partition1 + 1;
            }
        }
        
        // Unreachable
        return 0.0;
    }
}
