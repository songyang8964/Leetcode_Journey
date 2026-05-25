class Solution:
    def get_next(self, num: int) -> int:
        total = 0
        while num > 0:
            digit = num%10 #拿个位数
            total = total + digit*digit
            num = num // 10
        return total

    def isHappy(self, n: int) -> bool:
        seen = set()
        while n != 1:
            if n in seen:
                return False
            seen.add(n)
            n = self.get_next(n)
        return True

        