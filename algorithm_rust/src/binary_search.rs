

/// 二分查找 : 需要序列有序
/// 确定目标是否存在
fn exist<T: Ord>(v: &mut Vec<T>, target: T) -> bool {

    if v.len() < 1 { return false; }

    let mut left: usize = 0;
    let mut right: usize = v.len() - 1;
    let mut mid: usize = 0;
    while left <= right {
        //防止整数溢出
        mid = left + ((right - left) >> 1);
        if v[mid] == target { return true; }
        else if v[mid] > target { right = mid - 1; }
        else { left = mid + 1; }
    }
    false
}

/// 二分查找：找到>=target的最左位置
fn find_left<T: Ord>(v: &mut Vec<T>, target: T) -> isize {
    let mut l: usize = 0;
    let mut r: usize = v.len() - 1;
    let mut mid: usize = 0;
    let mut ans: isize = -1;
    while l <= r {
        mid = l + ((r - l) >> 1);
        if v[mid] >= target {
            ans = mid as isize;
            r = mid - 1;
        } else {
            l = mid + 1;
        }
    }
    ans
}

/// 二分查找：
/// 找到`<= target`的最右位置
fn find_right<T: Ord>(v: &mut Vec<T>, target: T) -> isize {
    let mut l: isize = 0;
    let mut r: isize = (v.len() - 1) as isize;
    let mut mid: isize = 0;
    let mut ans: isize = -1;
    while l <= r {
        mid = l + ((r - l) >> 1);
        if v[mid as usize] <= target {
            ans = mid;
            l = mid + 1;
        } else {
            r = mid - 1;
        }
    }
    ans
}

///寻找峰值
fn find_peak(nums: Vec<i32>) -> i32 {
    let length = nums.len();
    //数组中只有一个元素，则0索引即是峰值
    if nums.len() < 2 {
        return 0
    }
    //判断0 和 n-1是否为峰值
    if nums[0] > nums[1] {
        return 0
    }
    if nums[length - 1] > nums[length - 2] {
        return (length - 1) as i32
    }

    // 在 1 - (n-2) 范围内继续查找
    let mut l = 1;
    let mut r = (length - 2) as i32;
    let mut m = 0;
    let mut ans = -1;
    while l <= r {
        m = l + ((r - l) >> 1);
        //中点比左侧小，单调递减趋势，说明峰值在左
        if nums[m as usize] < nums[(m - 1) as usize] {
            r = m - 1;
            //中点比右侧小，单调递增趋势，说明峰值在右
        } else if nums[m as usize] < nums[(m + 1) as usize] {
            l = m + 1;
        } else {
            ans = m;
            break;
        }
    }
    ans
}

#[test]
fn test01() {
    let mut v = vec![1, 2, 3, 4, 5];
    let b = exist(&mut v, 3);
    println!("{b}");
}

#[test]
fn test02()
{
    let mut v = vec![1, 2, 3, 4, 6];
    let t = find_left(&mut v, 4);
    println!("{t}");
}

#[test]
fn test03() {
    let mut v = vec![11, 22, 33, 44, 56];
    let t = find_right(&mut v, 4);
    println!("{t}");
}

#[test]
fn test04() {
    let mut v = vec![11, 22, 33, 44, 33];
    let t = find_peak(v);
    println!("{t}");
}