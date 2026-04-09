/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;

        int count = 0;
        ListNode curr1 = head;
        while (curr1 != null) {
            count++;
            curr1 = curr1.next;
        }

        
        Stack<ListNode> stack = new Stack<>();
        ListNode curr2 = head;
        int mid = count / 2; 
        for (int i = 0; i < mid; i++) { // Note: iterating < mid is safer here
            curr2 = curr2.next;
        }
        
        ListNode temp = curr2.next;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        
        curr2.next = null; 

       
        ListNode curr3 = head;
        while (!stack.isEmpty()) {
            ListNode top = stack.pop();
            
            
            ListNode nextTemp = curr3.next; 

           
            curr3.next = top;       
            top.next = nextTemp;    
            curr3 = nextTemp;   
        }
        
    }
}
