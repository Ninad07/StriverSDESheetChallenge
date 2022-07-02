import java.util.*;
import java.io.*;

public class Solution{
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() >= arr.get(i)) {
                stack.pop();
            }
            
            if(stack.isEmpty()) al.add(-1);
            else al.add(stack.peek());
            
            stack.push(arr.get(i));
        }
        
        Collections.reverse(al);
        return al;
    }
}

