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
    Stack<TreeNode> stack = new Stack<>();
    public void dfs(TreeNode root){
        if(root==null ){
            return ;
        }
        
        dfs(root.left);
        stack.push(root);
        dfs(root.right);
        return ;
    }
    public int kthSmallest(TreeNode root, int k) {
        int element =0;
        dfs(root);
        int count =stack.size();
        while(count-k>0){
            stack.pop();
            count--;
        }
        TreeNode node = stack.peek();
        element = node.val;
        return element;
        
    }
}
