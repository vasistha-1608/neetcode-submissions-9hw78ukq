class Solution {
    int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}}; 

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) return result;
        
        int rows = heights.length;
        int cols = heights[0].length;
        
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        
        // 1. DFS from the Vertical borders (Left/Right)
        for (int i = 0; i < rows; i++) {
            dfs(heights, i, 0, pacific, heights[i][0]); // Left edge -> Pacific
            dfs(heights, i, cols - 1, atlantic, heights[i][cols - 1]); // Right edge -> Atlantic
        }
        
        // 2. DFS from the Horizontal borders (Top/Bottom)
        for (int j = 0; j < cols; j++) {
            dfs(heights, 0, j, pacific, heights[0][j]); // Top edge -> Pacific
            dfs(heights, rows - 1, j, atlantic, heights[rows - 1][j]); // Bottom edge -> Atlantic
        }
        
        // 3. Find cells that can reach both
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        
        return result;
    }
    
    // Helper DFS: Notice we pass the 'prevHeight' to check if water can flow UP to us
    private void dfs(int[][] heights, int r, int c, boolean[][] ocean, int prevHeight) {
        // Base cases: Out of bounds, ALREADY visited, or the water can't flow UP to this cell
        if (r < 0 || c < 0 || r >= heights.length || c >= heights[0].length 
            || ocean[r][c] || heights[r][c] < prevHeight) {
            return;
        }
        
        // Mark as reachable from this ocean
        ocean[r][c] = true;
        
        // Explore all 4 directions
        for (int[] d : dir) {
            dfs(heights, r + d[0], c + d[1], ocean, heights[r][c]);
        }
    }
}