//
// Created by qi wang on 2025/7/13.
//

#include <iostream>
void heap_insert(int arr[], int index);
void swap(int arr[], int i, int j);
void heap_adjust(int arr[], int index, int size);
void heap_sort(int arr[], int size);

int main()
{
    int arr[] = { 3, 11, 53, 23, 11, 21, 55, 43 };
    heap_sort(arr, 8);
    for (int i = 0; i < 8; i++)
        std::cout << arr[i] << " ";
    std::cout << std::endl;
}

/**
 * 交换数组的两个元素
 * @param arr
 * @param i
 * @param j
 */
void swap(int arr[], int i, int j)
{
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

/**
 * 向上调整
 * @param arr 原始数组
 * @param index 最后一个元素的索引
 */
void heap_insert(int arr[], int index)
{
    while (arr[index] > arr[(index - 1) / 2])
    {
        swap(arr, index, (index - 1) / 2);
        index = (index - 1) / 2;
    }
}

/**
 * 向下调整
 * @param arr
 * @param index
 * @param size
 */
void heap_adjust(int arr[], int index, int size)
{
    int l = index * 2 + 1;
    while (l < size)
    {
        int best = l + 1 < size  && arr[l] < arr[l + 1]
            ? l + 1
            : l;
        best = arr[index] > arr[best] ? index : best;
        if (best == index) break;
        swap(arr, index, best);
        index = best;
        l = index * 2 + 1;
    }
}

/**
 * 从顶到底建堆
 * @param arr
 * @param size
 */
void heap_sort(int arr[], int size)
{
    //建堆
    for (int i = 0; i < size; i++)
    {
        heap_insert(arr, i);
    }
    //排序
    int n = size;
    while (n > 1)
    {
        swap(arr, 0, --n);
        heap_adjust(arr, 0, n);
    }
}
