import java.util.* ;
import java.io.*; 
import java.util.ArrayList;
import java.util.Collections;

public class Solution 
{
	public static ArrayList<Integer> nextPermutation(ArrayList<Integer> al) 
	{
        int i = al.size() - 2;
        while(i >= 0 && al.get(i) >= al.get(i + 1)) i--;
        if(i == -1) {
            Collections.sort(al);
            return al;
        }
        
        int j = al.size() - 1;
        while(j > i && al.get(j) <= al.get(i)) {
            j--;
        }
        
        swap(al, i, j);
        
        Collections.sort(al.subList(i + 1, al.size()));
        return al;
	}
    
    private static void swap(ArrayList<Integer> al, int i, int j) {
        int temp = al.get(i);
        al.set(i, al.get(j));
        al.set(j, temp);
    }
}
