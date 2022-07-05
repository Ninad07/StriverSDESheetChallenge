import java.util.*;
public class Solution {
    public static ArrayList<Integer> getLevelOrder(BinaryTreeNode root) {
        ArrayList<Integer> al = new ArrayList<>();
        if(root == null) return al;
        ArrayDeque<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                BinaryTreeNode node = queue.poll();
                al.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
        return al;
    }
}
