
import java.util.*;
public class Solution 
{
    private static class Node {
        TreeNode<Integer> node;
        int level;
        Node() {}
        Node(TreeNode<Integer> node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    public static ArrayList<Integer> verticalOrderTraversal(TreeNode<Integer> root) 
    {
        ArrayList<Integer> al = new ArrayList<>();
        if(root == null) return al;
        HashMap<Integer, ArrayDeque<Integer>> hashmap = new HashMap<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(root, 0));
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            hashmap.putIfAbsent(node.level, new ArrayDeque<>());
            hashmap.get(node.level).add(node.node.data);
            min = Math.min(min, node.level);
            max = Math.max(max, node.level);
            if(node.node.left != null) {
                queue.add(new Node(node.node.left, node.level - 1));
            }
            
            if(node.node.right != null) {
                queue.add(new Node(node.node.right, node.level + 1));
            }
        }
        
        for(int i = min; i <= max; i++) {
            while(!hashmap.get(i).isEmpty()) {
                al.add(hashmap.get(i).poll());
            }
        }
        return al;
    }
}
