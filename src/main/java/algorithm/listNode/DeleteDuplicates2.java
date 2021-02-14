package algorithm.listNode;

//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
//
// 示例 1:
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
//
//
// 示例 2:
//
// 输入: 1->1->1->2->3
//输出: 2->3
// Related Topics 链表


//删除排序链表中的重复元素2
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
class DeleteDuplicates2 {
    public ListNode deleteDuplicates(ListNode head) {
        head = deleteHeadDuplicates(head);
        deleteInDuplicates(head);
        return head;
    }

    public ListNode deleteHeadDuplicates(ListNode head){
        //处理开头的重复元素
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val != head.next.val){
            return head;
        }
        while (head.next != null && head.val == head.next.val){
            head = head.next;
        }
        if (head.next == null) {
            return null;
        }
        head = head.next;
        return deleteHeadDuplicates(head);
    }

    public void deleteInDuplicates(ListNode head){
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode cur = head;
        ListNode next1 = cur.next;
        ListNode next2 = cur.next.next;
        if (next1.val == next2.val){
            while (next2 != null && next1.val == next2.val) {
                next2 = next2.next;
            }
            cur.next = next2;
        } else {
            cur = cur.next;
        }
        deleteInDuplicates(cur);
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

