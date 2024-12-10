"""
冒泡排序的两种实现
"""

def bubble_sort01(arr):
    """
    冒泡排序
    :param arr: 数组
    :return: 排序好的数组
    """
    if len(arr) < 2:
        return

    length = len(arr)
    end = length - 1
    i = 0
    while end > 0:
        if arr[i] > arr[i + 1]:
            arr[i], arr[i + 1] = arr[i + 1], arr[i]
        if i < end - 1:
            i += 1
        else:
            end -= 1
            i = 0


if __name__ == '__main__':
    arr = [4, 3, 2, 1]
    bubble_sort01(arr)
    print(arr)