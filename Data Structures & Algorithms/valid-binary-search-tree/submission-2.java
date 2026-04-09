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
    Long max = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
    if(root.left != null){
        if (!isValidBST(root.left) )
                return false;
        }

    if(root.val <= max){
            return false;
        }
        max = (long)root.val;

    if(root.right !=null){
            if(! isValidBST(root.right) )
                return false;
        }
        return true;
    }
}
