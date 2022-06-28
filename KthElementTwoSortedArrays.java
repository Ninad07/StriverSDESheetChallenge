public class Solution {
    public static int ninjaAndLadoos(int arr1[], int arr2[], int m, int n, int k) {
        int i = 0, j = 0;
        int ans = 0;
        while(k > 0 && i < m && j < n) {
            if(arr1[i] <= arr2[j]) {
                i++;
                if(k == 1) return arr1[i - 1];
            } else {
                j++;
                if(k == 1) return arr2[j - 1];
            }
            k--;
        }
        
        if(k > 0) {
            if(i < m) return arr1[i + k - 1];
            else return arr2[j + k - 1];
        }
        
        return -1;
    }
}
