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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right; // java只有在第一次声明变量的时候在等号左边写类型， left和right的类型已经在TreeNode定义中写过了
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        
        return root;
    }
}