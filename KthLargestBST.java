
import java.util.ArrayList;

public class Solution {
	public static int KthLargestNumber(TreeNode<Integer> root, int k) {
		int[] val = {k};
        TreeNode<Integer> ans = inorder(root, val);
        return ans == null ? -1 : ans.data;
	}
    
    private static TreeNode<Integer> inorder(TreeNode<Integer> root, int[] val) {
        if(root == null) return null;
        TreeNode<Integer> right = inorder(root.right, val);
        if(right != null) return right;
        
        val[0]--;
        if(val[0] == 0) return root;
        
        TreeNode<Integer> left = inorder(root.left, val);
        if(left != null) return left;
        
        return null;
    }
}
