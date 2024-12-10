//! 二进制与位运算

///获取相反数
#[cfg(test)]
mod test {
    use crate::binary::{print_binary, return_false, return_true};

    #[test]
    fn test() {
        let a = 5;
        println!("取反之后：{}", !a);
        println!("取反之后+1：{}", !a + 1);
    }

    #[test]
    fn test02() {
        println!("测试1：");
        let _r1 = return_true() | return_false();
        println!("测试2：");
        let _r2 = return_true() || return_false();
        println!("测试3：");
        let _r3 = return_false() & return_true();
        println!("测试4：");
        let _r4 = return_false() && return_true();
    }

    #[test]
    fn test03() {
        let a = 10;
        let b = -10;
        println!("a = {:#b}", a);
        println!("a << 1 = {}", a << 1);
        println!("a >> 1 = {}", a >> 1);
        println!("b << 1 = {}", b << 1);
        println!("b >> 1 = {}", b >> 1);
    }

    #[test]
    fn test04() {
        print_binary(&54);
    }
}

fn return_true() -> bool {
    println!("进入了 return_true() 函数");
    true
}

fn return_false() -> bool {
    println!("进入了 return_false() 函数");
    false
}

///打印二进制数
fn print_binary(num: &i32) {
    for i in (0..=31).rev() {
        if num & (1 << i) == 0 {
            print!("0");
        } else {
            print!("1");
        }
    }
    println!();
}