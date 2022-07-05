import java.util.*;
public class Solution {
    private static class TreeNode {
        BinaryTreeNode node;
        int level;
        TreeNode() {}
        TreeNode(BinaryTreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
        ArrayList<Integer> al = new ArrayList<>();
        if(root == null) return al;
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(new TreeNode(root, 0));
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            hashmap.putIfAbsent(node.level, node.node.val);
            min = Math.min(min, node.level);
            max = Math.max(max, node.level);
            if(node.node.left != null) {
                queue.add(new TreeNode(node.node.left, node.level - 1));
            }
            
            if(node.node.right != null) {
                queue.add(new TreeNode(node.node.right, node.level + 1));
            }
        }
        
        for(int i = min; i <= max; i++) {
            al.add(hashmap.get(i));
        }
        return al;
    }
    
   
}
