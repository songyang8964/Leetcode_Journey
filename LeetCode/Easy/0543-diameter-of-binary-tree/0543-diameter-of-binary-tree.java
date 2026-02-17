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
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return maxDiameter;
        
    }
    void traverse(TreeNode root ){
        if(root == null){
            return;
        }
        int leftDepthMax = depthMax(root.left);
        int rightDepthMax = depthMax(root.right);
        int curDiameter = leftDepthMax + rightDepthMax;
        maxDiameter = Math.max(curDiameter, maxDiameter);
        traverse(root.left);
        traverse(root.right);


    }
    int depthMax(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftMax = depthMax(root.left);
        int rightMax = depthMax(root.right);
        int depthMax = Math.max(leftMax, rightMax) + 1;
        return depthMax;
    }
}