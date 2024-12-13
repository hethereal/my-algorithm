package com.note.algorithm.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ConvertQueueAndStack
{

    /**
     * 用栈实现队列
     */
    static class MyQueue
    {

        public Stack<Integer> in;
        public Stack<Integer> out;

        public MyQueue()
        {
            this.in = new Stack<>();
            this.out = new Stack<>();
        }

        //in栈 数据 到 out栈数据
        private void inToOut()
        {
            if (out.empty()) {
                while (!in.empty()) {
                    out.push(in.pop());
                }
            }
        }

        //加入数据
        public void push(int x)
        {
            in.push(x);
            inToOut();
        }

        //弹出数据
        public int pop()
        {
            inToOut();
            return out.pop();
        }

        //返回元素，但不弹出
        public int peek()
        {
            inToOut();
            return out.peek();
        }

        public boolean empty()
        {
            return in.empty() && out.empty();
        }
    }

    /**
     * 队列实现栈
     */
    static class MyStack
    {
        public Queue<Integer> queue;

        public MyStack(Queue<Integer> queue)
        {
            this.queue = new LinkedList<>();
        }

        public void push(int x)
        {
            int n = queue.size();
            queue.offer(x);
            for (int i = 0; i < n; i++)
            {
                queue.offer(queue.poll());
            }
        }

        public int pop()
        {
            return queue.poll();
        }

        public int top()
        {
            return queue.peek();
        }

        public boolean empty()
        {
            return queue.isEmpty();
        }
    }

}
