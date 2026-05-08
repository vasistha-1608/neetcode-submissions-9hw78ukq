class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int total = m * n;

        int[][] visited = new int[m][n];

        
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int dir = 0;        

        int row = 0, col = 0;

        for (int k = 0; k < total; k++) {
            list.add(matrix[row][col]);
            visited[row][col] = 1;

            
            int nr = row + dr[dir];
            int nc = col + dc[dir];

            
            if (nr < 0 || nr >= m || nc < 0 || nc >= n || visited[nr][nc] == 1) {
                dir = (dir + 1) % 4;         // turn right
                nr = row + dr[dir];
                nc = col + dc[dir];
            }

            row = nr;
            col = nc;
        }

        return list;
    }
}
