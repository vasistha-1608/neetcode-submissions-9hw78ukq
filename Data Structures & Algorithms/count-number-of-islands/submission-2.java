class Solution {

    public void dfs(char[][] grid , int row, int col){
       if( row>=grid.length|| col>=grid[0].length || row<0 || col <0) return ;
       if (grid[row][col]=='0') return ;

       grid[row][col] ='0';

       dfs(grid,row-1, col);
       dfs(grid,row+1,col);
       dfs(grid,row,col-1);
       dfs(grid,row,col+1);
    
        return ;
       
    }

    public int numIslands(char[][] grid) {

        int count=0;
        int row = grid.length;
        int col = grid[0].length;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }

        return count;
        
    }
}
