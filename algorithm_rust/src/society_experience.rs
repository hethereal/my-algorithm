//! 该模块用于模拟一个社会实验：
/*

    一开始有100人，每人有100元；在每一轮可以做如下事情:
    每个人都必须拿出一元给除自己之外的其他人，给谁完全随机
    如果某个人在这一轮钱数为0，那么可以不给，但可以接收；
    在发生很多轮之后，这100人的财富分布会是平均的吗？
 */

use rand::{thread_rng, Rng};
///实验
/// n: 人数 t: 轮数
fn experiment(n: usize, c: usize) {
    //每个人携带100财富
    let mut wealth = vec![100f64; n];
    //循环遍历财富数组
    for _ in 0..c {
        //判断当前回合是否有人没钱
        let mut has_money = vec![false; n];
        for j in 0..n {
            if wealth[j] > 0f64 { has_money[j] = true; }
        }
        //如果有钱，则随机给其他人1元
        for j in 0..n {
            if has_money[j] {
                let mut rng = thread_rng();
                //随机生成一个索引代表其他人
                let mut other: usize;
                loop {
                    other = rng.gen_range(0..n);
                    if j!= other {
                        break;
                    }
                }
                wealth[j] -= 1f64;
                wealth[other] += 1f64;
            }
        }
    }
    //数组排序
    wealth.sort_by(|a, b| a.partial_cmp(b).unwrap());
    println!("列出每个人的财富：");
    for i in 0..n {
        print!("{}  ", wealth[i]);
        if i % 10 == 0 { println!(); }
    }

    //打印基尼系数
    println!("\n这个社会的基尼系数为：{:?}", calculate_gini(&wealth));

}

///计算基尼系数的函数
fn calculate_gini(wealth: &Vec<f64>) -> f64 {
    let mut sum_absolute_diff_wealth: f64 = 0.0;
    let mut sum_wealth: f64 = 0.0;
    let n = wealth.len();
    for i in 0..n {
        sum_wealth += wealth[i];
        for j in 0..n {
            sum_absolute_diff_wealth += (wealth[i] - wealth[j]).abs();
        }
    }
    sum_absolute_diff_wealth / (2f64 * n as f64 * sum_wealth)
}


#[cfg(test)]
mod tests {
    use crate::society_experience::{calculate_gini, experiment};

    #[test]
    fn test01()
    {
        let v = vec![2f64, 3f64, 4f64];
        let res = calculate_gini(&v);
        println!("{res}");
    }

    #[test]
    fn test02()
    {
        println!("测试开始：");
        let n: usize = 100;
        let t: usize = 1000000;
        println!("人数：{}, 轮数：{}", n, t);
        experiment(n, t);
        println!("测试结束！");
    }
}
