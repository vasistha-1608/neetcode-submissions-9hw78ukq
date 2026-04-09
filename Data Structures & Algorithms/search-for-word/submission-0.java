class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                
                if (board[r][c] == word.charAt(0)) {
                    
                    if (dfs(board, r, c, 0, word)) {
                        return true;
                    }
                }
            }
        }
        return false; 
    }

    
         boolean dfs(char[][] board, int r, int c, int wordIndex, String word) {
        
        if (wordIndex == word.length()) {
            return true;
        }
        
       
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length 
            || board[r][c] != word.charAt(wordIndex)) {
            return false;
        }
        
        
        char temp = board[r][c];
        board[r][c] = '#'; 
        
        boolean found = dfs(board, r - 1, c, wordIndex + 1, word) || 
                        dfs(board, r + 1, c, wordIndex + 1, word) || 
                        dfs(board, r, c - 1, wordIndex + 1, word) || 
                        dfs(board, r, c + 1, wordIndex + 1, word);
        board[r][c] = temp;
        
        return found;
    }
}
