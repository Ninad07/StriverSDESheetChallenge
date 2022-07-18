import java.util.*;

public class Solution {
    public static String kthPermutation(int n, int k) {
        List<Integer> al = new ArrayList<>();
        int fact = 1;
        for(int i = 1; i < n; i++) {
            fact *= i;
            al.add(i);
        }
        
        StringBuilder ans = new StringBuilder();
        al.add(n);
        k--;
        while(al.size() > 0) {
            ans.append(al.get(k / fact));
            al.remove(k / fact);
            if(al.size() == 0) break;
            k %= fact;
            fact /= al.size();
        }
        
        return ans.toString();
    }
}
