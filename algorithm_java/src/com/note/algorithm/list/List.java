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

    /**
     * 两个链表相加
     *
     */
    public static ListNode addTwoNumbers(ListNode h1, ListNode h2)
    {
        //头节点和指向当前节点的游标
        ListNode ans = null, cur = null;
        //存储进位
        int carry = 0;
        //利用for循环遍历两个链表
        for (int sum, val; h1 != null || h2 != null;
             h1 = h1 == null ? null : h1.next,
             h2 = h2 == null ? null : h2.next
        )
        {
            //计算两个节点相加的和
            sum = (h1 == null ? 0 : h1.value)
                    + (h2 == null ? 0 : h2.value)
                    + carry;
            //获取 个位数 及 进位
            val = sum % 10;
            carry = sum / 10;
            //ans为null说明现在还没有节点，
            // 创建一个新节点将值存进去，并将游标指向这个节点
            if (ans == null)
            {
                ans = new ListNode(val);
                cur = ans;
            } else
            //否则说明已经有头节点了，那么值直接往后面挂载
            {
                cur.next = new ListNode(val);
                cur = cur.next;
            }
        }
        //循环完事之后看看是不是还有进位
        if (carry == 1)
            cur.next = new ListNode(1);
        //最后将头节点返回
        return ans;
    }

    /**
     * 分隔链表
     */
    public static ListNode partition(ListNode head, int x)
    {
        // < 的区域
        ListNode leftHead = null, leftTail = null;
        // >= 的区域
        ListNode rightHead = null, rightTail = null;
        //用于记录头节点下一个节点，用于跳转
        ListNode next = null;
        //头节点用于遍历，当head为null则链表遍历完毕
        while (head != null)
        {
            //记录下一个节点
            next = head.next;
            //将当前节点断连
            head.next = null;
            //判断小于x的区域
            if (head.value < x) {
                //如果leftHead为null，说明还没有挂过值，将head挂载上去；
                // leftHead就不动了
                if (leftHead == null) leftHead = head;
                //否则将该节点挂载到之前那个挂载好的节点的后面
                else leftTail.next = head;
                //将leftTail设置为当前节点
                leftTail = head;
            } else {
                if (rightHead == null) rightHead = head;
                else rightTail.next = head;
                rightTail = head;
            }
            //移动到下一个节点
            head = next;
        }
        if (leftHead == null) return rightHead;
        leftTail.next = rightHead;
        return leftHead;
    }

}
