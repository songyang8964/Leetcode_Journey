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
        List<List<Integer>> results = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int depth = 0;
    int currentSum = 0;
    boolean found = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
//        if(root == null){
//            return false;
//        }
        traversal(root, targetSum);
        return found;

    }

    private void traversal(TreeNode node, int targetSum) {
        if (node == null || found) {
            return;
        }
        // 前序遍历位置：一进入节点，先把它加入路径
        path.add(node.val);
        currentSum = currentSum + node.val;
        if (node.left == null && node.right == null) {
            if (currentSum == targetSum) {
                results.add(new ArrayList<>(path));
                found = true;
            }
        } else {
            traversal(node.left, targetSum);
            traversal(node.right, targetSum);
        }
        path.remove(path.size() - 1);
        currentSum = currentSum - node.val;
    }
}