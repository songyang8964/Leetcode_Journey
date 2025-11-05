class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length < 2){
            return false;
        }
        Set<Integer> windows = new HashSet<>();
        int left = 0;
        for(int right = 0; right < nums.length ; right++){
            if(right - left > k){
                windows.remove(nums[left]);
                left++;
            }if(!windows.add(nums[right])){
                return true;
            }
        }
        return false;
    }
}