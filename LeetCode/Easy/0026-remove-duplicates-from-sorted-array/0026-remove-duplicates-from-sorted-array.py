class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if not nums:
            return 0
        
        fast, slow = 0, 0
        
        while fast < len(nums):
            if nums[slow] != nums[fast]:
                slow = slow + 1
                nums[slow] = nums[fast]
            fast = fast + 1

        return slow + 1
        