package algorithm.greedy;

//给定一个二叉树，我们在树的节点上安装摄像头。
//
// 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
//
// 计算监控树的所有节点所需的最小摄像头数量。
//
//
//
// 示例 1：
//
//
//
// 输入：[0,0,null,0,0]
//输出：1
//解释：如图所示，一台摄像头足以监控所有节点。
//
//
// 示例 2：
//
//
//
// 输入：[0,0,null,0,null,0,null,null,0]
//输出：2
//解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
//
//
//
//提示：
//
//
// 给定树的节点数的范围是 [1, 1000]。
// 每个节点的值都是 0。
//
// Related Topics 树 深度优先搜索 动态规划 二叉树
// 👍 320 👎 0


//监控二叉树
//leetcode submit region begin(Prohibit modification and deletion)

import algorithm.tree.TreeNode;

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
class MinCameraCover {
    int res = 0;
    //0未覆盖；1有摄像头；2已覆盖
    public int minCameraCover(TreeNode root) {
        if (deal(root) == 0) {
            res++;
        }
        return res;
    }
    private int deal(TreeNode node){
        if (node == null) {
            return 2;
        }
        int left = deal(node.left);
        int right = deal(node.right);
        if (left == 0 || right == 0) {
            res++;
            return 1;
        } else if (left == 2 && right == 2) {
            return 0;
        } else {
            return 2;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

