class Solution {
    public int integerBreak(int n) {
        // 1. 定义 dp 数组
        // 大小为 n + 1，是因为我们需要下标 i 能取到 n
        // 初始值 Java 默认为 0
        int[] dp = new int[n + 1];

        // 2. 初始化
        // dp[0] 和 dp[1] 没有意义，因为题目要求 n >= 2 且拆分出正整数
        // dp[2] 的结果是 1 (1*1)，可以在循环中计算，也可以预设
        dp[2] = 1;

        // 3. 外层循环：从 3 开始计算每个数字 i 的最大乘积，直到 n
        for (int i = 3; i <= n; i++) {

            // 4. 内层循环：尝试每一个可能的拆分点 j
            // j 代表拆分出的第一个数。
            // j 的范围从 1 到 i-1 (实际上 j <= i/2 即可，因为对称)
            for (int j = 1; j < i; j++) {

                // 关键逻辑解释：
                // j * (i - j):  代表 i 被拆分成 j 和 (i-j) 两部分，且 (i-j) 不再拆分
                // j * dp[i - j]: 代表 i 被拆分成 j 和 (i-j)，且 (i-j) 继续拆分（使用之前的最优解）

                // 第一步：比较“不继续拆”和“继续拆”哪个更大
                int currentMax = Math.max(j * (i - j), j * dp[i - j]);

                // 第二步：将当前切分 j 得到的结果，与之前尝试其他 j 得到的 dp[i] 比较，保留最大值
                dp[i] = Math.max(dp[i], currentMax);
            }
        }

        // 5. 返回结果
        return dp[n];
    }
}