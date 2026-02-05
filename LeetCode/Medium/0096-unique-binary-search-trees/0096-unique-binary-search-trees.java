class Solution {
    public int numTrees(int n) {
        if (n <= 1) return 1;  // n=0 或 n=1 时，直接返回 1
        if (n == 2) return 2;  // n=2 时，直接返回 2
        // 创建了一个长度为 `n+1` 的数组
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // 左子树：j-1 个节点
                // 右子树：i-j 个节点
                // 这种情况的数量 = dp[j-1] × dp[i-j]
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}