class Solution:
    def longestPalindrome(self, s: str) -> str:
        start = 0
        max_len = 1
        for i in range(len(s)):
            # 奇数
            left = i
            right = i
            while left >= 0 and right < len(s) and s[left] == s[right]:
                if right - left + 1 > max_len:
                    max_len = right - left + 1
                    start = left
                left -= 1
                right += 1
            left = i
            right = i + 1
            while left >= 0 and right < len(s) and s[right] == s[left]:
                if right - left + 1 > max_len:
                    max_len = right - left + 1
                    start = left
                left -= 1
                right += 1
        return s[start: start + max_len]

          