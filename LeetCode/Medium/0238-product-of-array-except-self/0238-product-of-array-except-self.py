class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)

        # 初始化 answer 数组，全部填 1
        answer = [1] * n

        # ── 第一步：从左到右，计算前缀积 ──
        # prefix 表示当前位置左边所有元素的乘积
        prefix = 1
        for i in range(n):
            answer[i] = prefix        # 先把当前 prefix 存入 answer[i]
            prefix = prefix * nums[i] # 再把 nums[i] 乘进 prefix，供下一个位置用

        # ── 第二步：从右到左，计算后缀积，乘进 answer ──
        # suffix 表示当前位置右边所有元素的乘积
        suffix = 1
        for i in range(n - 1, -1, -1):
            answer[i] = answer[i] * suffix  # 当前前缀积 × 当前后缀积
            suffix = suffix * nums[i]       # 再把 nums[i] 乘进 suffix，供下一个位置用

        return answer

            
            
        