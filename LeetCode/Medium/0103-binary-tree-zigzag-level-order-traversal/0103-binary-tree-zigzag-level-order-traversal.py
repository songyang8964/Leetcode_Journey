# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        # 用一个布尔变量 left_to_right 记录当前层的方向，每层结束后取反。当方向是从右到左时，把 level 列表翻转再加入结果。
        if not root:
            return[]

        result = []
        queue = deque([root])
        left_to_right = True

        while queue:
            size = len(queue)
            level = []
            for _ in range(size):
                node = queue.popleft()
                level.append(node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            if left_to_right:
                result.append(level)
            else:
                result.append(level[::-1])
            left_to_right = not left_to_right
        return result
            


        