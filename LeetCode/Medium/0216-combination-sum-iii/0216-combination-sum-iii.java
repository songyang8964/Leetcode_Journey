class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(n, k, 1);
        return result;

    }

    private void backtracking(int n, int k, int startIndex) {
        if (sum > n) {
            return;
        }
        if (path.size() == k) {
            if (sum == n) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        int Needed = k - path.size();
        for (int i = startIndex; i <= 9 - Needed + 1; i++) {
            path.add(i);
            sum = sum + i;
            backtracking(n, k, i + 1);
            sum = sum - i;
            path.remove(path.size() - 1);
        }
    }
}