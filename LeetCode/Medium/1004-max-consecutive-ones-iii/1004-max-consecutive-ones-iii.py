class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        wordOneCount = 0
        left, right = 0,0
        result = 0
        while right < len(nums):
            if nums[right] == 1:
                wordOneCount += 1
            right += 1
            while right - left - wordOneCount > k:
                if nums[left] == 1:
                    wordOneCount -= 1
                left += 1
            result = max(result, right - left)
        return result

        