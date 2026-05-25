class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length()==0 || text2.length()==0) return 0;
         int[][] dp = new int[text1.length()+1][text2.length()+1];
         int row = dp.length;
         int col = dp[0].length;
         for(int i=0;i<row;i++){
            Arrays.fill(dp[i],0);
         }
         int count = 0;
         for(int i=1;i<row;i++){
            char t1 = text1.charAt(i-1);
            for(int j=1;j<col;j++){
                char t2 = text2.charAt(j-1);
                if(t1==t2){
                    dp[i][j] = dp[i-1][j-1] +1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
         }
        return dp[row-1][col-1];
    }
}
