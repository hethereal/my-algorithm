package com.note.algorithm.tree;

import java.util.Stack;

/**
 * 二叉树遍历：非递归版
 */
public class BinaryTreeTraverse
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
     * 先序打印：非递归版
     */
    public static void preOrder(TreeNode head)
    {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty())
            {
                head = stack.pop();
                System.out.println(head.val + " ");
                if (head.right != null)
                    stack.push(head.right);
                if (head.left != null)
                    stack.push(head.left);
            }
            System.out.println();
        }
    }


    /**
     * 中序打印：非递归版
     */
    public static void inOrder(TreeNode head)
    {
        if (head != null)
        {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || head != null)
            {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.println(head.val + " ");
                    head = head.right;
                }
            }
        }
    }


    /**
     * 后序打印：非递归版；使用两个栈
     */
    public static void posOrder(TreeNode head)
    {
        if (head != null)
        {
            Stack<TreeNode> stack = new Stack<>();
            Stack<TreeNode> collect = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty())
            {
                head = stack.pop();
                collect.push(head);
                if (head.left != null)
                    stack.push(head.left);
                if (head.right != null)
                    stack.push(head.right);
            }
            while (!collect.isEmpty())
                System.out.print(collect.pop().val + " ");
            System.out.println();
        }
    }

    /**
     * 后序打印：非递归版；使用一个栈
     */
    public static void posOrderOneStack(TreeNode head)
    {
        if (head != null)
        {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty())
            {
                TreeNode cur = stack.peek();
                if (cur.left != null && head != cur.left && head != cur.right)
                {
                    stack.push(cur.left);
                } else if (cur.right != null && head != cur.right)
                {
                    stack.push(cur.right);
                } else
                {
                    System.out.print(cur.val + " ");
                    head = stack.pop();
                }
            }
            System.out.println();
        }
    }

}
