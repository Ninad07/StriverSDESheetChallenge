import java.util.*;
public class Solution {
	
	public static BinaryTreeNode<Integer> BTtoDLL(BinaryTreeNode<Integer> root) {
	    Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        BinaryTreeNode<Integer> curr = root;
        BinaryTreeNode<Integer> newRoot = null, prev = null;
        
        while(true) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            if(!stack.isEmpty()) {
                curr = stack.pop();
                if(newRoot == null) {
                    newRoot = curr;
                    prev = curr;
                } else {
                    prev.right = curr;
                    curr.left = prev;
                    prev = curr;
                }
                
                curr = curr.right;
            } else break;
        }
        
        return newRoot;
	}
	

}
