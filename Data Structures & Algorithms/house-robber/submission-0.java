class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)
         return nums[0];
        if(nums.length ==2)
          return Math.max(nums[0],nums[1]);
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        dp[0] = nums[0];
        dp[1] = nums[1];
        for(int i=2;i<nums.length;i++){
            int count =0;
            while(count<i-1){
                int sum = dp[count++]+nums[i];
                dp[i] = Math.max(sum,dp[i]);
            }
        }
        return Math.max(dp[dp.length-1],dp[dp.length-2]);

    }
}
