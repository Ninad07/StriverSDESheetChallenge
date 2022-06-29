import java.util.ArrayList;

public class Solution 
{
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> arr, int k)
	{
		ArrayList<Integer> al = new ArrayList<>();
        for(ArrayList<Integer> list : arr) {
            al = merge(list, al);
        }
        return al;
	}
    
    private static ArrayList<Integer> merge(ArrayList<Integer> al1, ArrayList<Integer> al2) {
        if(al1.size() == 0) return al2;
        if(al2.size() == 0) return al1;
        ArrayList<Integer> al = new ArrayList<>();
        int i = 0, j = 0;
        while(i < al1.size() && j < al2.size()) {
            if(al1.get(i) <= al2.get(j)) {
                al.add(al1.get(i++));
            } else {
                al.add(al2.get(j++));
            }
        }
        
        while(i < al1.size()) al.add(al1.get(i++));
        while(j < al2.size()) al.add(al2.get(j++));
        
        return al;
    }
}
