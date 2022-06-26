import java.util.ArrayList;

public class Solution
{
	public static int getMedian(ArrayList<ArrayList<Integer>> al)
	{
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i = 0; i < al.size(); i++) {
            min = Math.min(min, al.get(i).get(0));
            max = Math.max(max, al.get(i).get(al.get(i).size() - 1));
        }
        
        int beg = min, end = max;
        int length = al.size() * al.get(0).size();
        while(beg <= end) {
            int mid = (beg + end) / 2;
            int elementsLessThanEqualToCurr = getElementsLessThanEqualToCurr(al, mid);
            if(elementsLessThanEqualToCurr <= length / 2) {
                beg = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return beg;
	}
    
    private static int getElementsLessThanEqualToCurr(ArrayList<ArrayList<Integer>> al, int curr) {
        int count = 0;
        for(ArrayList<Integer> list : al) {
            int beg = 0, end = list.size() - 1;
            while(beg <= end) {
                int mid = (beg + end) / 2;
                if(list.get(mid) <= curr) {
                    beg = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            
            count += beg;
        }
        
        return count;
    }
}

