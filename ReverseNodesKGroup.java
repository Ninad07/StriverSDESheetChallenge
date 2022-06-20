import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the Node class:

        class Node
        {
        public:
	        int data;
	        Node *next;
	        Node(int data)
	        {
		        this->data = data;
		        this->next = NULL;
	        }
        };

*****************************************************************/

public class Solution {
	public static Node getListAfterReverseOperation(Node head, int n, int arr[]) {
        if(head == null) return null;
		return reverse(head, 0, arr);
	}
    
    private static Node reverse(Node head, int index, int[] arr) {
        if(index >= arr.length) return head;
        int k = arr[index];
        
        if(k == 0) {
            return reverse(head, index + 1, arr);
        }
        
        Node prev = null, curr = head;
        while(k-- > 0 && curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        if(index == arr.length - 1 || curr == null) {
            head.next = curr;
        } else {
            head.next = reverse(curr, index + 1, arr);
        }
        
        return prev;
    }
}

