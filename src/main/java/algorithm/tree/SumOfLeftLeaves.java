package algorithm.tree;

//计算给定二叉树的所有左叶子之和。
//
// 示例：
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
//
//
// Related Topics 树


//左叶子之和
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class SumOfLeftLeaves {
    int res = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root != null) {
            if (root.left != null) {
                if (isLeftLeaves(root.left)) {
                    res += root.left.val;
                } else {
                    sumOfLeftLeaves(root.left);
                }
            }
            sumOfLeftLeaves(root.right);
        }
        return res;
    }

    public boolean isLeftLeaves(TreeNode left){
        if (left.left == null && left.right == null) {
            return true;
        } else {
            return false;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

