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
        // maxDepth定义为极小值, 保证任何深度的节点都能覆盖它
    private int maxDepth = Integer.MIN_VALUE;
    private int result = 0;

    public int findBottomLeftValue(TreeNode root) {
        // 初始深度为0
        traversal(root, 0);
        return result;

    }

    private void traversal(TreeNode node, int depth) {
        if (node.left == null && node.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                result = node.val;
            }
            return;
        }
        if (node.left != null) {
            depth++;
            traversal(node.left, depth);
            depth--;
        }
        if (node.right != null) {
            depth++;
            traversal(node.right, depth);
            depth--;
        }
    }
}