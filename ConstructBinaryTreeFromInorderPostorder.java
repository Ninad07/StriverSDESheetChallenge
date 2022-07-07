import java.util.*;
public class Solution {
	public static TreeNode<Integer> getTreeFromPostorderAndInorder(int[] postorder, int[] inorder) {
		HashMap<Integer, Integer> hashmap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            hashmap.put(inorder[i] , i);
        }
        
        return build(postorder, hashmap, 0, postorder.length - 1, 0, inorder.length - 1); 
	}
    
     private static TreeNode<Integer> build(int[] postorder, HashMap<Integer, Integer> hashmap, int postBeg, int postEnd, int inBeg, int inEnd) {
        if(postEnd == postBeg) return new TreeNode<>(postorder[postBeg]);
        else if(postBeg > postEnd) return null;
        TreeNode<Integer> root = new TreeNode<>(postorder[postEnd]);
         if(inBeg == inEnd) return root;
        int inorderIndex = hashmap.get((int)root.data);
        
        root.left = build(postorder, hashmap, postBeg, postBeg + inorderIndex - inBeg - 1, inBeg, inorderIndex - 1);
        root.right = build(postorder, hashmap, postBeg + inorderIndex - inBeg, postEnd - 1, inorderIndex + 1, inEnd);
        
        return root;
    }
}
