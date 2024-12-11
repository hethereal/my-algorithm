package com.note.algorithm.list;

/**
 * 单双链表
 */
public class List
{
    /**
     * 单链表
     */
    static class ListNode
    {
        public int value;
        public ListNode next;

        public ListNode(int value)
        {
            this.value = value;
        }

        public ListNode(int value, ListNode next)
        {
            this.value = value;
            this.next = next;
        }
    }


    /**
     * 单链表反转
     * @param head 头节点
     * @return
     */
    public static ListNode reverseList(ListNode head)
    {
        ListNode pre = null;
        ListNode next = null;
        while (head != null)
        {
            next = head.next;
            pre = head;
            head = next;
        }
        return pre;
    }


    /**
     * 双链表
     */
    static class DoubleListNode
    {
        public int value;
        public DoubleListNode last;
        public DoubleListNode next;

        public DoubleListNode(int value)
        {
            this.value = value;
        }
    }

    /**
     * 双链表反转
     */
    public static DoubleListNode reverseDoubleList(DoubleListNode head)
    {
        DoubleListNode pre = null;
        DoubleListNode next = null;
        while (head != null)
        {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}
