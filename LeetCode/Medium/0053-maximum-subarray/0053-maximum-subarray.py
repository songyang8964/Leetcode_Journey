

class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        n = len(nums)

        dp_max = [0] * n
        dp_max[0] = nums[0]

        for i in range(1, n):
            dp_max[i] = max(nums[i], dp_max[i -1] + nums[i])

        return max(dp_max)

        