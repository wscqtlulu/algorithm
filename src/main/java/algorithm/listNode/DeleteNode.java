package algorithm.listNode;

//请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
//
//
//
// 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
//
//
//
//
//
// 示例 1：
//
// 输入：head = [4,5,1,9], node = 5
//输出：[4,1,9]
//解释：给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
//
//
// 示例 2：
//
// 输入：head = [4,5,1,9], node = 1
//输出：[4,5,9]
//解释：给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
//
//
//
//
// 提示：
//
//
// 链表至少包含两个节点。
// 链表中所有节点的值都是唯一的。
// 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
// 不要从你的函数中返回任何结果。
//
// Related Topics 链表
// 👍 871 👎 0


//删除链表中的节点
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class DeleteNode {
    /**
     * 只给定删除节点，如何删除掉该删除节点
     * @param node
     */
    public void deleteNode(ListNode node) {
        //将删除节点的值变为下一个节点的值
        node.val = node.next.val;
        //当前node节点相当于删除节点的下一个节点，更新node的next，相当于直接跳过原删除节点的下一个节点
        node.next = node.next.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

