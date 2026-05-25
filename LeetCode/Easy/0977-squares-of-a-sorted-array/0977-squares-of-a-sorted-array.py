class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = [0]*n
        left = 0
        right = n - 1
        p = n - 1
        while left <= right:
            if abs(nums[left]) > abs(nums[right]):
                result[p] = nums[left] * nums[left]
                left += 1
            else:
                result[p] = nums[right] * nums[right]
                right -= 1
            p -= 1
        return result
