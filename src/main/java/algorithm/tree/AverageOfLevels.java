package algorithm.tree;

//给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
//
//
//
// 示例 1：
//
// 输入：
//    3
//   / \
//  9  20
//    /  \
//   15   7
//输出：[3, 14.5, 11]
//解释：
//第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
//
//
//
//
// 提示：
//
//
// 节点值的范围在32位有符号整数范围内。
//
// Related Topics 树


//二叉树的层平均值
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class AverageOfLevels {
    List<Double> res = new ArrayList<Double>();
    //    List<Map<String, Double>> temp = new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            while (queue.size() != 0){
                int l = queue.size();
                double sum = 0;
                for (int i = 0; i < l; i++) {
                    TreeNode node = queue.poll();
                    sum += node.val;
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                res.add(sum/l);
            }
        }
        return res;
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

//    public void deal(TreeNode root, int level){
//        if (root != null) {
//            level++;
//            int index = level - 1;
//            if (level > temp.size()) {
//                Map<String, Double> map = new HashMap<>();
//                map.put("sum", Double.valueOf(root.val));
//                map.put("num", 1d);
//                temp.add(index, map);
//                res.add(index, 0d);
//            } else {
//                Map<String, Double> map = temp.get(index);
//                map.put("sum", map.get("sum") + Double.valueOf(root.val));
//                map.put("num", map.get("num") + 1d);
//                temp.set(index, map);
//            }
//
//            res.set(index, Double.valueOf(temp.get(index).get("sum"))/Double.valueOf(temp.get(index).get("num")));
//            deal(root.left, level);
//            deal(root.right, level);
//        }
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

