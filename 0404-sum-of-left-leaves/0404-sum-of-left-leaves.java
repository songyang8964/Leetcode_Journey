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
    public int sumOfLeftLeaves(TreeNode root) {
                if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0; // 直接累加，不需要 ArrayList 再遍历一遍

        while (!queue.isEmpty()) {
            // 这道题其实不需要分层（不需要 size 循环），
            // 只要把所有节点过一遍就行。
            TreeNode node = queue.poll();

            // --- 核心逻辑开始 ---
            // 判断当前节点的左孩子是不是“左叶子”
            if (node.left != null) {
                // 如果左孩子不为空，检查它是不是叶子
                if (node.left.left == null && node.left.right == null) {
                    // 是左叶子！累加它的值
                    sum += node.left.val;
                } else {
                    // 不是叶子，那就把它加入队列继续找
                    queue.offer(node.left);
                }
            }
            // --- 核心逻辑结束 ---

            if (node.right != null) {
                // 右孩子虽然不可能是左叶子，但它的下面可能有左叶子
                // 所以必须加入队列继续搜
                queue.offer(node.right);
            }
        }
        return sum;
    }
}