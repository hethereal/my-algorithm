package com.note.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort
{
    /**
     * 定义全局静态变量
     */
    public static int MAX = 5;
    public static int[] help = new int[MAX];
    public static int[] arr = new int[MAX];
    public static int n;

    public static void main(String[] args)
    {
        int[] nums = new int[] {5, 1, 2, 3};
        n = nums.length;
        MergeSort mergeSort = new MergeSort();
        int[] ints = mergeSort.sortArray(nums);
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
    }


    public int[] sortArray(int[] nums)
    {
        System.arraycopy(nums, 0, arr, 0, nums.length);
        //mergeSort01(0, nums.length - 1);
        mergeSort02();
        System.arraycopy(arr, 0, nums, 0, nums.length);
        return nums;
    }


    /**
     * Merge Sort : Recursive Way
     */
    public static void mergeSort01(int l, int r)
    {
        if (l == r) return;
        int m = (l + r) / 2;
        mergeSort01(l, m);
        mergeSort01(m + 1, r);
        merge(l, m, r);
    }


    /**
     * Merge Sort : Non-Recursive Way
     *  Define a step size.
     *  Take values according to the step size each time.
     *  Set the step size as a power of 2
     *  until the step size is greater than the length of the array and then stop.
     */
    public static void mergeSort02()
    {

        for (int l, m, r, step = 1; step < n; step <<= 1)
        {
            l = 0;
            while (l < n)
            {
                m = l + step - 1;
                if (m + 1 >= n) break;
                r = Math.min(l + (step << 1) - 1, n - 1);
                merge(l, m, r);
                l = r + 1;
            }
        }
    }


    /**
     * merge : Non-Recursive
     * O(n)
     */
    public static void merge(int l, int m, int r)
    {
        //three pointers point to left interval and right interval
        //and i is a cursor,which help us to fill the help array
        int i = l;
        int a = l;
        int b = m + 1;
        // when left interval and right interval still have data,then go on
        while (a <= m && b <= r)
        {
            help[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];
        }
        //following while cycle only execute one of them
        while (a <= m) help[i++] = arr[a++];
        while (b <= r) help[i++] = arr[b++];
        //Finally, copy the sorted elements in the auxiliary array back to the original array.
        for (i = l; i <= r; i++)
        {
            arr[i] = help[i];
        }
    }
}
