

class LRUCache {
    
    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head; 
    private Node tail; 

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        
       
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        
        
        Node node = map.get(key);
        remove(node);
        insertAtBack(node);
        
        return node.val;
    }
    
    public void put(int key, int value) {
        
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        
        // Create the new node and put it at the back of the line
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insertAtBack(newNode);
        
        // If we exceeded capacity, evict the node right after the dummy head
        if (map.size() > capacity) {
            Node lru = head.next;
            remove(lru);
            map.remove(lru.key);
        }
    }
    
    // --- Helper Methods to keep logic clean ---
    
    // Removes a node from anywhere in the linked list
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    // Inserts a node right before the dummy tail
    private void insertAtBack(Node node) {
        Node prevNode = tail.prev;
        
        prevNode.next = node;
        node.prev = prevNode;
        
        node.next = tail;
        tail.prev = node;
    }
}