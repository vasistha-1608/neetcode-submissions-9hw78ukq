class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length==0) return 0;
        int[] dp = new int[cost.length+1];
        int mincost = Integer.MAX_VALUE;
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 0;
        for(int i=2;i<dp.length;i++){
           for(int j=i-2;j<i;j++){
            dp[i] = Math.min(dp[j]+cost[j], dp[i]);
           }
        }

        return dp[dp.length-1];
    }
}
