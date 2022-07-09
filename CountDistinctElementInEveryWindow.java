import java.util.*;

public class Solution {

	public static ArrayList<Integer> countDistinctElements(ArrayList<Integer> arr, int k) {
		HashMap<Integer, Integer> hashmap = new HashMap<>();
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            hashmap.put(arr.get(i), hashmap.getOrDefault(arr.get(i), 0) + 1);
        }
        al.add(hashmap.size());
        for(int i = k; i < arr.size(); i++) {
            hashmap.put(arr.get(i - k), hashmap.get(arr.get(i - k)) - 1);
            if(hashmap.get(arr.get(i - k)) == 0) hashmap.remove(arr.get(i - k));
            hashmap.put(arr.get(i), hashmap.getOrDefault(arr.get(i), 0) + 1);
            al.add(hashmap.size());
        }
        
        return al;
	}
}
