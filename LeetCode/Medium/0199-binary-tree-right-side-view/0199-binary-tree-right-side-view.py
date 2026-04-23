# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []

        result = []
        queue = deque([root])
        while queue:
            level = []
            size = len(queue)
            for i in range(size):
                node = queue.popleft()
                level.append(node.val)
                if node.left:
                    # 队列里永远只传node
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            # 当 for 循环结束时，当前层已经全部处理完。
            # 此时 level 数组里存着当前层从左到右所有的值（比如 [2, 3]）
            # 我们只需要拿到最后一个值（最右边），放进 result 中。
            result.append(level[-1])
        return result