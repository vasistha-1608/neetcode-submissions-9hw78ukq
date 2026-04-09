class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<nums.length;i++){
            maxHeap.offer(nums[i]);
        }
        for(int i=0;i<k-1;i++){
            maxHeap.poll();
        }
        return maxHeap.peek();
    }
}
