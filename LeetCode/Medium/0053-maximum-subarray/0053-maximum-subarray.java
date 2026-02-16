class Solution {
    public int maxSubArray(int[] nums) {
        // dp[i] = 以 nums[i] 结尾的最大子数组和（局部的，有约束的）
        //globalMax = 整个数组中所有子数组的最大和（全局的，最终答案）
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int globalMax = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            globalMax = Math.max(globalMax, dp[i]);

        }
        return globalMax;
    }
}