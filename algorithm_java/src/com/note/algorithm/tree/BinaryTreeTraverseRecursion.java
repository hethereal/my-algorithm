package com.note.algorithm.tree;

/**
 * 二叉树的三种顺序
 */
public class BinaryTreeTraverseRecursion
{

    /**
     * 二叉树定义
     */
    static class TreeNode
    {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }


    /**
     * 先序：
     */
    public static void preOrder(TreeNode head)
    {
        if (head == null)
            return;
        System.out.println(head.val + " ");
        preOrder(head.left);
        preOrder(head.right);
    }

    /**
     * 中序
     */
    public static void inOrder(TreeNode head)
    {
        if (head == null)
            return;
        inOrder(head.left);
        System.out.println(head.val + " ");
        inOrder(head.right);
    }

    /**
     * 后序
     */
    public static void posOrder(TreeNode head)
    {
        if (head == null)
            return;
        posOrder(head.left);
        posOrder(head.right);
        System.out.println(head.val + " ");
    }

}
