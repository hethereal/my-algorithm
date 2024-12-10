package com.note.algorithm.tool;

/**
 * 工具类：
 */

public class Tool
{

    /**
     * 交换数组中两个数
     * @param arr 数组
     * @param i 索引
     * @param j 索引
     */
    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
