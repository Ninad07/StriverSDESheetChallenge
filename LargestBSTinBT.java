import java.util.*;
public class Solution {
    private static class BST {
        boolean isBST;
        int size, min, max;
        public BST() {
            
        }
       
    }
    private static int max;
	public static int largestBST(TreeNode<Integer> root) {
		max = Integer.MIN_VALUE;
        largestBSTUtil(root);
        return max;
	}
    
    private static BST largestBSTUtil(TreeNode<Integer> root) {
        if(root == null) {
            BST base = new BST();
            base.isBST = true;
            base.size = 0;
            base.min = Integer.MAX_VALUE;
            base.max = Integer.MIN_VALUE;
            return base;
        }
        
        BST left = largestBSTUtil(root.left);
        BST right = largestBSTUtil(root.right);
        
        BST curr = new BST();
        curr.isBST = left.isBST && right.isBST && (root.data >= left.max && root.data <= right.min);
        curr.size = curr.isBST ? (left.size + right.size + 1) : 1;
        curr.min = Math.min(root.data, left.min);
        curr.max = Math.max(root.data, right.max);
       
        max = Math.max(max, curr.size);
        
        return curr;
    }
}

