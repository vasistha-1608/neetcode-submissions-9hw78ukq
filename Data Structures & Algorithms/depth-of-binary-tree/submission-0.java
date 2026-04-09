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

    public int traverse(TreeNode root, int depth){
        if(root==null)
         return depth;
        depth = depth+1;
        return Math.max(traverse(root.left,depth),traverse(root.right,depth));
        
    }

    public int maxDepth(TreeNode root) {
        return traverse(root,0);
        
    }
}
