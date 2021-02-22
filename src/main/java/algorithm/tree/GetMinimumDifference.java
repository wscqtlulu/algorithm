package algorithm.tree;

//给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
//
//
//
// 示例：
//
// 输入：
//
//   1
//    \
//     3
//    /
//   2
//
//输出：
//1
//
//解释：
//最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
//
//
//
//
// 提示：
//
//
// 树中至少有 2 个节点。
// 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
//相同
//
// Related Topics 树


//二叉搜索树的最小绝对差
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
class GetMinimumDifference {
    int res = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if (root != null){
            if (root.left != null) {
                TreeNode lR = getRight(root.left);
                res = Math.min(res, Math.abs(root.val - lR.val));
                getMinimumDifference(root.left);
            }
            if (root.right != null) {
                TreeNode rL = getLeft(root.right);
                res = Math.min(res, Math.abs(root.val - rL.val));
                getMinimumDifference(root.right);
            }
        }
        return res;
    }

    public TreeNode getLeft(TreeNode node){
        if (node.left != null) {
            return getLeft(node.left);
        } else {
            return node;
        }
    }

    public TreeNode getRight(TreeNode node){
        if (node.right != null) {
            return getRight(node.right);
        } else {
            return node;
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

