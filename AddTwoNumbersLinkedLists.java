import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the Node class:

    class LinkedListNode {
        int data;
        LinkedListNode next;
        
        public LinkedListNode(int data) {
            this.data = data;
        }
    }

*****************************************************************/


public class Solution {
    static LinkedListNode addTwoNumbers(LinkedListNode head1, LinkedListNode head2) {
        LinkedListNode head = null, node = null;
        int carry = 0;
        
        while(head1 != null || head2 != null || carry > 0) {
            int sum = (head1 == null ? 0 : head1.data) + (head2 == null ? 0 : head2.data) + carry;
            int digit = sum % 10;
            carry = sum / 10;
            if(head == null) {
                head = new LinkedListNode(digit);
                node = head;
            } else {
                node.next = new LinkedListNode(digit);
                node = node.next;
            }
            
            if(head1 != null) head1 = head1.next;
            if(head2 != null) head2 = head2.next;
        }
        
        return head;
    }
}


