import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution{
    // O(n)
    public static int maximumProfit(ArrayList<Integer> prices){
        int buyingPrice = prices.get(0);
        int sellingPrice = buyingPrice;
        int max = 0;
        
        for(int i = 1; i < prices.size(); i++) {
            if(prices.get(i) > sellingPrice) {
                sellingPrice = prices.get(i);
            } else if(prices.get(i) < buyingPrice) {
                max = Math.max(max, sellingPrice - buyingPrice);
                buyingPrice = sellingPrice = prices.get(i);
            }
        }
        max = Math.max(max, sellingPrice - buyingPrice);
        return max;
    }
}
