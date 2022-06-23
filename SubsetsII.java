import java.util.*;
public class Solution {
    public static ArrayList<ArrayList<Integer>> uniqueSubsets(int n, int arr[]) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        Arrays.sort(arr);
        subsets(arr, 0, new ArrayList<>(), al);
        return al;
    }
    
    private static void subsets(int[] arr, int index, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> al) {
        al.add(new ArrayList<>(list));
        
        for(int i = index; i < arr.length; i++) {
            if(i - 1 >= index && arr[i] == arr[i - 1]) continue;
            list.add(arr[i]);
            subsets(arr, i + 1, list, al);
            list.remove(list.size() - 1);
        }
        
}
}
