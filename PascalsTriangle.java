import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
	public static ArrayList<ArrayList<Long>> printPascal(int n) {
        ArrayList<ArrayList<Long>> al = new ArrayList<>();
        al.add(new ArrayList<>(Arrays.asList((1L))));
        for(int i = 1; i < n; i++) {
            ArrayList<Long> list = new ArrayList<>();
            list.add(1L);
            for(int j = 1; j < al.get(i - 1).size(); j++) {
                 list.add(al.get(i - 1).get(j) + al.get(i - 1).get(j - 1));
            }
            list.add(1L);
            al.add(list);
        }
        return al;
	}
}
