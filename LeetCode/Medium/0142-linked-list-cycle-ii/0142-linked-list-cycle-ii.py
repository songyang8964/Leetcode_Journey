# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # 环的入口：链表中第一个会被重复访问的节点，也就是某个节点的 next 指针指回来的目标节点。
        fast, slow = head, head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
            if fast == slow:
                break
        # 上面的代码类似 hasCycle 函数
        if fast == None or fast.next == None:
            # fast 遇到空指针说明没有环
            return None
        
        # 重新指向头结点
        slow = head
        # 快慢指针同步前进，相交点就是环起点
        while slow != fast:
            fast = fast.next
            slow = slow.next
        return slow
        