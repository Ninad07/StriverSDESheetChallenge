import java.util.*;
public class Solution {
    public static ArrayList<Integer> pathInATree(TreeNode root, int x) {
        ArrayList<Integer> al = new ArrayList<>();
        path(root, x, al);
        return al;
    }
    
    private static boolean path(TreeNode root, int x, ArrayList<Integer> al) {
        if(root == null) return false;
        if(root.data == x) {
            al.add(root.data);
            return true;
        }
        
        al.add(root.data);
        if(path(root.left, x, al)) return true;
        if(path(root.right, x, al)) return true;
        al.remove(al.size() - 1);
        return false;
    }
}
