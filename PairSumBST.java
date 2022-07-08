import java.util.*;
public class Solution {
	public static boolean pairSumBst(BinaryTreeNode root, int k) {
		Stack<BinaryTreeNode> stack1 = new Stack<>();
        Stack<BinaryTreeNode> stack2 = new Stack<>();
        BinaryTreeNode curr1 = getNextFromInorder(stack1, root), curr2 = getNextFromReverseInorder(stack2, root);
        
        while(curr1 != null && curr2 != null && curr1.data < curr2.data) {
            if(curr1.data + curr2.data == k) return true;
            else if(curr1.data + curr2.data < k) {
                curr1 = getNextFromInorder(stack1, curr1.right);
            } else {
                curr2 = getNextFromReverseInorder(stack2, curr2.left);
            }
        }
        
        return false;
	}
    
    private static BinaryTreeNode getNextFromInorder(Stack<BinaryTreeNode> stack, BinaryTreeNode curr) {
        while(curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        
        if(!stack.isEmpty()) {
            return stack.pop();
        } 
        return null;
    }
    
    private static BinaryTreeNode getNextFromReverseInorder(Stack<BinaryTreeNode> stack, BinaryTreeNode curr) {
        while(curr != null) {
            stack.push(curr);
            curr = curr.right;
        }
        
        if(!stack.isEmpty()) {
            return stack.pop();
        } 
        return null;
    }
}

