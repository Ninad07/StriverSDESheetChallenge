
public class Solution {
    
    public static boolean identicalTrees(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(!root1.data.equals(root2.data)) return false;
        return identicalTrees(root1.left, root2.left) && identicalTrees(root1.right, root2.right);
    }

}
