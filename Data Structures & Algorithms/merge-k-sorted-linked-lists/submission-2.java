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
        ListNode dummy = new ListNode();
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)-> Integer.compare(a.val ,b.val));
        for(int i=0;i<lists.length;i++){
            minHeap.add(lists[i]);
        }
        ListNode curr = dummy;
        while(!minHeap.isEmpty()){
            ListNode temp = new ListNode();
            ListNode top = minHeap.poll();
            temp.val = top.val;
            curr.next = temp;
            curr = curr.next;
            if(top.next!=null)
                minHeap.add(top.next);

        }

        return dummy.next;
    }
}
