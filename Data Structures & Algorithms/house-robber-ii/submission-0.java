class Solution {
    public int rob(int[] nums) {
      if(nums.length==1){
        return nums[0];
      }
      if(nums.length==2){
        return Math.max(nums[0],nums[1]);
      }
      int[] dp = new int[nums.length];
      dp[0] = 0;
      dp[1] = nums[1];
      for(int i=2;i<nums.length;i++){
        int count =0;
        int bestPrevious = 0;
        
        while(count <= i - 2) {
            bestPrevious = Math.max(bestPrevious, dp[count]);
            count++;
        }
        
        dp[i] = Math.max(nums[i] + bestPrevious, dp[i-1]);
      
        
      }
      int sum1= Math.max(dp[dp.length-1],dp[dp.length-2]);
      Arrays.fill(dp,0);
      dp[0] = nums[0];
      dp[1] = nums[1];
      for(int i=2;i<nums.length-1;i++){
        int count =0;
        int bestPrevious = 0;
        
        while(count <= i - 2) {
            bestPrevious = Math.max(bestPrevious, dp[count]);
            count++;
        }
        
        dp[i] = Math.max(nums[i] + bestPrevious, dp[i-1]);
      }
      int sum2= Math.max(dp[dp.length-1],dp[dp.length-2]);
      return Math.max(sum1,sum2);
    }
}
