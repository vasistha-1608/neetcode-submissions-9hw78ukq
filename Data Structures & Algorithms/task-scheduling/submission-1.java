class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        Arrays.fill(arr,0);
        int count =0;
        for(int i=0;i<tasks.length;i++){
            int temp = (int) tasks[i];
           arr[tasks[i] - 'A']++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int fre : arr){
            if(fre>0) maxHeap.offer(fre);
        }
        Queue<int[]> queue = new LinkedList<>();
        while(!maxHeap.isEmpty() || !queue.isEmpty()){
            count++;
            if(!maxHeap.isEmpty()){
                int curr = maxHeap.poll();
                curr--;
                if(curr>0){
                    queue.offer(new int[]{curr,count+n});
                }
            }
            if(!queue.isEmpty() && queue.peek()[1]== count)
                maxHeap.offer(queue.poll()[0]);
        }

       return count;
    }
}
