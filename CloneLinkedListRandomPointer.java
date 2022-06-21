import java.util.* ;
import java.io.*; 
/*************************************************************

    Following is the LinkedListNode class structure

    class LinkedListNode<T> {
	    T data;
	    LinkedListNode<T> next;
	    LinkedListNode<T> random;

	    public LinkedListNode(T data) {
		    this.data = data;
	    }
    }

*************************************************************/

public class Solution {
	public static LinkedListNode<Integer> cloneRandomList(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> node = head;
        while(node != null) {
            LinkedListNode<Integer> next = node.next;
            node.next = new LinkedListNode<>(node.data);
            node.next.next = next;
            node = next;
        }
        
        node = head;
        while(node != null) {
            if(node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
        
        LinkedListNode<Integer> newHead = new LinkedListNode<>(-1);
        LinkedListNode<Integer> pointer = newHead;
        node = head;
        while(node != null) {
            pointer.next = node.next;
            node.next = node.next.next;
            node = node.next;
            pointer = pointer.next;
        }
        
        return newHead.next;
	}
}
