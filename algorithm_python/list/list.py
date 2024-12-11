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