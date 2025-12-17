class Solution {
    int i = 0;
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        // 再定义一个指针，指向新数组的最后一个元素
        int finalIndex = nums.length - 1;
        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            if (leftSquare > rightSquare) {
                result[finalIndex] = leftSquare;
                left++;
            } else {
                result[finalIndex] = rightSquare;
                right--;
            }
            finalIndex--;

        }
        return result;
    }
}