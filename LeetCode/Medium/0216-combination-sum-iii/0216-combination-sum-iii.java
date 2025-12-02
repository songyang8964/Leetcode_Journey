class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(n, k , 0 , 1);
        return result;
    }
        void backtracking(int targetSum, int k, int sum, int startIndex){
        if(sum > targetSum){
            return;
        }
        if(path.size() == k){
            if(sum == targetSum){
                result.add(new ArrayList<>(path));
                return;
            }
        }
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1 ; i++) {
            sum = sum + i;
            path.add(i);
            backtracking(targetSum, k, sum, i+1);
            sum = sum - i;
            path.remove(path.size() - 1);

        }
    }
}