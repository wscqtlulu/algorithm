package algorithm.tree;

//给定一个二叉树，在树的最后一行找到最左边的值。
//
// 示例 1:
//
//
//输入:
//
//    2
//   / \
//  1   3
//
//输出:
//1
//
//
//
//
// 示例 2:
//
//
//输入:
//
//        1
//       / \
//      2   3
//     /   / \
//    4   5   6
//       /
//      7
//
//输出:
//7
//
//
//
//
// 注意: 您可以假设树（即给定的根节点）不为 NULL。
// Related Topics 树 深度优先搜索 广度优先搜索


//找树左下角的值
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class FindBottomLeftValue {
    int maxLevel = 0;
    int res = 0;
    public int findBottomLeftValue(TreeNode root) {
        if (root != null) {
            res = root.val;
        }
        deal(root, 0);
        return res;
    }

    public void deal(TreeNode root, int level){
        if (root != null) {
            level++;
            if (level > maxLevel) {
                maxLevel = level;
                res = root.val;
            }
            deal(root.left, level);
            deal(root.right, level);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

