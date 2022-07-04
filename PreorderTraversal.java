/*
	
	Following is the Binary Tree node structure:

	public class TreeNode {
	    int data;
	    TreeNode left;
	    TreeNode right;
	    TreeNode() {}
	    TreeNode(int val) { this.data = val; }
	    TreeNode(int val, TreeNode left, TreeNode right) {
	       this.data = val;
	        this.left = left;
	        this.right = right;
	    }
	}

*/
import java.util.*;
public class Solution {
    public static List < Integer > getPreOrderTraversal(TreeNode root) {
    	List<Integer> al = new ArrayList<>();
        preorder(root, al);
        return al;
    }
    
    private static void preorder(TreeNode root, List<Integer> al) {
        if(root == null) return;
        al.add(root.data);
        preorder(root.left, al);
        preorder(root.right, al);
    }
}

