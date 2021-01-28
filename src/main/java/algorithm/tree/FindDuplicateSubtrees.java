package algorithm.tree;

//给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
//
// 两棵树重复是指它们具有相同的结构以及相同的结点值。
//
// 示例 1：
//
//         1
//       / \
//      2   3
//     /   / \
//    4   2   4
//       /
//      4
//
//
// 下面是两个重复的子树：
//
//       2
//     /
//    4
//
//
// 和
//
//     4
//
//
// 因此，你需要以列表的形式返回上述重复子树的根结点。
// Related Topics 树


//寻找重复的子树
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
class FindDuplicateSubtrees {
    Map<String, Boolean> dulTree = new HashMap<String, Boolean>();
    List<TreeNode> res = new ArrayList<TreeNode>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        findDuplicateSubtrees(root, res);
        return res;
    }

    public String findDuplicateSubtrees(TreeNode root, List<TreeNode> res){
        if (root == null){
            return "#";
        }
        String left = findDuplicateSubtrees(root.left, res);
        String right = findDuplicateSubtrees(root.right, res);
        String s = root.val + "," + left + "," + right;
        if (dulTree.containsKey(s)){
            if (dulTree.get(s).equals(false)){
                dulTree.put(s, true);
                res.add(root);
            }
        } else {
            dulTree.put(s, false);
        }
        return s;
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

