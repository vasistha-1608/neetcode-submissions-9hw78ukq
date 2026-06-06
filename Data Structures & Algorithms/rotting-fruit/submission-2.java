class Solution {
    public int orangesRotting(int[][] grid) {

    int res =0;
    Queue<int[]> queue = new LinkedList<>();
    int rows = grid.length;
    int col = grid[0].length;
    for(int i=0;i<rows;i++){
        for(int j=0;j<col;j++){
            if(grid[i][j]==2) {
                int depth =0;
                queue.add(new int[]{i,j,depth});
                grid[i][j] =-1;
            }
        }
    }

    while(!queue.isEmpty()){
        int [] current = queue.poll();
        int r = current[0] , c = current[1];
        if(r>0 && grid[r-1][c]==1){
            grid[r-1][c] =2;
            queue.add(new int[]{r-1,c,current[2]+1});

        }

        if(r<rows-1 && grid[r+1][c]==1){
            grid[r+1][c] =2;
            queue.add(new int[]{r+1,c,current[2]+1});
            
        }

        if(c>0 && grid[r][c-1]==1){
            grid[r][c-1] =2;
            queue.add(new int[]{r,c-1,current[2]+1});
            
        }

        if(c<col-1 && grid[r][c+1]==1){
            grid[r][c+1] =2;
            queue.add(new int[]{r,c+1,current[2]+1});
            
        }

        res = Math.max(res,current[2]);
        grid[r][c] = -1;
    }

    for(int i=0;i<rows;i++){
        for(int j=0;j<col;j++){
            if(grid[i][j]==1) return -1;
        }
    }
    return res;    
    
    }
}
