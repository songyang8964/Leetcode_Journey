class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0);
        return res;
    }

    private void backtracking(int[] candidates, int target, int startIndex, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            int num = candidates[i];
            // 逻辑一：剪枝
            // 只有当前和加上这个数字不超过目标值，我们才考虑它
            if (sum + num <= target) {
                // 逻辑二：去重
                // 我们只在两种情况下处理当前数字：
                // 1. i == start：这是当前这一层递归考察的第一个数字（肯定没重复处理过）
                // 2. candidates[i] != candidates[i - 1]：这个数字和前一个不一样
                if (i == startIndex || candidates[i] != candidates[i - 1]) {
                    path.add(num);
                    // 递归进入下一层
                    backtracking(candidates, target, i + 1, sum + num);
                    path.remove(path.size() - 1);
                }
            }
        }
    }
}