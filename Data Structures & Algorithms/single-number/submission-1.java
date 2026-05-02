class Solution {
    public int singleNumber(int[] nums) {
        // Set<Integer> seen = new HashSet<>();
        // for (int num : nums) {
        //     if (seen.contains(num)) {
        //         seen.remove(num);
        //     } else {
        //         seen.add(num);
        //     }
        // }
        // return seen.iterator().next();

          int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
