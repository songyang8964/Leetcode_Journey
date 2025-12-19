class Solution {
    int minLength = Integer.MAX_VALUE;
    int left = 0;
    int sum = 0;

    public int minSubArrayLen(int target, int[] nums) {
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            // 注意这里必须是while, 因为可能去掉一个左边的数后, sum依然大于target
            while (sum >= target) {
                // 计算当前数组区间的长度
                int currentLength = right - left + 1;
                // 如果比之前记录的更小, 就更新minLength
                minLength = Math.min(minLength, currentLength);
                // 缩小窗口
                sum = sum - nums[left];
                left++;
            }
        }
        // 处理特殊情况：如果 minLength 还是初始值，说明整个数组加起来都不够 target
        if (minLength == Integer.MAX_VALUE) {
            return 0;
        } else {
            return minLength;
        }
    }
}