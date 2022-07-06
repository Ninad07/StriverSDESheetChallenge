
import java.util.*;

public class Solution {
	public static ArrayList<Integer> traverseBoundary(TreeNode root) {
		ArrayList<Integer> al = new ArrayList<>();
        al.add(root.data);
        if(root.left == null && root.right == null) return al;
        
        TreeNode node = root.left;
        while(node != null) {
            if(node.left == null && node.right == null) break;
            al.add(node.data);
            if(node.left != null) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        
        preorder(root, al);
        
        node = root.right;
        Stack<Integer> stack = new Stack<>();
        while(node != null) {
            if(node.left == null && node.right == null) break;
            stack.push(node.data);
            if(node.right != null) node = node.right;
            else node = node.left;
        }
        
        while(!stack.isEmpty()) al.add(stack.pop());
        return al;
    }
    
    private static void preorder(TreeNode node, ArrayList<Integer> al) {
        if(node == null) return;
        if(node.left == null && node.right == null) al.add(node.data);
        preorder(node.left, al);
        preorder(node.right, al);
    }
}
