class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       List<List<Integer>> graph = new ArrayList<>();
       int[] visited = new int[numCourses];
       for(int i=0;i<numCourses;i++){
        graph.add(new ArrayList<Integer>());
       }
       for(int i=0;i<prerequisites.length;i++){
          graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
       }
       Arrays.fill(visited,0); 
       for(int i=0;i<numCourses;i++){
        if(visited[i]==0){
            if(!dfs(graph,visited,i))
            return false;
        }
         
       }
       return true;
    }

    
    public boolean dfs(List<List<Integer>> graph, int[] visited, int course){
        if(visited[course]==1) return false;

        if(visited[course]==2) return true;

        visited[course] =1;
        for(int i=0;i<graph.get(course).size();i++){
            
           if(!dfs(graph,visited,graph.get(course).get(i))) return false ;
        }

        visited[course] =2;

        return true;
    }

}
