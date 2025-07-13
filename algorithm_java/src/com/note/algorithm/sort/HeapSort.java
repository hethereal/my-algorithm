package com.note.algorithm.sort;

import com.note.algorithm.tool.Tool;

/**
 * 堆排序
 */
public class HeapSort
{

    public static void main(String[] args)
    {

    }

    /**
     * 向上调整
     * @param arr 原始数组
     * @param index 新插入的元素的下标索引
     */
    static void heapInsert(int[] arr, int index)
    {
        while (arr[index] > arr[(index - 1) / 2])
        {
            int temp = arr[index];
            arr[index] = arr[(index - 1) / 2];
            arr[(index - 1) / 2] = temp;
            index = (index - 1) / 2;
        }
    }

    /**
     * 向下调整
     * @param arr 数组
     * @param index 变化元素的索引
     * @param size 数字的尺寸
     */
    static void heapAdjust(int[] arr, int index, int size)
    {
        int l = index * 2 + 1;
        while (l < size)
        {
            int best = l + 1 < size && arr[l] > arr[l + 1]
                    ? l + 1 : l;
            best = arr[best] > arr[index] ? best : index;
            if (best == index) break;
            Tool.swap(arr, index, best);
            index = best;
            l = index * 2 + 1;
        }
    }

    /**
     * 从顶到底建堆
     * @param arr 原始数组
     */
    public static void heapSort1(int[] arr)
    {
        int n = arr.length;
        //建堆
        for (int i = 0; i < n; i++)
        {
            heapInsert(arr, i);
        }
        int size = n;
        while (size > 1)
        {
            Tool.swap(arr, 0, --size);
            heapAdjust(arr, 0, size);
        }
    }

    /**
     * 从底到顶建堆
     * @param arr 原始数组
     */
    public static void heapSort2(int[] arr)
    {
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--)
        {
            heapAdjust(arr, i, n);
        }
        int size = n;
        while (size > 1)
        {
            Tool.swap(arr, 0, --size);
            heapAdjust(arr, 0, size);
        }
    }

}
