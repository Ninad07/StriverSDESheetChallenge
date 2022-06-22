/****************************************************************

    Following is the class structure of the Pair class:

        class Pair
        {
        	int weight;
	        int value;
	        Pair(int weight, int value)
	        {
		        this.weight = weight;
		        this.value = value;
	        }
	        
        }
        
*****************************************************************/
import java.util.*;

public class Solution {
    public static double maximumValue(Pair[] items, int n, int w) {
         Arrays.sort(items, (a, b) -> {
             double val2 = (double)b.value / (double)b.weight; 
             double val1 = (double)a.value / (double)a.weight;
             if(val1 > val2) return -1;
             else return 1;
         });
        
        double max = 0.0;
        for(int i = 0; i < items.length; i++) {
            if(w - items[i].weight < 0) {
                max += ((double)w / (double)items[i].weight) * (double)items[i].value;
                break;
            } else {
                max += items[i].value;
                w -= items[i].weight;
            }
        }
        
        return max;
    }
}
