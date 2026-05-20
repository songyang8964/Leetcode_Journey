class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        need = {}
        window = {}
        t = s1
        s = s2
        for c in t:
            need[c] = need.get(c, 0) + 1
        
        left = 0
        right = 0
        valid = 0 # 所需字符串的种类
        while right < len(s):
            c = s[right]
            right +=1
            if c in need:
                window[c] = window.get(c, 0) + 1
                if window[c] == need[c]:
                    valid += 1
            while right - left >= len(t):
                if valid == len(need):
                    return True
                else:
                    d = s[left]
                    left += 1
                    if d in need:
                        if window[d] == need[d]:
                            valid -= 1
                        window[d] -=1
        return False

            



        