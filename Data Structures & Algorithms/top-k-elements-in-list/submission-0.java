class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>((a, b) -> a.get(1) - b.get(1));
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
       for (Map.Entry<Integer, Integer> entry : map.entrySet()){
           int key = entry.getKey();
           int value = entry.getValue(); 
           if(minHeap.size()<k){
            minHeap.add(Arrays.asList(key, value));
           }
           else{
             List<Integer> minimum = minHeap.peek();
             if(minimum.get(1)<value){
               minHeap.poll();
               minHeap.add(Arrays.asList(key, value)); 
             }
           }
       }
       int[] list = new int[minHeap.size()];
       int index = 0;
        while(!minHeap.isEmpty()){
         list[index++] = minHeap.poll().get(0);
        }
     return list; 
    }
}
