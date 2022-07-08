import java.util.*;
public class Solution {
	public static TreeNode<Integer> preOrderTree(int[] preorder) {
 		return build(preorder, new int[1], Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
    
    private static TreeNode<Integer> build(int[] preorder, int[] index, int min, int max) {
        if(index[0] >= preorder.length || preorder[index[0]] > max || preorder[index[0]] < min) return null;
        
        TreeNode<Integer> root = new TreeNode<>(preorder[index[0]]);
        index[0]++;
        
        root.left = build(preorder, index, min, root.data - 1);
        root.right = build(preorder, index, root.data + 1, max);
        
        return root;
    }

}
