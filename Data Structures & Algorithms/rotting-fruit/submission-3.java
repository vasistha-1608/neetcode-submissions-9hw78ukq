class Solution {
    public int orangesRotting(int[][] grid) {
       Queue<int[]> queue = new LinkedList<>();
       int count =0;
       int row = grid.length;
       int col = grid[0].length;
       for(int i=0;i<row;i++){
        for(int j=0;j<col;j++){
            if(grid[i][j]==2){
                queue.offer(new int[]{i,j,0});
                grid[i][j]=-1;
            }  
        }
       }

    while(!queue.isEmpty()){
        int[] top = queue.poll();
        int r = top[0];
        int c = top[1];
        if(r>0 && grid[r-1][c]==1){
            queue.offer(new int[]{r-1,c,top[2]+1});
            grid[r-1][c] =-1;
        }
        if(c>0 && grid[r][c-1]==1){
            queue.offer(new int[]{r,c-1,top[2]+1});
            grid[r][c-1] =-1;
        }
        if(r<row-1 && grid[r+1][c]==1){
            queue.offer(new int[]{r+1,c,top[2]+1});
            grid[r+1][c] =-1;
        }

         if(c<col-1 && grid[r][c+1]==1){
            queue.offer(new int[]{r,c+1,top[2]+1});
            grid[r][c+1] =-1;
        }
        count = Math.max(count,top[2]);
        
        
    }

    for(int i=0;i<row;i++){
        for(int j=0;j<col;j++){
            if(grid[i][j]==1)
             return -1;
        }
    }

    return count;

    }
}
