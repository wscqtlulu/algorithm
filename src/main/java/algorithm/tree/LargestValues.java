package algorithm.tree;

//您需要在二叉树的每一行中找到最大的值。
//
// 示例：
//
//
//输入:
//
//          1
//         / \
//        3   2
//       / \   \
//      5   3   9
//
//输出: [1, 3, 9]
//
// Related Topics 树 深度优先搜索 广度优先搜索


//在每个树行中找最大值
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

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
class LargestValues {
    ArrayList<Integer> list = new ArrayList<Integer>();
    public List<Integer> largestValues(TreeNode root) {
        if (root != null){
            list.add(root.val);
            deal(1, root.left);
            deal(1, root.right);
        }
        return list;
    }

    public void deal(int level, TreeNode root){
        if (root != null) {
            if (level >= list.size()){
                list.add(root.val);
            } else {
                if (root.val > list.get(level)) {
                    list.set(level, root.val);
                }
            }
            level++;
            deal(level, root.left);
            deal(level, root.right);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

