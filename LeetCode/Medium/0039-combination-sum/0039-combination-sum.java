class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0);
        return res;
    }

    private void backtrack(int[] candidates, int target, int startIndex) {
        // 找到答案
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            // 剪枝：如果当前数已经大于 target，后面更大的数也不用看了
            if (candidates[i] > target) {
                break;
            }

            path.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i);  // target 减小
            path.remove(path.size() - 1);
        }
    }
}