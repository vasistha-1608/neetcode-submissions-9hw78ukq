class Solution {
    public int maxProduct(int[] nums) {
       if (nums.length==0) return 0;
       int currentMax =nums[0];
       int currentMin = nums[0];
       int globalMax = nums[0];
       for(int i=1;i<nums.length;i++){
        int num = nums[i];
        int tempMax = currentMax;
        currentMax = Math.max(num, Math.max(num * tempMax, num * currentMin));
        currentMin = Math.min(num, Math.min(num * tempMax, num * currentMin));

        globalMax = Math.max(globalMax,currentMax);
       }
     return globalMax;
    }
}
