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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode curr = head;
        int length=0;
        while(curr!=null){
            length ++;
            curr = curr.next;
        }
        if(length==1){
            head = null;
            return head;
        }

        int actual = length-n;
        ListNode trav = head;
        ListNode prev = null;
        if(actual==0){
            head= head.next;
            return head;
        }
        while(actual>0){
            prev = trav;
            trav = trav.next;
            actual--;
        }
        prev.next = trav.next;
        return head;

    }
}
