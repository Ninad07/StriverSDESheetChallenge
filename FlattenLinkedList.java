import java.util.* ;
import java.io.*; 
/****************************************************************

       Following is the class structure of the Node class:

       class Node {
	int data;
	Node next;
	Node child;

	public Node(int data) {
		this.data = data;
		this.next = null;
		this.child = null;
	}
}

*****************************************************************/
public class Solution {
	public static Node flattenLinkedList(Node head) {
        if(head == null) return null;
        return merge(head, flattenLinkedList(head.next));
    }
    
    private static Node merge(Node head1, Node head2) {
        if(head1 == null) return head2;
        if(head2 == null) return head1;
        Node head = new Node(-1);
        Node node = head;
        
        while(head1 != null && head2 != null) {
            if(head1.data <= head2.data) {
                node.child = head1;
                head1 = head1.child;
            } else {
                node.child = head2;
                head2 = head2.child;
            }
            node = node.child;
        }
        
        while(head1 != null) {
            node.child = head1;
            head1 = head1.child;
            node = node.child;
        }
        
        while(head2 != null) {
            node.child = head2;
            head2 = head2.child;
            node = node.child;
        }
        
        return head.child;
    }
}

