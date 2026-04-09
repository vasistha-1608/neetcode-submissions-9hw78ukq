class Solution {
     List<List<Integer>> solutions = new ArrayList<>(); 
    void backtrack(int[] candidates, int target, List<Integer> currentPath, int startIdx) {
        
        if (target == 0) { 
            solutions.add(new ArrayList<>(currentPath)); 
            return;
        }
        if (target < 0) { 
            return;
        }
        for (int i = startIdx; i < candidates.length; i++) {
            currentPath.add(candidates[i]);
            backtrack(candidates, target - candidates[i], currentPath, i); 
            currentPath.remove(currentPath.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> currentPath = new ArrayList<>();
        backtrack(candidates, target, currentPath, 0);
        return solutions;
    }
}
