//! 时间复杂度

use std::ptr::null;
use std::time::Instant;

const n: usize = 20_000;

/// 调和级数
fn double_for_harmonic() {
    //双层for循环，但是O(nlogn)
    //计算运行时间
    let start = Instant::now();
    for i in 1..=n {
        for j in (i..n).step_by(i) {
        }
    }
    let end = Instant::now();
    println!("double_for_harmonic ：{:?}", end - start);
}

/// 普通for循环：O(n^2)
fn double_for_normal() {
    let start = Instant::now();
    for i in 1..=n {
        for j in 0..n {
        }
    }
    let end = Instant::now();
    println!("double_for_normal ：{:?}", end - start);
}

#[test]
fn test() {
    double_for_harmonic();
    double_for_normal();
}