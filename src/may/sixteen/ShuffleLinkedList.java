package may.sixteen;

/**
 * Definition for singly-linked list.
 */
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
public class ShuffleLinkedList {
    public ListNode oddEvenList(ListNode head) {
    	if (head == null)  
            return null;
    	
    	ListNode odd = head;
    	ListNode even = head.next;
    	
    	ListNode firstEven = even;
    	
    	while(true) {
    		if(odd == null || even == null || even.next == null) {
    			odd.next = firstEven;
    			break;
    		}
    		
    		odd.next = even.next;
    		odd = even.next;
    		
    		if(odd.next == null) {
    			even.next = null;
    			odd.next = firstEven;
    			break;
    		}
    		
    		even.next = odd.next;
    		even = odd.next;
    	}
    	return head;
    }
    
    public static void main(String[] args) {
    	ShuffleLinkedList ll = new ShuffleLinkedList();
 
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = null;
		
		ListNode newList = ll.oddEvenList(head);
		
		while(newList != null) {
			System.out.print(newList.val+" -> ");
			newList = newList.next;
		}
	}
}