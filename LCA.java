
public class Solution 
{
    public static int lowestCommonAncestor(TreeNode<Integer> root, int x, int y) 
    {
        if(root == null) return -1;
        if(root.data == x || root.data == y) return root.data;
        int left = lowestCommonAncestor(root.left, x, y);
        int right = lowestCommonAncestor(root.right, x, y);
        
        if(left != -1 && right != -1) return root.data;
        if(left != -1) return left;
        if(right != -1) return right;
        
        return -1;
    }
}
