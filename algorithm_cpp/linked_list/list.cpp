/**
 * @Author: plato
 * @Date: 2024/12/10
 * 单链表和双链表
 */

/**
 * 单链表
 * @tparam T 泛型参数
 */
template<class T>
class ListNode
{
public:
    T value;
    ListNode* next;

    explicit ListNode(T value) : value(value)
    {}
    ListNode(T value, ListNode<T> *next) : value(value), next(next)
    {}

    ListNode* reverseList(ListNode* head);
};

template<class T>
ListNode<T> *ListNode<T>::reverseList(ListNode* head)
{
    ListNode* pre = nullptr;
    ListNode* ne = nullptr;
    while (head != nullptr)
    {
        ne = head->next;
        head->next = pre;
        pre = head;
        head = ne;
    }
    return pre;
}

/**
 * 双链表
 * @tparam T
 */
template<class T>
class DoubleListNode
{
    T value;
    DoubleListNode* last;
    DoubleListNode* next;

public:
    explicit DoubleListNode(T value) : value(value)
    {}
    DoubleListNode* reverse(DoubleListNode* head);
};

template<class T>
DoubleListNode<T> *DoubleListNode<T>::reverse(DoubleListNode *head)
{
    DoubleListNode* pre = nullptr;
    DoubleListNode* next_node = nullptr;
    while (head != nullptr)
    {
        next_node = head->next;
        head->next = pre;
        head->last = next_node;
        pre = head;
        head = next_node;
    }
    return pre;
}


