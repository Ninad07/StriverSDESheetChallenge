import java.util.*;
public class Solution {

    public static int findCeil(TreeNode<Integer> root, int X) {
        int[] ans = {-1};
        inorder(root, X, ans);
        return ans[0];
    }
    
    private static boolean inorder(TreeNode<Integer> root, int x, int[] ans) {
        if(root == null) return false;
        if(inorder(root.left, x, ans)) return true;
        if(root.data >= x) {
            ans[0] = root.data;
            return true;
        }
        if(inorder(root.right, x, ans)) return true;
        return false;
    }
}

