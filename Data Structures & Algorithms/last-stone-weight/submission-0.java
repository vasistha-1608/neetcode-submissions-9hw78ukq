

class Solution {
    public int lastStoneWeight(int[] stones) {
        // Step 1: Create a Max-Heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        // Populate the heap with all the stones
        for (int stone : stones) {
            maxHeap.add(stone);
        }
        
        // Step 2: Run the simulation while at least 2 stones remain
        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.poll(); // The absolute heaviest stone
            int stone2 = maxHeap.poll(); // The second heaviest stone
            
            // If they are not equal, the larger stone survives with reduced weight
            if (stone1 != stone2) {
                maxHeap.add(stone1 - stone2);
            }
            // If they are equal, they are both destroyed (we just do nothing)
        }
        
        // Step 3: Check what's left!
        if (maxHeap.isEmpty()) {
            return 0; // Everything was destroyed
        } else {
            return maxHeap.poll(); // Return the survivor
        }
    }
}