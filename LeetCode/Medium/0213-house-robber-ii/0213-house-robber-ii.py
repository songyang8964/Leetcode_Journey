from typing import List

class Solution:
    
    def rob_linear(self, nums: List[int], start: int, end: int) -> int:
        n = len(nums) - 1
        dp = [0] * n
        dp[0] = nums[start]
        dp[1] = max(nums[start], nums[start + 1])
        for i in range(2, n):
            dp[i] = max(dp[i-1], dp[i-2] + nums[start + i])
        return dp[-1]
    
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return max(nums[0], nums[1])
        
        case_A = self.rob_linear(nums, 0, len(nums) - 2)
        case_B = self.rob_linear(nums, 1, len(nums) - 1)
        
        return max(case_B, case_A)