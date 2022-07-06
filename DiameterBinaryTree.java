
public class Solution {
	public static int diameterOfBinaryTree(TreeNode<Integer> root) {
		int[] max = {0};
        diameter(root, max);
        return max[0];
	}
    
    private static int diameter(TreeNode<Integer> root, int[] max) {
        if(root == null) return 0;
        int left = diameter(root.left, max);
        int right = diameter(root.right, max);
        max[0] = Math.max(max[0], left + right);
        return 1 + Math.max(left, right);
    }
}
