/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    private TreeNode result = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        // Java不许在一个方法内定义另一个方法, 只能调用，所以不能写变量类型，写了变量类型就是在定义!
        traversal(root, p, q);
        return result;
    }

    private void traversal(TreeNode cur, TreeNode p, TreeNode q) {
        if (p.val < cur.val && q.val < cur.val) {
            traversal(cur.left, p, q);
        }
        else if (p.val > cur.val && q.val > cur.val) {
            traversal(cur.right, p, q);
        } else{
            result = cur;
        }
        
    }
}