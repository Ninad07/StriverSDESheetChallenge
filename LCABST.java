import java.util.*;
public class Solution 
{

	public static TreeNode<Integer> LCAinaBST(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) 
    {		
        if(p.data > q.data) return LCAinaBST(root, q, p);
        if(root == null) return null;
        if(p.data <= root.data && q.data >= root.data) {
            return root;
        } else if(p.data > root.data) {
            return LCAinaBST(root.right, p, q);
        } else {
            return LCAinaBST(root.left, p, q);
        }
	}
}
