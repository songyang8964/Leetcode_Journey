class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        window = set()
        left = 0
        right = 0
        max_length = 0
        while right < len(s):
            if s[right] not in window:
                window.add(s[right])
                max_length = max(max_length, right - left + 1)
                right = right + 1
            else:
                window.remove(s[left])
                left = left + 1
        return max_length

        