package LeetCode.Test61_120;

import LeetCode.Utils;

/**
 * @title: Test70
 * @Author: Lux_er
 * @Date: 2021/5/16 0016 上午 9:37
 * @Description:爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class Test70 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        int n = utils.inputNumber();
        System.out.println(climbStairs2(n));
    }
    public static int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        int step1 = climbStairs(n-1);
        int step2 = climbStairs(n-2);
        return step1+step2;
    }
    // 动态规划
    public static int climbStairs2(int n){
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n+1; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
