package com.note.algorithm.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueImpl
{

    /**
     * 队列的第一种实现：使用Java原生API
     */
    static class Queue1
    {
        public Queue<Integer> queue = new LinkedList<>();
        //然后直接使用Java提供的API进行操作即可
    }

    /**
     * 队列的第二种实现：使用数组实现
     */
    static class Queue2
    {
        public int[] queue;
        //左右边界
        public int l;
        public int r;

        //加入操作的次数上限
        public Queue2(int n)
        {
            queue = new int[n];
            l = 0;
            r = 0;
        }

        //调用任何方法前，判断队列中是否有元素
        public boolean empty()
        {
            return l == r;
        }

        //添加元素
        public void offer(int num)
        {
            queue[r++] = num;
        }

        //弹出元素
        public int poll()
        {
            return queue[l++];
        }

        //返回头元素，但不弹出
        public int head()
        {
            return queue[l];
        }

        //返回尾元素
        public int tail()
        {
            return queue[r - 1];
        }

        //队列大小
        public int size()
        {
            return r - l;
        }
    }


    static class CircularQueue
    {
        public int[] queue;
        public int l, r, size, limit;

        //同时在队列中的元素的个数不要超过k
        CircularQueue(int k)
        {
            queue = new int[k];
            l = r = size = 0;
            limit = k;
        }

        //如果队列满了，什么都不做，返回False
        public boolean push(int value)
        {
            if (isFull()) return false;
            else {
                queue[r] = value;
                //如果r到队列的最后一个位置了，就返回0位置
                r = r == limit - 1 ? 0 : (r + 1);
                size++;
                return true;
            }
        }

        //弹出一个数:如果数组为空，什么都不做，返回False
        //不为空，弹出头部元素，返回True
        public boolean pop()
        {
            if (isEmpty()) return false;
            else {
                //l到队列最后一个索引处时，跳回0位置
                l = l == limit - 1 ? 0 : (l + 1);
                size--;
                return true;
            }
        }

        //返回队列头部的数字,如果没有数，返回-1(不弹出）
        public int front()
        {
            if (isEmpty()) return -1;
            else return queue[l];
        }

        //返回尾部数字
        public int rear()
        {
            if (isEmpty()) return -1;
            else {
                //如果r为0，说明是从limit - 1跳过来的
                int last = r == 0 ? (limit - 1) : (r - 1);
                return queue[last];
            }
        }

        //判断队列是不是空的
        public boolean isEmpty()
        {
            return size == 0;
        }

        //判断队列满没满
        public boolean isFull()
        {
            return size == limit;
        }
    }

}
