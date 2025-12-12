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
    HashMap<Integer, Integer> countMap = new HashMap<>();
    int[] result;

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        traverse(root, countMap);
        int maxCount = 0;
        for (int count : countMap.values()) {
            maxCount = Math.max(maxCount, count);
        }

        List<Integer> resultList = new ArrayList<>();
        for(int key: countMap.keySet()){
            if(countMap.get(key) == maxCount){
                resultList.add(key);
            }
        }
        int[] resultArray = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArray[i] = resultList.get(i);
        }
        return resultArray;

    }
    private void traverse(TreeNode node, Map<Integer, Integer> map){
        if(node == null){
            return;
        }
        // 处理当前节点：在 Map 中更新计数
        // map.getOrDefault(key, 0) 的意思是：如果 key 存在，取它的值；不存在，则默认取 0
        map.put(node.val, map.getOrDefault(node.val, 0) + 1);

        // 递归遍历左子树
        traverse(node.left, map);
        // 递归遍历右子树
        traverse(node.right, map);
    }
}