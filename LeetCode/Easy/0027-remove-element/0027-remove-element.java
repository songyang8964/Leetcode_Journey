class Solution {
    int slow = 0;

    public int removeElement(int[] nums, int val) {
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        // slow为移除元素后数组的长度
        return slow;
    }
}