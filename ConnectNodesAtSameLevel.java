import java.util.*;
public class Solution {
	public static void connectNodes(BinaryTreeNode<Integer> root) {
        if(root == null) return;
    	ArrayDeque<BinaryTreeNode<Integer>> queue = new ArrayDeque<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            BinaryTreeNode<Integer> prev = null;
            while(size-- > 0) {
                BinaryTreeNode<Integer> node = queue.poll();
                if(prev != null) prev.next = node;
                prev = node;
                
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
	}
}
