import java.util.*;
public class Solution 
{
    public static ArrayList<ArrayList<Integer>> findSubsetsThatSumToK(ArrayList<Integer> arr, int n, int k) 
	{
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        subsetSum(arr, 0, 0, k, new ArrayList<>(), al);
        return al;
    }
    
    private static void subsetSum(ArrayList<Integer> arr, int index, int sum, int k, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> al) {
        if(index >= arr.size()) {
            if(sum == k) {
                al.add(new ArrayList<>(list));
            }
            return;
        }
        
        list.add(arr.get(index));
        subsetSum(arr, index + 1, sum + arr.get(index), k, list, al);
        list.remove(list.size() - 1);
        subsetSum(arr, index + 1, sum, k, list, al);
    }
}
