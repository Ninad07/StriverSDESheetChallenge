import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution{
    public static int findDuplicate(ArrayList<Integer> arr, int n){
        int fast = arr.get(0);
        int slow = arr.get(0);
        
        do {
            slow = arr.get(slow);
            fast = arr.get(arr.get(fast));
        } while(fast != slow);
        
        fast = arr.get(0);
        while(fast != slow) {
            slow = arr.get(slow);
            fast = arr.get(fast);
        }
        
        return slow;
    }
}
