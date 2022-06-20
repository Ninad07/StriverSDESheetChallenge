import java.util.* ;
import java.io.*; 
/***********************************************
    Following is the class structure of the Node class:

    class Node {
        int data;
        Node next;

        Node(int x) {
            this.data = x;
            this.next = null;
        }
    }

************************************************/

public class Solution {
    public static Node rotate(Node head, int k) {
        Node slow = head, fast = head;
        while(k-- > 0) {
            fast = fast.next;
            if(fast == null) fast = head;
        }
        if(fast == null || fast == head) return head;
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        Node newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }
}

