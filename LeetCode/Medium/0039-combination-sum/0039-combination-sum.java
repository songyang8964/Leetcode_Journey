class Solution {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 为了优化（剪枝），先对数组进行排序
        // 排序后，如果加一个数这就超标了，那后面更大的数肯定也超标，可以直接停止
        Arrays.sort(candidates);
        // 2. 开启递归
        // 参数解释：数组，目标值，当前累加和(0)，开始索引(0)
        backtrack(candidates, target, 0, 0);

        return res;
    }

    private void backtrack(int[] candidates, int target, int sum, int startIndex) {
        // edge case
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (sum + candidates[i] <= target) {
                path.add(candidates[i]);
                sum += candidates[i];
                // 可以重复选取，所以这里startIndex = i
                backtrack(candidates, target, sum, i);
                sum -= candidates[i];
                path.remove(path.size() - 1);
            }
        }
    }
}