
public class Solution {
    public static void changeTree(BinaryTreeNode < Integer > root) {
        if(root == null) return;
        int max = getMax(root);
        change(root, max);
    }
    
    private static void change(BinaryTreeNode<Integer> root, int max) {
        if(root == null) return;
        change(root.left, max);
        change(root.right, max);
        
        if(root.left == null && root.right == null) {
            root.data = max;
            return;
        }
        
        root.data = (root.left == null ? 0 : root.left.data) + (root.right == null ? 0 : root.right.data);
        
        
    }
    
    private static int getMax(BinaryTreeNode<Integer> root) {
        if(root == null) return 0;
        return Math.max(root.data, Math.max(getMax(root.left), getMax(root.right)));
    }
}
