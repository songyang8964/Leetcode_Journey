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
        public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {
            return null;
        }
        int rootValue = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootValue);

        // leave node
        if (postorder.length == 1) {
            return root;
        }
        // identify the delimiterIndex
        int delimiterIndex;
        for (delimiterIndex = 0; delimiterIndex < inorder.length; delimiterIndex++) {
            if (inorder[delimiterIndex] == rootValue) {
                break;
            }
        }
        // 第四步：切割中序数组，得到 中序左数组和中序右数组
        int[] leftInorder = Arrays.copyOfRange(postorder, 0, delimiterIndex);
        int[] rightInorder = Arrays.copyOfRange(inorder, delimiterIndex + 1, inorder.length);
        int leftSize = leftInorder.length;
        // 第五步：切割后序数组，得到 后序左数组和后序右数组
        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, leftSize);
        int[] rightPostorder = Arrays.copyOfRange(postorder, leftSize, postorder.length - 1);
        // 递归构造左右子树
        root.left = buildTree(leftInorder, leftPostorder);
        root.right = buildTree(rightInorder, rightPostorder);
        return root;
    }
}