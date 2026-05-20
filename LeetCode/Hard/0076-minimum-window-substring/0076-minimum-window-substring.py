class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(s) < len(t):
            return ""
        
        window = {}
        need = {}
        for c in t:
            need[c] = need.get(c, 0) + 1
            # c不存在时：.get 返回 0，然后 0 + 1 = 1，最终设置为 1
            # c存在时：.get 返回当前值，然后 当前值 + 1，最终设置为 当前值 + 1
        left, right = 0, 0
        # valid：当前窗口中，已满足数量要求的字符种类数
        # 当 valid == len(need) 时，窗口合法（覆盖了 t 的所有字符）
        valid = 0

        # start: 当前找到最小合法窗口的起始索引
        start = 0

        length = float('inf')
        # 不断扩展右边界
        while right < len(s):
            c = s[right]
            right +=1
            if c in need:
                window[c] = window.get(c,0) + 1
                if window[c] == need[c]:
                    valid += 1
            
            while valid == len(need):
                if right - left < length:
                    start = left
                    length = right - left
                d = s[left]
                left += 1
                if d in need:
                    if window[d] == need[d]:
                        valid -= 1
                    window[d] -=1
        if length == float('inf'):
            return ""
        else:
            return s[start: start + length]


