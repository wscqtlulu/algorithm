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
        if (head == null) {
            return null;
        }
        ListNode listNode1 = head;
        while (listNode1.next != null) {
            if (listNode1.next.val >= x){
                //listNode1 = listNode1.next;
                ListNode listNode2 = listNode1.next.next;
                ListNode temp = listNode1.next;
                while (listNode2 != null) {
                    if (listNode2.val <= x) {
                        //交换
                        listNode1.next = listNode2;
                        temp.next = listNode2.next;
                        listNode2.next = temp;
                        listNode2 = temp.next;
                        listNode1 = listNode1.next;
                    } else {
                        listNode2 = listNode2.next;
                    }
                }
            } else {
                //当前值>=x，交换
                if (listNode1.val >= x) {
                    //交换
                    ListNode temp = listNode1.next;
                    listNode1.next = temp.next;
                    temp.next = listNode1;
                }
            }
            listNode1 = listNode1.next;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

