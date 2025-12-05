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
       public int maxDepth(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return 0;
        }
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            // 锁定当前队列的大小，代表当前层有多少节点
            int size = queue.size();
            // 只遍历当前层的节点
            while (size > 0) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);
                size --;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(currentLevel);
        }
        int size = result.size();
        return size;
    }
}