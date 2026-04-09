class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }

    
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int count : freq) {
            if (count > 0) {
                maxHeap.offer(count);
            }
        }

        Queue<int[]> cooldownQueue = new LinkedList<>();
        int time = 0;

        
        while (!maxHeap.isEmpty() || !cooldownQueue.isEmpty()) {
            time++; 

            
            if (!maxHeap.isEmpty()) {
                int currentFreq = maxHeap.poll();
                currentFreq--; 

                
                if (currentFreq > 0) {
                    cooldownQueue.offer(new int[]{currentFreq, time + n});
                }
            }

            
            if (!cooldownQueue.isEmpty() && cooldownQueue.peek()[1] == time) {
                maxHeap.offer(cooldownQueue.poll()[0]);
            }
        }

        return time;
      
        

    }
}
