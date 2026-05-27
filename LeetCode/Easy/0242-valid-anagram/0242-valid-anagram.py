class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        map = {}
        for i in s:
            map[i] = map.get(i, 0) + 1

        for j in t:
            if j not in map:
                return False
            else:
                map[j] -= 1
        for v in map.values():
            if v != 0:
                return False
        return True