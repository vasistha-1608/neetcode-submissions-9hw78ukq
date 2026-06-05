class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] state = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]); 
        }
        for(int i =0;i<numCourses;i++){
           if (state[i] == 0) { 
              if (!dfs(graph, state, i)) {
                    return false;
                }
            }
       
        }
         return true;
    }  
    public boolean dfs(List<List<Integer>> graph, int[] state, int course){
        if(state[course]==1) return false;

        if( state[course]==2) return true;

        state[course] =1;

        for(int i =0;i<graph.get(course).size();i++){
            if(!dfs(graph,state,graph.get(course).get(i))) return false;
        }

        state[course] =2;
        return true;

    }
}