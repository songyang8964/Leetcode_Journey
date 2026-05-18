# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        dummy = ListNode(-1)
        dummy.next = head

        pre = dummy
        for _ in range(left - 1):
            pre = pre.next
        
        # 记录 successor（第 right+1 个节点）
        right_node = pre
        for _ in range(right - left + 1):
            right_node = right_node.next
        successor = right_node.next

        #  执行部分反转操作
        left_node = pre.next
        right_node.next = None

        prev = None
        curr = left_node
        while curr is not None:
            next_temp = curr.next
            curr.next = prev
            prev = curr
            curr = next_temp
        
        pre.next = prev                # pre 接上新头
        left_node.next = successor     # 新尾接上 successor

        return dummy.next     