import java.util.* ;
import java.io.*; 
public class Solution{
    public static int[][] pairSum(int[] arr, int s) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for(int num : arr) {
            hashmap.put(num, hashmap.getOrDefault(num, 0) + 1);
        }
        HashSet<Integer> hashset = new HashSet<>();
        Stack<int[]> stack = new Stack<>();
        for(int num : hashmap.keySet()) {
            if(hashset.contains(num) || hashset.contains(s - num)) continue;
            if(num * 2 == s) {
                int n = hashmap.get(num) - 1;
                int count = ((n * (n + 1)) / 2);
                for(int i = 0; i < count; i++) {
                    stack.push(new int[] {num, num});
                }
                hashset.add(num);
            } else if(hashmap.containsKey(s - num)) {
                int count = hashmap.get(num) * hashmap.get(s - num);
                for(int i = 0; i < count; i++) {
                    stack.push(new int[] {Math.min(num, s - num), Math.max(num, s - num)});
                }
                hashset.add(num);
                hashset.add(s - num);
            }
        }
        
       int[][] ans = new int[stack.size()][2];
        for(int i = ans.length - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        
        Arrays.sort(ans, (a, b) -> {
            return a[0] - b[0];
        });
        
        return ans;
    }
}
