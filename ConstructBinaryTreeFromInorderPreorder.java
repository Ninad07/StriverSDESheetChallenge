import java.util.*;

public class Solution 
{
    public static TreeNode<Integer> buildBinaryTree(ArrayList<Integer>  inorder, ArrayList<Integer>  preorder) 
    {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for(int i = 0; i < inorder.size(); i++) {
            hashmap.put(inorder.get(i), i);
        }
        
        return build(preorder, hashmap, 0, preorder.size() - 1, 0, inorder.size() - 1); 
    }
    
    private static TreeNode<Integer> build(ArrayList<Integer> preorder, HashMap<Integer, Integer> hashmap, int preBeg, int preEnd, int inBeg, int inEnd) {
        if(preEnd == preBeg) return new TreeNode<>(preorder.get(preBeg));
        else if(preBeg > preEnd) return null;
        TreeNode<Integer> root = new TreeNode<>(preorder.get(preBeg));
        int inorderIndex = hashmap.get(root.data);
        
        root.left = build(preorder, hashmap, preBeg + 1, preBeg + inorderIndex - inBeg, inBeg, inorderIndex - 1);
        root.right = build(preorder, hashmap, preBeg + inorderIndex - inBeg + 1, preEnd, inorderIndex + 1, inEnd);
        
        return root;
    }
}



