class Solution {


    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo,0);
        memo[0]=1;
        for(int i=0;i<memo.length;i++){
           if(i+1<n+1) memo[i+1] = memo[i+1] + memo[i];
           if(i+2 <n+1) memo[i+2] = memo[i+2] + memo[i];
        }
        return memo[memo.length-1];
    }
}
