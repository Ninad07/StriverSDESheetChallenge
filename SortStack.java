import java.util.*;
public class Solution {

	public static void sortStack(Stack<Integer> stack) {
		if(stack.isEmpty()) return;
        int val = stack.pop();
        sortStack(stack);
        insert(stack, val);
	}
    
    private static void insert(Stack<Integer> stack, int val) {
        if(stack.isEmpty() || stack.peek() <= val) {
            stack.push(val);
            return;
        }
        
        int data = stack.pop();
        insert(stack, val);
        stack.push(data);
    }

}
