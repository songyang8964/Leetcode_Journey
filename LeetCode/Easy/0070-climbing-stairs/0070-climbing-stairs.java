class Solution {
HashMap<Integer, Integer> hashMap = new HashMap<>();
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (hashMap.containsKey(n)) {
            return hashMap.get(n);
        } else {
            int result = climbStairs(n - 1) + climbStairs(n - 2);
            hashMap.put(n, result);
            return result;
        }
    }
}