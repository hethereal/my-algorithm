package com.note.algorithm.sort;

import com.note.algorithm.tool.Tool;

import java.util.Random;

public class BubbleSort
{
    public static void bubbleSort(int[] arr)
    {
        if (arr.length < 2) return;
        int length = arr.length;
        int end = length - 1, i = 0;

        while (end > 0)
        {
            if (arr[i] > arr[i + 1])
            {
                Tool.swap(arr, i, i + 1);
            }
            if (i < end - 1)
            {
                i++;
            }
            else
            {
                end--;
                i = 0;
            }
        }
    }


    public static void main(String[] args)
    {
        int[] arr = new int[10];
        Random random = new Random();
        for (int j = 0; j < 10; j++)
        {
            int i = random.nextInt(100) + 1;
            arr[j] = i;
        }
        System.out.println("排序前：");
        for (int a : arr)
        {
            System.out.print(a + ",");
        }
        System.out.println("\n排序后：");
        bubbleSort(arr);
        for (int a : arr)
        {
            System.out.print(a + ",");
        }
        System.out.println();
    }

}
