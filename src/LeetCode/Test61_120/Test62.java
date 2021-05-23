package LeetCode.Test61_120;

import LeetCode.Utils.Utils;

/**
 * @title: Test62
 * @Author: Lux_er
 * @Date: 2021/5/14 0014 上午 9:44
 * @Description:不同路径
 * 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 */
public class Test62 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        int m = utils.inputNumber();
        int n = utils.inputNumber();
        System.out.println(uniquePaths(m,n));
    }
    // 暴力递归
    public static int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];
        return process(arr,0,0);
    }

    private static int process(int[][] arr,int x,int y) {
        if(x == arr.length-1 && y == arr[0].length-1){
            return 1;
        }
        if(x >= arr.length || y >= arr[0].length){
            return 0;
        }
        int step1 = process(arr,x,y+1);
        int step2 = process(arr,x+1,y);
        return step1+step2;
    }
    // 动态规划
    public int uniquePaths2(int m, int n) {
        int dp[][]=new int[m+1][n+1];
        dp[0][1]=1;
        for(int i=1;i<m+1;i++)
        {
            for(int j=1;j<n+1;j++)
            {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return  dp[m][n];
    }
}
