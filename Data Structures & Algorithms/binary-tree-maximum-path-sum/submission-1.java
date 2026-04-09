/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    int globalSum = Integer.MIN_VALUE;
    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int left_val= dfs(root.left);
        int right_val=  dfs(root.right);

        
     globalSum = Math.max(globalSum,Math.max(root.val,Math.max(root.val+left_val+right_val,Math.max(root.val+left_val,root.val+right_val))));
     return Math.max(root.val,Math.max(root.val+left_val,root.val+right_val));


    }
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return globalSum;
    }
}
