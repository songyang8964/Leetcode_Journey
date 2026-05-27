class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        # Python 的 set 支持直接用 & 运算符求交集
        return list(set(nums1) & set(nums2))
        