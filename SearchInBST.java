
public class Solution {
	public static Boolean searchInBST(BinaryTreeNode<Integer> root, int x) {
		if(root == null) return false;
        if(root.data == x) return true;
        else if(root.data < x) {
            return searchInBST(root.right, x);
        } else {
            return searchInBST(root.left, x);
        }
	}
}
