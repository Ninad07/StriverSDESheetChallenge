import java.util.*;
public class Solution {
    public static List<Integer> maximumMeetings(int[] start, int[] end) {       
        Stack<int[]> stack = new Stack<>();
        int[][] arr = new int[start.length][3];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = new int[] {i, start[i], end[i]};
        }
        
        Arrays.sort(arr, (a, b) -> {
            if(a[2] == b[2]) return a[0] - b[0];
            return a[2] - b[2];
        });
        
        stack.push(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            if(stack.peek()[2] < arr[i][1]) {
                stack.push(arr[i]);
            } 
        }
        
        List<Integer> al = new ArrayList<>();
        while(!stack.isEmpty()) al.add(stack.pop()[0] + 1);
        Collections.reverse(al);
        return al;
    }
}
