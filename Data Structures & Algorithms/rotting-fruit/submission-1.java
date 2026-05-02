

class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        
        int freshCount = 0; 
        
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 2){
                    queue.add(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }
        
        
        if (freshCount == 0) return 0;
        
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int minutes = 0; 
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            boolean infectedAnyoneThisMinute = false;
            
            
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];

                for(int[] dir : directions){
                    int nextRow = r + dir[0];
                    int nextCol = c + dir[1];
                    
                    if (nextRow < 0 || nextCol < 0 || nextRow >= rows || nextCol >= cols || grid[nextRow][nextCol] != 1) {
                        continue;
                    }
                    
                    
                    grid[nextRow][nextCol] = 2; 
                    freshCount--;               
                    queue.add(new int[]{nextRow, nextCol});
                    infectedAnyoneThisMinute = true;
                }
            }
            
            // If this wave successfully infected new oranges, a minute has passed
            if (infectedAnyoneThisMinute) {
                minutes++;
            }
        }

        // If we still have fresh oranges left over, it's impossible. Otherwise, return the time.
        return freshCount == 0 ? minutes : -1;
    }
}