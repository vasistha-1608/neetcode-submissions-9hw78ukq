class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[2*nums.length];
        int count =nums.length;
        for(int i=0;i<nums.length;i++){
            ans[i] = nums[i];
            ans[i+count] = nums[i];
        }

        return ans;
    }
}