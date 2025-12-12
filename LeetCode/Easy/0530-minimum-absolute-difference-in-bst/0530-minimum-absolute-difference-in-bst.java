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
    TreeNode prev = null;
    int minDiff = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        inorderTraversal(root);
        return minDiff;
    }

    private void inorderTraversal(TreeNode curr) {
        if(curr == null){
            return;
        }
        inorderTraversal(curr.left);
        if(prev !=null){
            int currentDiff = curr.val - prev.val;
            minDiff = Math.min(currentDiff, minDiff);
        }
        prev = curr;
        inorderTraversal(curr.right);
    }
}