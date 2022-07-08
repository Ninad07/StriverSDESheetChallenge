
import java.util.ArrayList;

public class Solution {
	public static ArrayList<Integer> predecessorSuccessor(BinaryTreeNode<Integer> root, int key) {
		ArrayList<Integer> al = new ArrayList<>();
        al.add(-1);
        al.add(-1);
        search(root, new BinaryTreeNode[1], key, al);
        ArrayList<Integer> list = new ArrayList<>();
        return al;
	}
    
    private static boolean search(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer>[] prev, int key, ArrayList<Integer> al) {
        if(root == null) return false;
        if(search(root.left, prev, key, al)) return true;
        if(prev[0] == null) {
            prev[0] = root;
        } else {
            if(root.data == key) {
                al.set(0, prev[0].data);
            } else if(prev[0].data == key) {
                al.set(1, root.data);
                return true;
            }
            prev[0] = root;
        }
        
        if(search(root.right, prev, key, al)) return true;
        return false;
    }
}
