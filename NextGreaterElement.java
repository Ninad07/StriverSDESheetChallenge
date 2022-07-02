
import java.util.*;
public class Solution {
	
	public static int[] nextGreater(int[] arr, int n) {	
        Stack<Integer> stack = new Stack<>();
		int[] nextGreater = new int[n];
	    for(int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            
            if(stack.isEmpty()) nextGreater[i] = -1;
            else nextGreater[i] = stack.peek();
            
            stack.push(arr[i]);
        }
        
        return nextGreater;
	}

}
