import java.util.*;
public class Solution {

    static class BSTIterator{
        Stack<TreeNode<Integer>> stack;
        TreeNode<Integer> next;
        BSTIterator(TreeNode<Integer> root){
            stack = new Stack<>();
            next = getNextFromInorder(root);
        }

        int next(){
            int data = next.data;
            next = getNextFromInorder(next.right);
            return data;
        }

        boolean hasNext(){
            return next != null;
        }
        
        private TreeNode<Integer> getNextFromInorder(TreeNode<Integer> root) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            
            return stack.isEmpty() ? null : stack.pop();
        }
    }
}


