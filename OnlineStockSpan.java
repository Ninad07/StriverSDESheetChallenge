import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public static ArrayList<Integer> findSpans(ArrayList<Integer> price) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> al = new ArrayList<>();
        
        for(int i = 0; i < price.size(); i++) {
            while(!stack.isEmpty() && price.get(stack.peek()) <= price.get(i)) {
                stack.pop();
            }
            
            if(stack.isEmpty()) {
                al.add(i + 1);
            } else {
                al.add(i - stack.peek());
            }
            
            stack.push(i);
        }
        
        return al;
    }
}
