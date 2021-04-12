package algorithm.listNode;

//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
//
//
// 示例 2：
//
//
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 500] 内
// -100 <= Node.val <= 100
// 0 <= k <= 2 * 109
//
// Related Topics 链表 双指针


//旋转链表
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
class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k == 0 || head.next == null) {
            return head;
        }
        ListNode listNode1 = head;
        int size = 0;
        int tempK = k;
        while (tempK != 0) {
            tempK--;
            size++;
            if (listNode1.next == null) {
                if (size == k) {
                    return head;
                }
                tempK = 0;
            } else {
                listNode1 = listNode1.next;
            }
        }
        if (k > size) {
            k = k % size;
            return rotateRight(head, k);
        } else {
            ListNode listNode2 = head;
            while (listNode1.next != null) {
                listNode1 = listNode1.next;
                listNode2 = listNode2.next;
            }
            ListNode newHead = listNode2.next;
            if (newHead == null) {
                return head;
            }
            listNode2.next = null;
            listNode1.next = head;
            return newHead;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

