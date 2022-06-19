import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the LinkedListNode class:
	
	class LinkedListNode<T> {
    	T data;
    	LinkedListNode<T> next;

    	public LinkedListNode(T data) {
        	this.data = data;
    	}
	}

*****************************************************************/

public class Solution {

	public static boolean isPalindrome(LinkedListNode<Integer> head) {
		Stack<LinkedListNode<Integer>> stack = new Stack<>();
        LinkedListNode<Integer> node = head;
        while(node != null) {
            stack.push(node);
            node = node.next;
        }
        node = head;
        int size = stack.size() / 2;
        while(size-- > 0) {
            if(!node.data.equals(stack.pop().data)) return false;
            node = node.next;
        }
        return true;
	}
}
