package stack;

public class StackImpl
{
    /**
     * 栈实现
     */
    static class Stack
    {
        public int[] stack;
        public int size;

        //确保栈中元素不会同时超过n
        public Stack(int n)
        {
            this.stack = new int[n];
            this.size = 0;
        }

        //调用方法前判断栈中是否有元素
        public boolean empty()
        {
            return size == 0;
        }

        //放入元素
        public void push(int num)
        {
            stack[size++] = num;
        }

        //弹出元素
        public int pop()
        {
            return stack[--size];
        }

        //返回栈顶元素，但不弹出
        public int peek()
        {
            return stack[size - 1];
        }

        //返回栈中元素多少
        public int size()
        {
            return size;
        }
    }
}
