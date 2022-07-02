import java.util.*;
public class Solution {
	public static ArrayList<ArrayList<Integer>> pwset(ArrayList<Integer> arr) {
		ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        powerSet(arr, 0, al, new ArrayList<>());
        return al;
	}
    
    private static void powerSet(ArrayList<Integer> arr, int index, ArrayList<ArrayList<Integer>> al, ArrayList<Integer> list) {
        al.add(new ArrayList<>(list));
        if(index >= arr.size()) return;
        
        for(int i = index; i < arr.size(); i++) {
            list.add(arr.get(i));
            powerSet(arr, i + 1, al, list);
            list.remove(list.size() - 1);
        }
    }
}

