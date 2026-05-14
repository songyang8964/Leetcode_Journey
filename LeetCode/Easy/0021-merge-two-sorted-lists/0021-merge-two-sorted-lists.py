# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(-1)
        P1 = list1
        P2 = list2
        P = dummy

        while P1 is not None and P2 is not None:
            if P1.val > P2.val:
                P.next = P2
                P2 = P2.next
                P = P.next
            else:
                P.next = P1
                P1 = P1.next
                P = P.next
        if P2 is not None:
            P.next = P2
        else:
            P.next = P1
        return dummy.next
         
        