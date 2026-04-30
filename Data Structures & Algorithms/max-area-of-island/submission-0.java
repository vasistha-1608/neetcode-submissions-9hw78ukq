class Solution {

    // Removed 'groundArea' parameter; we will calculate it inside instead
    public int dfs(int[][] grid, int row, int col) {
        int r = grid.length;
        int c = grid[0].length;
        
        // Base case: If out of bounds or we hit water (0), the area is 0
        if (row < 0 || col < 0 || row >= r || col >= c || grid[row][col] == 0) {
            return 0;
        }

        // Mark as visited so we don't count it again
        grid[row][col] = 0;
        
        // Area is 1 (for the current cell) + the area of all 4 neighbors
        int currentArea = 1;
        currentArea += dfs(grid, row - 1, col); 
        currentArea += dfs(grid, row + 1, col); 
        currentArea += dfs(grid, row, col - 1); 
        currentArea += dfs(grid, row, col + 1);
        
        return currentArea;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0; // Track the largest island we've seen
        int rows = grid.length;
        int cols = grid[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                
                // FIX: Use integer 1, not character '1'
                if (grid[r][c] == 1) {
                    
                    // Trigger the DFS, capture the area of this specific island
                    int currentIslandArea = dfs(grid, r, c); 
                    
                    // Did this island beat our all-time high score?
                    maxArea = Math.max(maxArea, currentIslandArea);
                }
            }
        }
        
        // FIX: Return the final answer
        return maxArea;
    }
}