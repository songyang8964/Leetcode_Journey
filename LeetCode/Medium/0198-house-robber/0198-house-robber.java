class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int n = nums.length;
        // dp[i] 表示到达下标为i的房子时， 能获得的最大金额

        int prev2 = nums[0];
        int prev1 =  Math.max(nums[0], nums[1]);
        int current = 0;
        for (int i = 2; i < n; i++) {
            current = Math.max(prev1, nums[i] + prev2);
            prev2 = prev1;
            prev1 = current;
        }
        return current;
    }
}