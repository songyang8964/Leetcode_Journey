class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        window = {}
        left,right,length = 0,0,0
        while right < len(s):
            # add s[right] 
            c = s[right]
            window[c] = window.get(c,0) + 1 # c 出现的频率
            right += 1
            while window[c] > 1:
                d = s[left]
                left += 1
                window[d] -= 1
            length = max(length, right - left)
        return length
        