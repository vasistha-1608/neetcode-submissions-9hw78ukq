class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<Integer>());
            
        }
        for(int i=0;i<edges.length;i++){
           map.get(edges[i][0]).add(edges[i][1]);
           map.get(edges[i][1]).add(edges[i][0]);
        }
Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, -1}); 
        
        int visitedCount = 0;

        
        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int node = current[0];
            int parent = current[1];

            if (visited[node]) {
                return false;
            }

            
            visited[node] = true;
            visitedCount++;

            
            for (int neighbor : map.get(node)) {
                
                if (neighbor == parent) {
                    continue;
                }
                
                
                if (!visited[neighbor]) {
                    stack.push(new int[]{neighbor, node});
                } else {
                    
                    return false; 
                }
            }
        }

        
        return visitedCount == n;
    }
}
