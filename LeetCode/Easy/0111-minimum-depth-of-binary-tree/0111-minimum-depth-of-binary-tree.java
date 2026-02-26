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
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int leftMin = minDepth(root.left);
        int rightMin = minDepth(root.right);
        if(root.left == null) return rightMin + 1;
        if(root.right == null) return leftMin + 1;
        int min = Math.min(leftMin, rightMin) + 1;
        return min;
        
    }
}