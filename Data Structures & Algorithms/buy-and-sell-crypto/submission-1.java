class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        dp[0] =0;
        Arrays.fill(dp,0);
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<i;j++){
                dp[i] = Math.max(dp[i],Math.max(dp[i-1],prices[i]-prices[j]));
            }
        }
        return dp[dp.length-1];
    }
}
