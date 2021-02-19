//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
// 进阶：你能尝试使用一趟扫描实现吗？
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
//
//
// 示例 2：
//
//
//输入：head = [1], n = 1
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [1,2], n = 1
//输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中结点的数目为 sz
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz
//
// Related Topics 链表 双指针
// 👍 1216 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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
class L19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return new ListNode(0);
        }

        // 2 pointer, fast and slow
        ListNode dummy = new ListNode();
        ListNode fast = dummy;
        ListNode slow = dummy;
        dummy.next = head;
        ListNode target = null;
        // first, let fast move n-1 steps
        for(int i=0; i<n; i++) {
            fast = fast.next;
        }
        // second, let slow and fast move till fast.next == null
        // then slow.next would be the target node we want to remove
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        target = slow.next;
        slow.next = target.next;
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
