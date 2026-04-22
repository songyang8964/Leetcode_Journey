# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        self.maxDiameter = 0
        self.maxDepth(root)

        return self.maxDiameter

    def maxDepth(self, root):
        if root is None:
            return 0
        leftMax = self.maxDepth(root.left)
        rightMax = self.maxDepth(root.right)
        # 只有在 maxDepth 里，才同时拥有 leftMax 和 rightMax
        currentDiameter = leftMax + rightMax
        self.maxDiameter = max(self.maxDiameter, currentDiameter)

        return 1 + max(leftMax, rightMax)

        

        