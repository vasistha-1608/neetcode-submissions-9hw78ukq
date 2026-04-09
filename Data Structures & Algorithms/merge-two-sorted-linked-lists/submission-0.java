class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode dummy = new ListNode(0);
        ListNode mergedList = dummy;
        ListNode curr1= list1,curr2=list2;
        while(curr1 != null && curr2 != null){
            if(curr2.val <= curr1.val){
                mergedList.next = curr2;
                curr2 = curr2.next;
            }
            else{
                mergedList.next = curr1;
                curr1 = curr1.next;
            }
            mergedList = mergedList.next;
        }

        if(curr1 != null) {
            mergedList.next = curr1;
        }
        if(curr2 != null){
            mergedList.next = curr2;
        }

        return dummy.next;
    }
}