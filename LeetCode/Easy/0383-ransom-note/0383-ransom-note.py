class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        if len(ransomNote) > len(magazine):
            return False
        map = {}
        for c in magazine:
            map[c] = map.get(c, 0) + 1
        for c in ransomNote:
            map[c] = map.get(c, 0) - 1
        for v in map.values():
            if v < 0:
                return False
        return True
        