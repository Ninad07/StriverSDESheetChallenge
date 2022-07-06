
public class Solution {

	public static boolean isBalancedBT(BinaryTreeNode<Integer> root) {
		return height(root) != -1;
	}
    
    private static int height(BinaryTreeNode<Integer> root) {
        if(root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        
        if(left == -1 || right == -1) return -1;
        if(Math.abs(left - right) > 1) return -1;
        return 1 + Math.max(left, right);
    }
}
