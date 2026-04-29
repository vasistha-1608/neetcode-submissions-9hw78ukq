class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length ==0) return 0;
        if(nums.length ==1 ) return nums[0];
        int[] dp = new int[nums.length];
        int sum = nums[0];
        Arrays.fill(dp,Integer.MIN_VALUE);
        dp[0] =nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i] = Math.max(nums[i],dp[i-1]+nums[i]);
            sum = Math.max(sum,dp[i]);
        }

        return sum;
    }
}
