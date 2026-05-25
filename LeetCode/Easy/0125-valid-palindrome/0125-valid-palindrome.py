class Solution:
    def isPalindrome(self, s: str) -> bool:
        filter =[]
        for c in s:
            if c.isalnum():
                filter.append(c.lower())

        s = ''.join(filter)
        left, right = 0, len(s) - 1
        while left < right:
            if s[left] != s[right]:
                return False
            left += 1
            right -= 1
        return True
        