//
// Created by Jackson on 2026/4/27.
//
#include <algorithm>
#include <iostream>

constexpr int MAX = 10;
int arr[MAX];
int help[MAX];
void merge(int low, int mid, int high);
void merge_sort_with_recursive(int low, int high);
void merge_sort_non_recursive();
void print_arr();

int main(int argc, char *argv[])
{
    int arr2[MAX] = {2, 5, 1, 4, 3, 9, 0, 4, 7, 6};
    std::copy_n(arr2, MAX, arr);
    print_arr();
    // merge_sort_non_recursive();
    merge_sort_with_recursive(0, MAX-1);
    print_arr();
}

// 归并排序：递归版
void merge_sort_with_recursive(int low, int high)
{
    if (low == high) return;
    int mid = (low + high) / 2;
    merge_sort_with_recursive(low, mid);
    merge_sort_with_recursive(mid + 1, high);
    merge(low, mid, high);
}

// 归并排序：非递归版
void merge_sort_non_recursive()
{
    for (int low, mid, high, step = 1; step < MAX; step <<= 1)
    {
        low = 0;
        while (low < MAX)
        {
            mid = low + step - 1;
            if (mid + 1 >= MAX)
            {
                break;
            }
            high = std::min(low + (step << 1) - 1, MAX - 1);
            merge(low, mid, high);
            low = high + 1;
        }
    }
}

// 归并的过程
void merge(const int low, const int mid, const int high)
{
    int i = low, a = low, b = mid + 1;
    while (a <= mid && b <= high)
    {
        help[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];
    }
    while (a <= mid)
    {
        help[i++] = arr[a++];
    }
    while (b <= high)
    {
        help[i++] = arr[b++];
    }
    for (i = low; i <= high; i++)
    {
        arr[i] = help[i];
    }
}

// 打印数组
void print_arr()
{
    for (const int i : arr)
    {
        std::cout << i << " ";
    }
    std::cout << std::endl;
}