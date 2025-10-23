class Solution {
    public void moveZeroes(int[] nums) {
        List<Integer> nonZeroElements = new ArrayList<>();
        for(int i = 0; i <= nums.length - 1; i++ ){
            if(nums[i] != 0){
                nonZeroElements.add(nums[i]);
            }
        }
        for(int i = 0; i < nonZeroElements.size(); i++ ){
            nums[i] = nonZeroElements.get(i);
        }
        for(int i = nonZeroElements.size(); i < nums.length; i++){
            nums[i] = 0;
        }
    }
}