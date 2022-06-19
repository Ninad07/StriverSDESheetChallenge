import java.util.* ;
import java.io.*; 
/*
	Following is the structure of the Singly Linked List.	
	class LinkedListNode<T> 
    {
    	T data;
    	LinkedListNode<T> next;
    	public LinkedListNode(T data) 
        {
        	this.data = data;
    	}
	}

*/
public class Solution 
{
    public static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> head) 
    {        
        if(head == null) return null;
        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> curr = head;
        
        while(curr != null) {
            LinkedListNode<Integer> next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}
