/*
	This is signature of helper function 'knows'.
	You should not implement it, or speculate about its implementation.

	boolean knows(int A, int B); 
	Function 'knows(A, B)' will returns "true" if the person having
	id 'A' know the person having id 'B' in the party, "false" otherwise.
	Use it as Runner.knows(A, B);
*/
import java.util.*;	
public class Solution {
	public static int findCelebrity(int n) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++) stack.push(i);
        while(stack.size() > 1) {
            int person1 = stack.pop();
            int person2 = stack.pop();
            if(Runner.knows(person1, person2)) {
                stack.push(person2);
            } else {
                stack.push(person1);
            }
        }
        
        int potentialCelebrity = stack.pop();
        for(int i = 0; i < n; i++) {
            if(i == potentialCelebrity) continue;
            if(Runner.knows(potentialCelebrity, i) || !Runner.knows(i, potentialCelebrity)) {
                return -1;
            }
        }
        
        return potentialCelebrity;
    }
}
