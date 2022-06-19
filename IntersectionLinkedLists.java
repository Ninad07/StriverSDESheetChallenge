import java.util.* ;
import java.io.*; 
/************************************
	 
	 //Following is the class structure of the LinkedListNode class:
	 
	  class LinkedListNode<T> {
		public T data;
		public LinkedListNode<T> next;
		
		public LinkedListNode(T data) {
			this.data = data;
			this.next = null;
		}
	}

*****************************************/
public class Solution {

	public static int findIntersection(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
		LinkedListNode<Integer> node1 = head1;
        LinkedListNode<Integer> node2 = head2;
        
        while(node1 != node2) {
            node1 = node1 == null ? head2 : node1.next;
            node2 = node2 == null ? head1 : node2.next;
        }
       
        return node1 == null ? -1 : node1.data;
	}
}
