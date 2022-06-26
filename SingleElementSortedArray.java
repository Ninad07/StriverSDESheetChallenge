import java.util.ArrayList;

public class Solution 
{
    public static int uniqueElement(ArrayList<Integer> arr) 
    {
        int beg = 0, end = arr.size() - 1;
        while(beg <= end) {
            int mid = (beg + end) / 2;
            int prev = mid - 1 < 0 ? -1 : arr.get(mid - 1);
            int next = mid + 1 >= arr.size() ? -1 : arr.get(mid + 1);
            if(arr.get(mid) != prev && arr.get(mid) != next) {
                return arr.get(mid);
            } else if(mid % 2 == 1) {
                if(prev != arr.get(mid)) end = mid - 1;
                else beg = mid + 1;
            } else {
                if(arr.get(mid) == next) beg = mid + 1;
                else end = mid - 1;
            }
        }
        
        return -1;
    }
}
