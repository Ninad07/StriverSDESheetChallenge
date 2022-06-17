import java.util.* ;
import java.io.*; 
/*******************************************************

    Following is the Interval class structure

    class Interval {
        int start, int finish;

        Interval(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }
    
*******************************************************/

import java.util.List;
import java.util.ArrayList;

public class Solution {
    public static List<Interval> mergeIntervals(Interval[] intervals) {
        List<Interval> al = new ArrayList<>();
        if(intervals.length == 1) {
            al.add(intervals[0]);
            return al;
        }
        Arrays.sort(intervals, (a, b) -> {
            return a.start - b.start;
        });
        Stack<Interval> stack = new Stack<>();
        stack.push(intervals[0]);
        
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i].start > stack.peek().finish) {
                stack.push(intervals[i]);
            } else {
                stack.peek().finish = Math.max(stack.peek().finish, intervals[i].finish);
            }
        }
        while(!stack.isEmpty()) {
            al.add(stack.pop());
        }
        return reverse(al);
    }
    
    private static List<Interval> reverse(List<Interval> al) {
        int i = 0, j = al.size() - 1;
        while(i < j) {
            Interval temp = al.get(i);
            al.set(i, al.get(j));
            al.set(j, temp);
            i++;
            j--;
        }
        return al;
    }
}













