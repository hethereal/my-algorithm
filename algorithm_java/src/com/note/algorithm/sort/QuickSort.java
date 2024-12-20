package com.note.algorithm.sort;


import com.note.algorithm.tool.Tool;

/**
 * Random Quick Sort
 */
public class QuickSort
{
    public static int MAX = 50001;
    public static int[] arr = new int[MAX];
    public static int n;

    /**
     * Random Quick Sort Classic Version
     */
    public static void quickSort01(int l, int r)
    {
        //if l == r , means exist one element
        if (l >= r) return;
        // in l ... r interval, randomly choose one position,
        // which this value in this position to divide this interval
        int x = arr[l + (int)(Math.random() * (r - l + 1))];
        int mid = partition1(l, r, x);
        quickSort01(l, mid - 1);
        quickSort01(mid + 1, r);
    }

    /**
     *  Partition the array
     *  elements <= x are placed on the left side; >x are placed on the right side.
     *  Moreover, after the partitioning is completed, the last element is x on the left side.
     */
    public static int partition1(int l, int r, int x)
    {
        // a : arr[l...a-1] is the interval that <= x
        // xi: is a value equal to x in the interval arr[l...a-1]
        int a = l, xi = 0;
        for (int i = l; i <= r; i++)
        {
            if (arr[i] <= x)
            {
                Tool.swap(arr, a, i);
                if (arr[a] == x) xi = a;
                a++;
            }
        }
        Tool.swap(arr, xi, a - 1);
        return a - 1;
    }


    /**
     * Quick Sort Improved Version (Recommend)
     */
    public static void quickSort02(int l, int r)
    {
        //if l == r , means exist one element
        if (l >= r) return;
        // in l ... r interval, randomly choose one position,
        // which this value in this position to divide this interval
        int x = arr[l + (int)(Math.random() * (r - l + 1))];
        partition2(l, r, x);
        int left = first;
        int right = last;
        quickSort02(l, left - 1);
        quickSort02(right + 1, r);
    }

    public static int first, last;


    /**
     *  Partition Improved version:
     *  Set the three fields:
     *  <x placed on the left and a is boundary
     *  =x placed on the middle
     *  >x placed on the right and b is boundary
     */
    public static void partition2(int l, int r, int x)
    {
        first = l;
        last = r;
        int i = l;
        while (i <= last)
        {
            if (arr[i] == x) i++;
            else if (arr[i] < x) Tool.swap(arr, first++, i++);
            else Tool.swap(arr, i, last--);
        }
    }
}
