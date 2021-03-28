package algorithm.tree;

//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
//
// 示例:
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
//
// Related Topics 树 深度优先搜索 广度优先搜索 递归 队列
// 👍 435 👎 0


//二叉树的右视图
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

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
class RightSideView {
    TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
    public List<Integer> rightSideView(TreeNode root) {
        if (root != null) {
            deal(root, 0);
        }
        List<Integer> res = new ArrayList<Integer>();
        for (Map.Entry entry : map.entrySet()) {
            res.add((Integer) entry.getValue());
        }
        return res;
    }

    public void deal(TreeNode node, int level){
        if (node != null) {
            if (!map.containsKey(level)) {
                map.put(level, node.val);
            }
            deal(node.right, level + 1);
            deal(node.left, level + 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

