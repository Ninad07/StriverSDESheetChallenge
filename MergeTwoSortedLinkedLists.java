import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the linked list node structure:
    
    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
        }
    }

************************************************************/

public class Solution {
	public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
        if(head1 == null) return head2;
        if(head2 == null) return head1;
		LinkedListNode<Integer> node1 = head1;
        LinkedListNode<Integer> node2 = head2;
        LinkedListNode<Integer> head = new LinkedListNode<Integer>(-1);
        LinkedListNode<Integer> node = head;
        
        while(node1 != null && node2 != null) {
            if(node1.data <= node2.data) {
                node.next = new LinkedListNode<Integer>(node1.data);
                node1 = node1.next;
            } else {
                node.next = new LinkedListNode<Integer>(node2.data);
                node2 = node2.next;
            }
            
            node = node.next;
        }
        
        while(node1 != null) {
            node.next = new LinkedListNode<Integer>(node1.data);
            node1 = node1.next;
            node = node.next;
        }
        
        while(node2 != null) {
            node.next = new LinkedListNode<Integer>(node2.data);
            node2 = node2.next;
            node = node.next;
        }
        
        return head.next;
	}
}
