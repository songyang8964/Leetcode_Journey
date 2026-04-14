# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
            # 边界处理：链表为空或只有一个节点，不需要重排
        if head == None or head.next == None:
            return

        # ── 第一步：找中间节点 ────────────────────────────────
        slow = head
        fast = head

        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next

        # slow 现在在中间节点
        # 把链表从中间切断
        second_head = slow.next   # 后半段的头节点
        slow.next = None          # 切断前半段和后半段的连接

        # ── 第二步：反转后半段 ────────────────────────────────
        prev = None
        curr = second_head

        while curr != None:
            next_node = curr.next
            curr.next = prev
            prev = curr
            curr = next_node

        # prev 现在是反转后后半段的头节点
        second_head = prev

        # ── 第三步：交替合并两个链表 ──────────────────────────
        p1 = head          # 前半段指针
        p2 = second_head   # 后半段指针

        while p2 != None:
            next1 = p1.next   # 保存前半段的下一个节点
            next2 = p2.next   # 保存后半段的下一个节点

            p1.next = p2      # 前半段当前节点指向后半段当前节点
            p2.next = next1   # 后半段当前节点指向前半段下一个节点

            p1 = next1        # p1 前进
            p2 = next2        # p2 前进