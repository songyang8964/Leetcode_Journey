# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
import heapq
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        heap = []

        for i, node in enumerate(lists):
            if node:
                heapq.heappush(heap, (node.val,i, node))

        dummy = ListNode(-1)
        p = dummy
        
        while heap:
            val, i, node = heapq.heappop(heap)
            p.next = node
            p = node
            node = node.next
            if node is not None:
                heapq.heappush(heap, (node.val,i, node))
        
        return dummy.next