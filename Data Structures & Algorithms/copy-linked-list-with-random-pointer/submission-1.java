/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node deepCopy = new Node(0);
        Node trav = head;
        Node dummy = deepCopy;

        Map<Node, Node> map = new HashMap<Node,Node>();

        while(trav!= null){
            Node temp = new Node(0);
            temp.val = trav.val;
             map.put(trav,temp);
            trav = trav.next;
            dummy.next = temp;
            dummy = dummy.next;
        }
        Node trav2 = head;
        Node dummy2 = deepCopy.next;
        while(trav2!= null){
            if(trav2.random ==null){
                dummy2.random = null;
            }
            else{
                dummy2.random = map.get(trav2.random);
            }
            
            trav2= trav2.next;
            dummy2 = dummy2.next;
        }
       
       return deepCopy.next;
       
    }
}
