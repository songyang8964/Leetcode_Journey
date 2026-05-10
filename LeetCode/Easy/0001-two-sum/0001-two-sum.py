class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        seen = {}
        for i in range(len(nums)):
            x = nums[i]
            complement = target - x
            if complement in seen:
                return [seen[complement], i]
            seen[x] = i
        return []
        