import java.util.* ;
import java.io.*; 
/****************************************************************
	
	Following is the structure of the Singly Linked List.
	
	class LinkedListNode<T> {
    	T data;
    	LinkedListNode<T> next;

    	public LinkedListNode(T data) {
        	this.data = data;
    	}
	}

****************************************************************/

public class Solution {
	public static LinkedListNode<Integer> removeKthNode(LinkedListNode<Integer> head, int k) {
        if(head == null) return null;
		LinkedListNode<Integer> slow = head, fast = head, prev = null;
        while(k-- > 0) {
            fast = fast.next;
        }
        
        while(fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        
        if(prev == null) head = head.next;
        else prev.next = slow == null ? slow : slow.next;
        return head;
	}
}
