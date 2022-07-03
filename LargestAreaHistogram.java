import java.util.*;
public class Solution {
  public static int largestRectangle(ArrayList < Integer > heights) {
      Stack<Integer> stack1 = new Stack<>();
      Stack<Integer> stack2 = new Stack<>();
      int n = heights.size();
      int[] leftSmaller = new int[heights.size()];
      int[] rightSmaller = new int[heights.size()];
      
      for(int i = 0; i < n; i++) {
          while(!stack1.isEmpty() && heights.get(stack1.peek()) >= heights.get(i)) {
              stack1.pop();
          }
          
          while(!stack2.isEmpty() && heights.get(stack2.peek()) >= heights.get(n - 1 - i)) {
              stack2.pop();
          }
          
          if(stack1.isEmpty()) leftSmaller[i] = -1;
          else leftSmaller[i] = stack1.peek();
          
          if(stack2.isEmpty()) rightSmaller[n - 1 - i] = n;
          else rightSmaller[n - 1 - i] = stack2.peek();
          
          stack1.push(i);
          stack2.push(n - 1 - i);
      }
      
      int max = 0;
      for(int i = 0; i < n; i++) {
          int width = rightSmaller[i] - leftSmaller[i] - 1;
          int area = heights.get(i) * width;
          max = Math.max(max, area);
      }
      
      return max;
  }
}
