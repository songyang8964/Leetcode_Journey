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
    public List<Integer> preorderTraversal(TreeNode root) {
        // firstly, we need to define an array to store the result
        List<Integer> result = new ArrayList<>();
        preorder( root, result);
        return result; //返回变量时不需要写类型
    }

    private void preorder(TreeNode root, List<Integer> result){
        if(root == null){
                return; // void 方法直接 return
        }
        result.add(root.val);
        // I recursively call the helper on the left child."
        preorder(root.left, result);
        preorder(root.right, result);
    }
}