import java.util.*;
public class Solution 
{
    public static TreeNode<Integer> invertBinaryTree(TreeNode<Integer> root, TreeNode<Integer> leaf) {
        if(root == null) return null;
        Stack<TreeNode<Integer>> stack = new Stack<>();
        util(root, stack, leaf);
        TreeNode<Integer> newRoot = stack.pop();
        TreeNode<Integer> parent = newRoot;
        
        while(!stack.isEmpty()) {
            TreeNode<Integer> curr = stack.pop();
            if(curr.left == parent) {
                curr.left = null;
                parent.left = curr;
            } else {
                curr.right = curr.left;
                curr.left = null;
                parent.left = curr;
            }
            parent = curr;
        }
        
        return newRoot;
    }
    
    private static boolean util(TreeNode<Integer> root, Stack<TreeNode<Integer>> stack, TreeNode<Integer> leaf) {
        stack.push(root);
        if(root.left == null && root.right == null) {
            if(root.data.equals(leaf.data)) return true;
            else {
                stack.pop();
                return false;
            }
        }
        
        if(root.left != null && util(root.left, stack, leaf)) return true;
        if(root.right != null && util(root.right, stack, leaf)) return true;
        stack.pop();
        return false;
    }
}
