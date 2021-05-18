package LeetCode.Test61_120;

import LeetCode.Utils.Utils;

/**
 * @title: Test69
 * @Author: Lux_er
 * @Date: 2021/5/16 0016 上午 9:03
 * @Description:x的平方根
 * 实现int sqrt(int x)函数。
 * 计算并返回x的平方根，其中x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 示例：
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */
public class Test69 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        int num = utils.inputNumber();
        int res = mySqrt(num);
        System.out.println(res);
    }

    private static int mySqrt(int x) {
        int temp = x/2;
        int res = 0;
        for (int i = 0; i <= temp; i++) {
            if((i * i) == x){
                return i;
            }
            if(i*i < x){
                if((i+1)*(i+1) == x){
                    res = i+1;
                    break;
                }else if((long)(i+1)*(i+1) > x){
                    res = i;
                    break;
                }else{
                    res = i;
                    continue;
                }
            }
        }
        return res;
    }
    // 牛顿迭代法
    public int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }
        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }
    // 二分查找法
    public int mySqrt3(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
