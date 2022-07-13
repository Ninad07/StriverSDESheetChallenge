import java.util.*;
public class Solution {
    public static int[] maxMinWindow(int[] arr, int n) {
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MIN_VALUE);
        int[] nextSmaller = new int[n];
        int[] prevSmaller = new int[n];
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
 
        for(int i = 0; i < n; i++) {
            while(!stack1.isEmpty() && arr[stack1.peek()] >= arr[i]) {
                stack1.pop();
            }
            
            while(!stack2.isEmpty() && arr[stack2.peek()] >= arr[n - 1 - i]) {
                stack2.pop();
            }
            
            if(stack1.isEmpty()) prevSmaller[i] = -1;
             else prevSmaller[i] = stack1.peek();
            
            if(stack2.isEmpty()) nextSmaller[n - 1 - i] = n;
            else nextSmaller[n - 1 - i] = stack2.peek();
            
            stack1.push(i);
            stack2.push(n - 1 - i);
        }
        
        for(int i = 0; i < n; i++) {
            int size = (nextSmaller[i] - prevSmaller[i]) - 1;
            ans[size - 1] = Math.max(ans[size - 1], arr[i]);
        }
       
        int i = n - 1;
        int max = ans[i--];
        while(i >= 0) {
            ans[i] = Math.max(max, ans[i]);
            max = Math.max(max, ans[i]);
            i--;
        }
        
        return ans;
    }
}

