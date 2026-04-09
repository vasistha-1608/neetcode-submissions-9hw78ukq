class Solution {
    
    public int recursion(int n ,int memo[]){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = recursion(n - 1, memo) + recursion(n - 2, memo);
        return memo[n];

        
    }
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
      return recursion(n,memo);
        
    }
}
