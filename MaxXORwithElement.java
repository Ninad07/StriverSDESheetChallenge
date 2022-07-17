import java.util.*;

public class Solution {
    public static ArrayList<Integer> maxXorQueries(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> queries) {
        ArrayList<Integer> al = new ArrayList<>();
        Collections.sort(arr);
        for(ArrayList<Integer> list : queries) {
            int num = list.get(0);
            int xor = -1;
            int target = list.get(1);
            for(int n : arr) {
                if(n > target) break;
                xor = Math.max(xor, num ^ n);
            }
            al.add(xor);
        }
        return al;
    }
}
