class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int num =0;
        for(int i=0;i<nums.length;i++){
            maxHeap.add(nums[i]);
        }

        while(k>0){
            num = maxHeap.poll();
            k--;
        }
        return num;
    }
}
