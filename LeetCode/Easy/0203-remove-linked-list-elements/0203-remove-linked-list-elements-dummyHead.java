/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode cur = dummyNode;
        while (cur.next!=null){
            // 删除之后不要让cur移动，因为下一个节点可能也是要删除的节点，如果这时候让cur移动，可能就跳过这个节点了
            if(cur.next.val == val){
                cur.next = cur.next.next;
            }else {
                cur= cur.next;
            }
        }
        return dummyNode.next;

    }
}