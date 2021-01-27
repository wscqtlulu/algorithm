package algorithm.tree;

//根据一棵树的前序遍历与中序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// Related Topics 树 深度优先搜索 数组


//从前序与中序遍历序列构造二叉树
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashSet;
import java.util.Set;

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
class PreBuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length < 1){
            return null;
        }
        TreeNode root = buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder,
                              int preStart, int preEnd,
                              int inStart, int inEnd){
        if (preEnd < preStart || inEnd < inStart){
            return null;
        }
        int first = preorder[preStart];
        TreeNode node = new TreeNode(first);
        int inIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (first == inorder[i]){
                inIndex = i;
                break;
            }
        }
        if (inIndex == -1){
            return null;
        }

        int inLS = inStart;
        int inLE = inIndex - 1;
        int inRS = inIndex + 1;
        int inRE = inEnd;

        int preLS = preStart + 1;
        int preLE = (inIndex - inStart) + preStart;
        int preRS = preLE + 1;
        int preRE = preEnd;

        node.left = buildTree(preorder, inorder, preLS, preLE, inLS, inLE);
        node.right = buildTree(preorder, inorder, preRS, preRE, inRS, inRE);

        return node;
    }
    class TreeNode {
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

