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
    public int findBottomLeftValue(TreeNode root) {
            if (root == null) {
            return 0;
        }
        List<List<TreeNode>> results = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<TreeNode> currentLevel = new LinkedList<TreeNode>();
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                size--;
                currentLevel.add(node);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            results.add(currentLevel);
        }
        List<TreeNode> treeNodeList = results.get(results.size() - 1);
        return treeNodeList.get(0).val;
        
    }
}