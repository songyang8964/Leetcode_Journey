class Solution {
    public int removeElement(int[] nums, int val) {
        // 元素删除问题
        // should I keep the order of the elements?
        // how to define the remove? should I keep them at the end of array? or delete them?
        int j = 0;
        for (int i = 0; i < nums.length; i ++){
            if (nums[i] != val){
                int temp = nums [j];
                nums [j] = nums [i];
                nums [i] = temp;
                j++;
            }
           
        }
        return j;

    }
}