import java.util.*;
public class Solution {
	public static int getMaxWidth(TreeNode root) {
		if(root == null) return 0;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        int max = 1;
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            max = Math.max(max, size);
            while(size-- > 0) {
                TreeNode node = queue.poll();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
        return max;
	}
}
