/************************************************************

    Following is the TreeNode class structure

	class TreeNode<T> 
	{
	    public T data;
	    public TreeNode<T> left;
	    public TreeNode<T> right;

	    TreeNode(T data) 
	    {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}

************************************************************/


public class Solution 
{

	public static int kthSmallest(TreeNode<Integer> root, int k) 
	{
		int[] val = {k};
        TreeNode<Integer> ans = inorder(root, val);
        return ans == null ? -1 : ans.data;
    }
    
    private static TreeNode<Integer> inorder(TreeNode<Integer> root, int[] val) {
        if(root == null) return null;
        TreeNode<Integer> left = inorder(root.left, val);
        if(left != null) return left;
                
        val[0]--;
        if(val[0] == 0) return root;
        
        TreeNode<Integer> right = inorder(root.right, val);
        if(right != null) return right;        
        return null;
    }
}
