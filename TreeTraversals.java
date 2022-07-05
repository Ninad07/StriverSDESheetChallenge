import java.util.*;
public class Solution {
    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
        List<List<Integer>> al = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        inorder(root, list1);
        al.add(list1);
        List<Integer> list2 = new ArrayList<>();
        preorder(root, list2);
        al.add(list2);
        List<Integer> list3 = new ArrayList<>();
        postorder(root, list3);
        al.add(list3);
        return al;
    }
    
    private static void inorder(BinaryTreeNode<Integer> root, List<Integer> al) {
        if(root == null) return;
        inorder(root.left, al);
        al.add(root.data);
        inorder(root.right, al);
    }
    
     private static void preorder(BinaryTreeNode<Integer> root, List<Integer> al) {
        if(root == null) return;
        al.add(root.data);
        preorder(root.left, al);
        preorder(root.right, al);
    }
    
     private static void postorder(BinaryTreeNode<Integer> root, List<Integer> al) {
        if(root == null) return;
         postorder(root.left, al);
         postorder(root.right, al);
         al.add(root.data);
    }
}
