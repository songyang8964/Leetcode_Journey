class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        squared = [x*x for x in nums]
        squared.sort()
        return squared
