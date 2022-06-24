import java.util.*;

public class Solution 
{
    public static ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> arr, int n, int target)
    {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        Collections.sort(arr);
        subsetSum(arr, 0, 0, target, new ArrayList<>(), al);
        return al;
    }
    
    private static void subsetSum(ArrayList<Integer> arr, int index, int sum, int target, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> al) {
        if(sum == target) {
           al.add(new ArrayList<>(list));
           return;
        } else if(sum > target || index >= arr.size()) return;
        
        for(int i = index; i < arr.size(); i++) {
            if(i > index && arr.get(i - 1) == arr.get(i)) continue;
            list.add(arr.get(i));
            subsetSum(arr, i + 1, sum + arr.get(i), target, list, al);
            list.remove(list.size() - 1);
        }
    }
}
