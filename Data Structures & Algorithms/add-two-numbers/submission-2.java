class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // Dummy node to anchor the result list
        ListNode curr = dummy;
        int carry = 0; // This will hold the "carry the 1" value
        
        // Loop as long as there is a node in l1, OR a node in l2, OR a leftover carry
        while (l1 != null || l2 != null || carry > 0) {
            int sum = carry; // Always start with the carry from the previous column
            
            // Add l1's value if it exists, then move l1 forward
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            
            // Add l2's value if it exists, then move l2 forward
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            // Calculate the new carry (e.g., if sum is 14, carry becomes 1)
            carry = sum / 10;
            
            // Calculate the actual digit to place in the node (e.g., if sum is 14, digit is 4)
            int digit = sum % 10;
            
            // Create the new node and move the current pointer forward
            curr.next = new ListNode(digit);
            curr = curr.next;
        }
        
        return dummy.next;
    }
}