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
            head.next = pre;
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


    /**
     * 链表合并
     */
    public static ListNode mergeList(ListNode list1, ListNode list2)
    {
        //判断两个链表不为空
        if (list1 == null || list2 == null) return list1 == null ? list2 : list1;

        //确定总的头部
        ListNode head = list1.value <= list2.value ? list1 : list2;
        //current1指向 总头部的下一个节点
        ListNode cur1 = head.next;
        //cur2指向 另一个链表的头部
        ListNode cur2 = head == list1 ? list2 : list1;
        //pre 总是指向 已经挂好的节点
        ListNode pre = head;
        //如果cur1或cur2中某一个指向了null，就说明这条链表已经都挂完了
        while (cur1 != null && cur2 != null)
        {
            //两个节点指相等，默认挂cur1
            if (cur1.value <= cur2.value)
            {
                //当前挂好的节点的next指向已经比较完的这个节点
                pre.next = cur1;
                //cur1变为自己当前节点的下一个节点
                cur1 = cur1.next;
            } else
            {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            //pre.next是已经挂载好的节点，pre变为这个节点
            pre = pre.next;
        }
        //两个链表比较完后，如果还有剩余的，直接接在后面
        pre.next = cur1 != null ? cur1 : cur2;
        return head;
    }
}
