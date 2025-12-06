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
    private int size = 0;
    public int countNodes(TreeNode root) {
        traverse(root);
        return size;
    }

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        size++;
        traverse(node.left);
        traverse(node.right);
    }
        
}