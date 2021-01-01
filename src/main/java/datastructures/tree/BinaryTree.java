package datastructures.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author taotao
 * 二叉树
 */
public class BinaryTree {

    public static TreeNode createBinaryTree(LinkedList<Integer> inputList){
        if (inputList == null || inputList.isEmpty()){
            return null;
        }
        Integer node = inputList.removeFirst();
        if (node != null){
            TreeNode treeNode = new TreeNode(node);
            treeNode.leftChild = createBinaryTree(inputList);
            treeNode.rightChild = createBinaryTree(inputList);
            return treeNode;
        } else {
            return null;
        }
    }

    /**
     * 前序遍历
     * @param treeNode
     */
    public static void preOrderTraversal(TreeNode treeNode){
        if (treeNode != null){
            System.out.println(treeNode.data);
            preOrderTraversal(treeNode.leftChild);
            preOrderTraversal(treeNode.rightChild);
        }
    }

    /**
     * 中序遍历
     * @param treeNode
     */
    public static void inOrderTraversal(TreeNode treeNode){
        if (treeNode != null){
            inOrderTraversal(treeNode.leftChild);
            System.out.println(treeNode.data);
            inOrderTraversal(treeNode.rightChild);
        }
    }

    /**
     * 后序遍历
     * @param treeNode
     */
    public static void postOrderTraversal(TreeNode treeNode){
        if (treeNode != null){
            postOrderTraversal(treeNode.leftChild);
            postOrderTraversal(treeNode.rightChild);
            System.out.println(treeNode.data);
        }
    }

    /**
     * 非递归栈实现前序遍历
     * @param root
     */
    public static void preOrderTraversalWithStack(TreeNode root){
        TreeNode treeNode = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (treeNode != null || !stack.isEmpty()){
            while (treeNode != null){
                System.out.println(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            if (!stack.isEmpty()){
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    /**
     * 层级遍历
     * @param root
     */
    public static void levelOrderTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode treeNod = queue.poll();
            System.out.println(treeNod.data);
            if (treeNod.leftChild != null){
                queue.offer(treeNod.leftChild);
            }
            if (treeNod.rightChild != null){
                queue.offer(treeNod.rightChild);
            }
        }
    }

    private static class TreeNode{
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        public TreeNode(int data) {
            this.data = data;
        }

    };

    public static void main(String[] args) {
        LinkedList<Integer> inputData = new LinkedList<Integer>(Arrays.asList(new Integer[]{
                3, 2, 9, null, null, 10, null, null, 8, null, 4
        }));
        TreeNode treeNode = createBinaryTree(inputData);
        System.out.println("前序遍历：");
        preOrderTraversal(treeNode);
        System.out.println("非递归前序遍历：");
        preOrderTraversalWithStack(treeNode);
        System.out.println("中序遍历");
        inOrderTraversal(treeNode);
        System.out.println("后序遍历");
        postOrderTraversal(treeNode);
        System.out.println("层序遍历");
        levelOrderTraversal(treeNode);
    }
}
