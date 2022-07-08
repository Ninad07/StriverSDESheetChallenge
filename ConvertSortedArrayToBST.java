import java.util.ArrayList;

public class Solution {
    public static TreeNode<Integer> sortedArrToBST(ArrayList<Integer> arr, int n) {
         return build(arr, 0, n - 1);       
    }
    
    private static TreeNode<Integer> build(ArrayList<Integer> al, int beg, int end) {
        if(beg == end) return new TreeNode<>(al.get(beg));
        else if(beg > end) return null;
        
        int mid = (beg + end) / 2;
        TreeNode<Integer> root = new TreeNode<>(al.get(mid));
        root.left = build(al, beg, mid - 1);
        root.right = build(al, mid + 1, end);
        
        return root;
    }
}
