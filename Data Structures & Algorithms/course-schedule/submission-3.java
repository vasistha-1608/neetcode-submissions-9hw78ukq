class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        
        
        for (int[] pre : prerequisites) {
            int target = pre[0];
            int req = pre[1];
            adj.get(req).add(target); 
            indegree[target]++;       
        }
        
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        
        int completedCourses = 0;
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            completedCourses++; 
            
            
            for (int nextCourse : adj.get(curr)) {
                indegree[nextCourse]--; 
                
               
                if (indegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }
        
        
        return completedCourses == numCourses;
    }
}