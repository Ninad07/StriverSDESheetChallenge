import java.util.*;
public class Solution{
	public static ArrayList<Integer> kMaxSumCombination(ArrayList<Integer> a, ArrayList<Integer> b, int n, int k){
		PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num1 : a) {
            for(int num2 : b) {
                if(pq.size() < k) {
                    pq.add(num1 + num2);
                } else if(num1 + num2 > pq.peek()) {
                    pq.poll();
                    pq.add(num1 + num2);
                }
            }
        }
        
        ArrayList<Integer> al = new ArrayList<>();
        while(!pq.isEmpty()) al.add(pq.poll());
        Collections.reverse(al);
        return al;
	}
}
