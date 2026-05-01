

class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Queue will store the coordinates [row, col]
        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Find ALL treasures and put them in the queue to start our "ripples"
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    queue.add(new int[]{r, c});
                }
            }
        }

        // A clean way to handle 4-directional movement (Up, Down, Left, Right)
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Step 2: Expand outward (BFS)
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];

            // Check all 4 neighbors
            for (int[] dir : directions) {
                int nextRow = r + dir[0];
                int nextCol = c + dir[1];

                // If out of bounds, OR it is a wall (-1), OR we already visited it (not MAX_VALUE)
                if (nextRow < 0 || nextCol < 0 || nextRow >= rows || nextCol >= cols || grid[nextRow][nextCol] != Integer.MAX_VALUE) {
                    continue; // Skip it
                }

                // Because it's BFS, the first time we reach this room is guaranteed to be the shortest path!
                // The distance is just the distance of the cell we came from + 1
                grid[nextRow][nextCol] = grid[r][c] + 1;
                
                // Add this new room to the queue so we can expand from it later
                queue.add(new int[]{nextRow, nextCol});
            }
        }
    }
}