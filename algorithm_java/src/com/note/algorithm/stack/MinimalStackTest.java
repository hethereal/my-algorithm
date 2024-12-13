package com.note.algorithm.stack;

public class MinimalStackTest
{
    /**
     * 永远可以拿到栈中最小值
     */
    static class MinimalStack
    {
        public final int MAX = 8001;

        public int[] data;
        public int[] min;
        int size;

        public MinimalStack()
        {
            this.data = new int[MAX];
            this.min = new int[MAX];
            size = 0;
        }

        public void push(int val)
        {
            data[size] = val;
            if (size == 0 || val <= min[size - 1]) {
                min[size] = min[size -1];
            } else {
                size++;
            }
        }

        public void pop()
        {
            size--;
        }

        public int top()
        {
            return data[size - 1];
        }

        public int getMin()
        {
            return min[size - 1];
        }
    }
}
