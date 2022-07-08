import java.util.*;
public class Solution 
{
    public static TreeNode<Integer> flattenBinaryTree(TreeNode<Integer> root)
    {
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> prev = null;
        stack.add(root);
        
        while(!stack.isEmpty()) {
            TreeNode<Integer> node = stack.pop();
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
            
            if(prev == null) prev = node;
            else {
                prev.right = node;
                prev.left = null;
                prev = node;
            }
        }
        
        return root;
    }
}
