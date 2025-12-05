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
    int minAnswer = Integer.MAX_VALUE;
    int currentDepth = 0;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        backtracking(root);
        return minAnswer;
    }

    private void backtracking(TreeNode node) {
        // 确定递归终止条件
        if(node == null){
            return;
        }
        currentDepth = currentDepth + 1;
        if(node.left == null && node.right == null){
            minAnswer = Math.min(minAnswer, currentDepth);
        }
        if(currentDepth < minAnswer){
            backtracking(node.left);
            backtracking(node.right);
        }
        currentDepth = currentDepth -1;
    }
}