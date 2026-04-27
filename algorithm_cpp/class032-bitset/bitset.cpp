//
// Created by Jackson on 2026/4/27.
//

#include <vector>
#include <iostream>
#include <unordered_set>
#include <random>

class Bitset
{
public:
    explicit Bitset(int n);
    ~Bitset() = default;
    void add(int num);
    void remove(int num);
    void reverse(int num);
    bool contains(int num) const;
private:
    std::vector<int32_t> set;
};

Bitset::Bitset(int n)
{
    set.resize((n + 31) / 32);
}

/**
 * 添加某个元素
 * @param num
 */
void Bitset::add(const int num)
{
    set[num / 32] |= (1 << (num % 32));
}

/**
 * 删除某个元素
 * @param num
 */
void Bitset::remove(const int num)
{
    set[num / 32] &= ~(1 << (num % 32));
}

/**
 * 反转某一位的状态
 * @param num
 */
void Bitset::reverse(const int num)
{
    set[num / 32] ^= 1 << (num % 32);
}

/**
 * 验证是否存在
 * @param num
 * @return
 */
bool Bitset::contains(const int num) const
{
    return (set[num / 32] & (1 << (num % 32))) != 0;
}

int main(int argc, char *argv[])
{
    // 对数器验证
    int n = 1000;
    int test_times = 10000;
    std::cout << "测试开始" << std::endl;
    // 实现的位图结构
    Bitset bs(n);
    // 使用unordered_set做对比测试
    std::unordered_set<int32_t> unordered_set;
    std::cout << "调用阶段开始" << std::endl;
    // 开头初始化一次
    std::random_device rd;
    std::mt19937 gen(rd());
    // 【关键】0.0 ~ 1.0 均匀浮点分布
    std::uniform_real_distribution<double> dist(0.0, 1.0);
    std::uniform_int_distribution<> dis(0, n - 1);
    for (int i = 0; i < test_times; ++i)
    {
        // 每次调用生成一个 0~1 小数
        double decide = dist(gen);
        // 生成一个0-n-1之间的整数
        int num = dis(gen);
        auto number = static_cast<int32_t>(num);
        if (decide < 0.3333)
        {
            unordered_set.insert(number);
            bs.add(number);
        }
        else if (decide < 0.6666)
        {
            unordered_set.erase(number);
            bs.remove(number);
        }
        else
        {
            bs.reverse(number);
            if (unordered_set.count(number))
            {
                unordered_set.erase(number);
            }
            else
            {
                unordered_set.insert(number);
            }
        }
    }
    std::cout << "调用阶段结束" << std::endl;
    std::cout << "验证阶段开始" << std::endl;
    for (int i = 0; i < n; ++i)
    {
        if (bs.contains(i) != unordered_set.count(i))
        {
            std::cout << "出错了：" << i << std::endl;
        }
    }
    std::cout << "验证阶段结束" << std::endl;
    std::cout << "测试结束" << std::endl;
}