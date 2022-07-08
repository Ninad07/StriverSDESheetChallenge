import java.util.*;
public class Solution 
{
    public static String serializeTree(TreeNode<Integer> root)
    {
        if(root == null) return "";
        StringBuilder ans = new StringBuilder();
        ArrayDeque<TreeNode<Integer>> queue = new ArrayDeque<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            TreeNode<Integer> node = queue.poll();
            ans.append(node.data == -1 ? "N" : node.data).append("#");
            
            if(node.data == -1) continue;
            
            if(node.left != null) queue.add(node.left);
            else queue.add(new TreeNode<>(-1));
            
            if(node.right != null) queue.add(node.right);
            else queue.add(new TreeNode<>(-1));
        }
        
        while(ans.length() > 0 && (ans.charAt(ans.length() - 1) == 'N' || ans.charAt(ans.length() - 1) == '#')) {
            ans.deleteCharAt(ans.length() - 1);
        }
        
        return ans.toString();
    }
    
    public static TreeNode<Integer> deserializeTree(String string)
    {
        if(string.length() == 0 || string.charAt(0) == 'N') return null;
        String[] arr = string.split("#");
        ArrayDeque<TreeNode<Integer>> queue = new ArrayDeque<>();
        TreeNode<Integer> root = new TreeNode(Integer.parseInt(arr[0]));
        queue.add(root);
        int index = 0;
        
        while(!queue.isEmpty() && index < arr.length - 1) {
            TreeNode<Integer> node = queue.poll();
            index++;
            
            if(!arr[index].equals("N")) {
                node.left = new TreeNode<>(Integer.parseInt(arr[index]));
                queue.add(node.left);
            }
            
            index++;
            if(index < arr.length && !arr[index].equals("N")) {
                node.right = new TreeNode<>(Integer.parseInt(arr[index]));
                queue.add(node.right);
            }
        }
        
        return root;
    }
}
