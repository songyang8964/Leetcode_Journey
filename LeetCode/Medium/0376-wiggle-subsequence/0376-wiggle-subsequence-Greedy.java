class Solution {
    int count = 1;
    int prevDiff = 0;
    int curDiff = 0;

    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        for (int i = 1; i < nums.length; i++) {
            curDiff = nums[i] - nums[i - 1];
            if (prevDiff <= 0 && curDiff > 0 || prevDiff >= 0 && curDiff < 0) {
                prevDiff = curDiff;
                count++;
            }
        }
        return count;
    }
}