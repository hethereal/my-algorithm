"""
链表相关算法
"""


class ListNode:
    """
    链表定义
    """
    def __init__(self, data=None):
        self.data = data,
        self.next = None,

def reverse(head):
    """
    单链表反转
    :param head: 头节点
    :return: 新的头节点
    """
    pre = None
    while head is not None:
        n = head.next
        head.next = pre
        pre = head
        head = n
    return pre


def merge_two_lists(head1, head2):
    """
    合并两个升序链表
    :param head1:
    :param head2:
    :return:
    """
    if head1 is None or head2 is None:
        return head2 if head1 is None else head1
    head = head1 if head1.data <= head2.data else head2
    cur1 = head
    cur2 = head2 if head is head1 else head1
    prev = head
    while cur1 is not None and cur2 is not None:
        if cur1.data <= cur2.data:
            prev.next = cur1
            cur1 = cur1.next
        else:
            prev.next = cur2
            cur2 = cur2.next
        prev = prev.next
    prev.next = cur2 if cur1 is None else cur1
    return head



class DoubleListNode:
    """
    双链表
    """
    def __init__(self, last=None, next_node=None, data=None):
        self.next = next_node
        self.last = last
        self.data = data


def reverse_double_list(head):
    """
    双链表反转
    :param head: 头节点
    :return:
    """
    pre = None
    while head is not None:
        next_node = head.next
        head.next = pre
        head.last = next_node
        pre = head
        head = next_node
    return pre