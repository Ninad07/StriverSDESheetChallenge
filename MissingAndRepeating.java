import java.util.ArrayList;

public class Solution {

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        boolean[] isPresent = new boolean[n + 1];
        int repeating = -1, missing = -1;
        int sum = 0, idealSum = (n * (n + 1)) / 2;
        for(int num : arr) {
            if(isPresent[num]) {
                repeating = num;
                continue;
            }
            isPresent[num] = true;
            sum += num;
        }
        missing = idealSum - sum;
        return new int[] {missing, repeating};
    }
}
