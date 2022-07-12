import java.util.*;

public class Solution {
	public static int maximumProduct(ArrayList<Integer> arr, int n) {
		int minProd = arr.get(0), maxProd = arr.get(0);
        int omax = minProd;
        for(int i = 1; i < n; i++) {
            if(arr.get(i) == 0) {
                omax = Math.max(omax, 0);
                minProd = maxProd = 0;
                continue;
            }
            int temp = maxProd;
            maxProd = Math.max(arr.get(i), Math.max(minProd * arr.get(i), maxProd * arr.get(i)));
            minProd = Math.min(arr.get(i), Math.min(minProd * arr.get(i), temp * arr.get(i)));
            omax = Math.max(omax, maxProd);
        }
        
        return omax;
	}
}
