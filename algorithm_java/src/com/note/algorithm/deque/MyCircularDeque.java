package com.note.algorithm.deque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 设计实现双端队列
 */
public class MyCircularDeque
{
    /**
     * 使用Java原生API
     */
    static class MyCircularDeque01
    {
        public Deque<Integer> deque = new LinkedList<>();
        public int size;
        public int limit;

        public MyCircularDeque01(int k)
        {
            size = 0;
            limit = k;
        }

        public boolean insertFront(int value)
        {
            if (isFull())
                return false;
            else {
                deque.offerFirst(value);
                size++;
                return true;
            }
        }

        public boolean insertLast(int value)
        {
            if (isFull())
                return false;
            else {
                deque.offerLast(value);
                size++;
                return true;
            }
        }

        public boolean deleteFront()
        {
            if (isEmpty())
                return false;
            else {
                size--;
                deque.pollFirst();
                return true;
            }
        }

        public boolean deleteLast()
        {
            if (isEmpty())
                return false;
            else {
                size--;
                deque.pollLast();
                return true;
            }
        }

        public int getFront()
        {
            if (isEmpty())
                return -1;
            else {
                return deque.peekFirst();
            }
        }

        public int getRear()
        {
            if (isEmpty())
                return -1;
            else {
                return deque.peekLast();
            }
        }

        public boolean isEmpty()
        {
            return size == 0;
        }

        public boolean isFull()
        {
            return size == limit;
        }
    }

    /**
     * 第二个方式：自己用数组实现，常数操作快，但LeetCode数据量太小，看不出优势
     */
    static class MyCircularDeque02
    {
        public int[] deque;
        public int l, r, size, limit;

        public MyCircularDeque02(int k)
        {
            limit = k;
            l = r = size = 0;
            deque = new int[k];
        }

        public boolean insertFront(int value)
        {
            if (isFull())
                return false;
            else {
                if (isEmpty()) {
                    l = r = 0;
                    deque[0] = value;
                } else {
                    l = l == 0 ? (limit - 1) : (l - 1);
                    deque[l] = value;
                }
                size++;
                return true;
            }
        }

        public boolean insertLast(int value)
        {
            if (isFull())
                return false;
            else {
                if (isEmpty()) {
                    l = r = 0;
                    deque[0] = value;
                } else {
                    r = r == limit - 1 ? 0 : r + 1;
                    deque[r] = value;
                }
                size++;
                return true;
            }
        }

        public boolean deleteFront()
        {
            if (isEmpty())
                return false;
            else {
                l = (l == limit - 1) ? 0 : l + 1;
                size--;
                return true;
            }
        }

        public boolean deleteLast()
        {
            if (isEmpty()) {
                return false;
            } else {
                r = r == 0 ? limit - 1 : r - 1;
                size--;
                return true;
            }
        }

        public int getFront()
        {
            if (isEmpty()) return -1;
            else return deque[l];
        }

        public int getRear()
        {
            if (isEmpty()) return -1;
            else return deque[r];
        }

        public boolean isEmpty()
        {
            return size == 0;
        }

        public boolean isFull()
        {
            return size == limit;
        }
    }
}
