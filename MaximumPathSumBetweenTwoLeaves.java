
public class Solution {
	public static long findMaxSumPath(TreeNode root) {
        if(root == null) return -1;
        if(root.left == null || root.right == null) return -1;
		long[] max = {0};
        maxSum(root, max);
        return max[0];
	}
    
    private static long maxSum(TreeNode root, long[] max) {
        if(root == null) return -1;
        if(root.left == null && root.right == null) return root.data;
        long left = maxSum(root.left, max);
        long right = maxSum(root.right, max);
        
        if(left == -1) return root.data + right;
        if(right == -1) return root.data + left;
        max[0] = Math.max(max[0], left + right + root.data);
        
        return root.data + Math.max(left, right);
    }
}
