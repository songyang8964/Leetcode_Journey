class Solution {
    public int[] sortArray(int[] nums) {
        if(nums == null || nums.length < 2){
            return nums;
        }
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
        return nums;
        
    }
    void mergeSort (int[] nums, int l, int r, int[] temp){
        if(l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
         mergeSort(nums, l, mid, temp );
         mergeSort(nums, mid+1, r, temp);
         merge(nums, l, mid, r, temp);
    }
    void merge(int[] nums, int left, int mid, int right, int[] temp){
        System.arraycopy(nums, left, temp, left, right - left + 1);
        int i = left;
        int j = mid + 1;
        int k = left;
        while(i <= mid && j <= right ){
            if(temp[i] < temp[j]){
                nums[k] = temp [i];
                i++;
                k++;
            }else{
                nums[k] = temp [j];
                j++;
                k++;
            }
            
        }
        while( i <= mid){
            nums[k] = temp[i];
            k++;
            i++;
        }
        while(j <= right){
            nums[k] = temp[j];
            k++;
            j++;
        }
    }
}