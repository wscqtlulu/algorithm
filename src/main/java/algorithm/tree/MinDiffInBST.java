package algorithm.tree;

//给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
//
// 注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bs
//t/ 相同
//
//
//
//
//
// 示例 1：
//
//
//输入：root = [4,2,6,1,3]
//输出：1
//
//
// 示例 2：
//
//
//输入：root = [1,0,48,null,null,12,49]
//输出：1
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [2, 100] 内
// 0 <= Node.val <= 105
// 差值是一个正数，其数值等于两值之差的绝对值
//
//
//
// Related Topics 树 深度优先搜索 递归


//二叉搜索树节点最小距离
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
class MinDiffInBST {
    int res = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        deal(root);
        return res;
    }

    public void deal(TreeNode root){
        if (root != null) {
            if (root.left != null) {
                res = Math.min(root.val - findRight(root.left).val, res);
                deal(root.left);
            }
            if (root.right != null) {
                res = Math.min(findLeft(root.right).val - root.val, res);
                deal(root.right);
            }
        }
    }

    public TreeNode findLeft(TreeNode node){
        if (node.left != null) {
            return findLeft(node.left);
        }
        return node;
    }

    public TreeNode findRight(TreeNode node){
        if (node.right != null) {
            return findRight(node.right);
        }
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

