import java.util.*;
public class Solution {
	public static int heightOfTheTree(int[] inorder, int[] levelorder, int N){
		return height(inorder, levelorder, 0, inorder.length - 1) - 1;
    }
    
    private static int height(int[] inorder, int[] levelorder, int inBeg, int inEnd) {
        if(inBeg > inEnd) return 0;
        if(inBeg == inEnd) return 1;
        
        int indexInInorder = inBeg;
        while(inorder[indexInInorder] != levelorder[0]) indexInInorder++;
        
        HashSet<Integer> hashset = new HashSet<>();
        for(int i = inBeg; i < indexInInorder; i++) hashset.add(inorder[i]);
        
        int[] leftLevelorder = new int[indexInInorder - inBeg];
        int[] rightLevelorder = new int[inEnd - indexInInorder];
        int leftIndex = 0, rightIndex = 0;
        
        for(int i = 1; i < levelorder.length; i++) {
            if(hashset.contains(levelorder[i])) {
                leftLevelorder[leftIndex++] = levelorder[i];
                hashset.remove(levelorder[i]);
            } else {
                rightLevelorder[rightIndex++] = levelorder[i];
            }
        }
        
        int left = height(inorder, leftLevelorder, inBeg, indexInInorder - 1);
        int right = height(inorder, rightLevelorder, indexInInorder + 1, inEnd);
        
        return Math.max(left, right) + 1;
    }
}
