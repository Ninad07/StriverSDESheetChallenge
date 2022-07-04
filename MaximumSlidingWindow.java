
import java.util.*;

public class Solution 
{

	public static ArrayList<Integer> getMaximumOfSubarrays(ArrayList<Integer> nums, int k) 
	{
		ArrayDeque<Integer> deque = new ArrayDeque<>();
        ArrayList<Integer> al = new ArrayList<>();
        
        for(int i = 0; i < k; i++) {
            while(!deque.isEmpty() && nums.get(deque.peekLast()) < nums.get(i)) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        
        al.add(nums.get(deque.peekFirst()));
        for(int i = k; i < nums.size(); i++) {
            while(!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }
            
            while(!deque.isEmpty() && nums.get(deque.peekLast()) < nums.get(i)) {
                deque.removeLast();
            }
            deque.addLast(i);
            
            al.add(nums.get(deque.peekFirst()));
        }
        
        return al;
	}
}
