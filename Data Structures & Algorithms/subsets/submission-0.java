class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
       
        backtrack(nums, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, int startIndex, List<Integer> currentSubset) {
        result.add(new ArrayList<>(currentSubset));
        for (int i = startIndex; i < nums.length; i++) {
            currentSubset.add(nums[i]);
             backtrack(nums, i + 1, currentSubset);
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}