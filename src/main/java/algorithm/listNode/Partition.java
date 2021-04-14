package algorithm.listNode;

//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
//
// 你应当 保留 两个分区中每个节点的初始相对位置。
//
//
//
// 示例 1：
//
//
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
//
//
// 示例 2：
//
//
//输入：head = [2,1], x = 2
//输出：[1,2]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 200] 内
// -100 <= Node.val <= 100
// -200 <= x <= 200
//
// Related Topics 链表 双指针
// 👍 366 👎 0


//分隔链表
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
class Partition {
    public ListNode partition(ListNode head, int x) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode listNode1 = head;
        ListNode listNode2 = head.next;
        while (listNode2 != null) {
            if (listNode1.val < x) {
                if (listNode2.val >= x) {
                    break;
                } else {
                    listNode2 = listNode2.next;
                    listNode1 = listNode1.next;
                }
            } else {
                if (listNode2.val >= x) {
                    if (listNode2.next == null) {
                        break;
                    } else if (listNode2.next.val >= x){
                        listNode2 = listNode2.next;
                    } else {
                        ListNode newHead = listNode2.next;
                        listNode2.next = listNode2.next.next;
                        newHead.next = listNode1;
                        listNode1 = newHead;
                        listNode2 = newHead.next;
                        head = listNode1;
                        break;
                    }
                } else {
                    listNode1.next = listNode2.next;
                    listNode2.next = listNode1;
                    listNode1 = listNode2;
                    listNode2 = listNode1.next;
                    head = listNode1;
                    break;
                }
            }
        }
        if (listNode2 == null) {
            return head;
        }
        deal(listNode1, listNode2, x);
        return head;
    }
    public void deal(ListNode listNode1, ListNode listNode2, int x){
        if (listNode2.next == null) {
            return;
        } else {
            if (listNode2.next.val < x) {
                ListNode n1 = listNode1.next;
                listNode1.next = listNode2.next;
                listNode2.next = listNode2.next.next;
                listNode1.next.next = n1;
                deal(listNode1.next, listNode2, x);
            } else {
                deal(listNode1, listNode2.next, x);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


