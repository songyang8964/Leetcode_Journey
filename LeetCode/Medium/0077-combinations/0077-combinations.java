class Solution {
        List<List<Integer>> results = new ArrayList<>();
    Stack<Integer> path = new Stack<>();
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k ,1);
        return results;


    }

    public void backtracking(int n, int k, int startIndex) {
        if(path.size() == k){
            results.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.push(i);
            backtracking(n,k,i+1);
            path.pop();

        }
    }
}