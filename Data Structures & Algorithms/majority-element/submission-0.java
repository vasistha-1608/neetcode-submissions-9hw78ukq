class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        int majority =0;
       for (Map.Entry<Integer, Integer> entry : map.entrySet())  {
                   if(entry.getValue()> n/2 ){
                    majority = entry.getKey();
                   }
                }

        return majority;
    }
}