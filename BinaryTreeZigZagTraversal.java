import java.util.*;
public class Solution {
	public static List<Integer> zigZagTraversal(BinaryTreeNode<Integer> root) {
		List<Integer> al = new ArrayList<>();
        if(root == null) return al;
        ArrayDeque<BinaryTreeNode<Integer>> queue = new ArrayDeque<>();
        int level = 0;
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while(size-- > 0) {
                BinaryTreeNode<Integer> node = queue.poll();
                list.add(node.data);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            
            if(level % 2 == 1) Collections.reverse(list);
            al.addAll(list);
            level++;
        }
        return al;
	}
}
