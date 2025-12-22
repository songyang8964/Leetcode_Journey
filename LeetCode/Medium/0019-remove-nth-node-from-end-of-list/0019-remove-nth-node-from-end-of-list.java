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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 1. 创建哑结点，指向 head。
        // 这样可以处理删除头结点的情况 (例如: List: [1], n=1)
        ListNode dummy = new ListNode(0, head);
        
        // 2. 初始化快慢指针，都指向哑结点
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        // 3. 让 fast 先移动 n+1 步
        // 为什么是 n+1？因为我们需要让 slow 停在待删除结点的"前一个"位置。
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        
        // 4. 同时移动 fast 和 slow，直到 fast 指向 null (链表末尾)
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // 5. 此时 slow 指向待删除结点的前驱。执行删除操作。
        // slow.next 是待删除结点，slow.next.next 是待删除结点的下一个结点。
        slow.next = slow.next.next;
        
        // 6. 返回哑结点的下一个结点作为新的头结点
        return dummy.next;
    }
}