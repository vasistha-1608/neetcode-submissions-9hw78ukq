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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b)-> a.val - b.val);
       for (ListNode node : lists) {
            if (node != null) {
                heap.add(node);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (!heap.isEmpty()) {
            ListNode top = heap.poll();
            curr.next = top;
            curr = curr.next; 
            if (top.next != null) {
                heap.add(top.next);
            }
        }
        return dummy.next;
    }
}
