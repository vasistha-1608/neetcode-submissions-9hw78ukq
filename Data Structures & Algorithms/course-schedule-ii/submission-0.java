class Solution {
    List<Integer> order = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] state = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0 && !dfs(graph, state, i)) {
                return new int[0];
            }
        }

        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = order.get(i);
        }
        return result;
    }

    public boolean dfs(List<List<Integer>> graph, int[] state, int course) {
        if (state[course] == 1) return false;  
        if (state[course] == 2) return true;  

        state[course] = 1;

        for (int neighbor : graph.get(course)) {
            if (!dfs(graph, state, neighbor)) return false;
        }

        state[course] = 2;
        order.add(course);  
        return true;
    }
}