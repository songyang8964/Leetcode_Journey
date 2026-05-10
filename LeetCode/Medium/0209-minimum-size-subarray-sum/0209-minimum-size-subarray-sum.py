class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        if not nums:
            return 0
        left, right = 0, 0
        sum = 0
        min_length = float('inf')
        while right < len(nums):
                sum = sum + nums[right]
                while sum >= target:
                    min_length = min(min_length, right - left + 1)
                    sum = sum - nums[left]
                    left = left + 1
                right = right + 1
        if min_length == float('inf'):
            return 0
        return min_length



        