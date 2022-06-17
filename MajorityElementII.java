import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution 
{
    public static ArrayList<Integer> majorityElementII(ArrayList<Integer> arr) 
    {
        ArrayList<Integer> al = new ArrayList<>();
        if(arr.size() == 1) {
            al.add(arr.get(0));
            return al;
        } else if(arr.size() == 2) {
            al.add(arr.get(0));
            if(arr.get(0) != arr.get(1)) al.add(arr.get(1));
            return arr;
        }
        
        int num1 = -1, num2 = -1;
        int freq1 = 0, freq2 = 0;
        
        for(int num : arr) {
            if(num1 == -1 || num == num1) {
                num1 = num;
                freq1++;
            } else if(num2 == -1 || num == num2) {
                num2 = num;
                freq2++;
            } else if(freq1 == 0) {
                num1 = num;  
                freq1++;
            } else if(freq2 == 0) {
                num2 = num;
                freq2++;
            } else {
                freq1--;
                freq2--;
            }
        }
        
        freq1 = freq2 = 0;
        for(int num : arr) {
            if(num1 == num) freq1++;
            else if(num2 == num) freq2++;
        }
        
        if(freq1 > arr.size() / 3) al.add(num1);
        if(freq2 > arr.size() / 3) al.add(num2);
        return al;
    }
}
