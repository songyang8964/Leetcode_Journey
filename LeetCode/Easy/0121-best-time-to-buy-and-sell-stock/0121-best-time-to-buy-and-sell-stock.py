class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        
        if len(prices) <= 1:
            return 0

        left = 0    # 买入日
        right = 1   # 卖出日
        max_profit = 0

        while right < len(prices):

            if prices[right] > prices[left]:
                # 今天卖出有利润，计算并更新
                profit = prices[right] - prices[left]
                max_profit = max(max_profit, profit)
            else:
                # 今天价格更低，换成更便宜的买入点
                left = right

            right += 1

        return max_profit