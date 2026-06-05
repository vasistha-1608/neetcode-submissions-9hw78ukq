class Solution {
    public int rob(int[] nums) {
        if(nums.length ==1)
         return nums[0];
        int[] dp = new int[nums.length];
        Arrays.fill(dp,0);
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i =2;i<dp.length;i++){
            for(int j=0;j<i-1;j++){
                dp[i] = Math.max(dp[i],Math.max(dp[i-1],dp[j]+nums[i]));
            }
        }

        return dp[dp.length-1];

    }
}
