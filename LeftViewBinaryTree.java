
import java.util.*;

public class Solution 
{
    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) 
    {
        ArrayDeque<TreeNode<Integer>> queue = new ArrayDeque<>();
        ArrayList<Integer> al = new ArrayList<>();
        if(root == null) return al;
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode<Integer> node = queue.poll();
                if(i == 0) al.add(node.data);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
        return al;
    }
}
