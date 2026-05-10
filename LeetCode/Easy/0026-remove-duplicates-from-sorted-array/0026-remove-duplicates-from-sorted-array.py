class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if not nums:
            return 0
        if len(nums) == 1:
            return 1
        
        slow = 1
        for fast in range(1,len(nums)):
            if nums[fast - 1] != nums[fast]:
                nums[slow] = nums[fast]
                slow = slow + 1
                
        return slow
                