class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int k = 0;
        for ( int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                 nums[k] = nums[i];
                k++;
            }
        }
        for (; k < nums.length; k++){
            nums[k] = 0;
        }
    }
}