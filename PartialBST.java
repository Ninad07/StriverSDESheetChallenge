import java.util.*;
public class Solution {
    public static boolean validateBST(BinaryTreeNode<Integer> root) {
        return inorder(root, new BinaryTreeNode[1]);
    }
    
    private static boolean inorder(BinaryTreeNode<Integer> root, BinaryTreeNode[] prev) {
        if(root == null) return true;
        if(!inorder(root.left, prev)) return false;
        if(prev[0] != null) {
            if(prev[0].data > root.data) return false;
        }
        
        prev[0] = root;
        
        if(!inorder(root.right, prev)) return false;
        return true;
    }
}
