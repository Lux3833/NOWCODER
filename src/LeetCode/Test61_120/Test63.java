package LeetCode.Test61_120;

import LeetCode.Utils.Utils;

/**
 * @title: Test63
 * @Author: Lux_er
 * @Date: 2021/5/14 0014 上午 9:59
 * @Description:不同路径II
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 示例：
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 */
public class Test63 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        int m = utils.inputNumber();
        int n = utils.inputNumber();
        int[][] obstacleGrid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                obstacleGrid[i][j] = utils.inputNumber();
            }
        }
        System.out.println(uniquePathsWithObstacles2(obstacleGrid));
    }
    // 暴力递归
    private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return process(obstacleGrid,0,0);
    }

    private static int process(int[][] obstacleGrid, int i, int j) {
        if(i == obstacleGrid.length-1 && j == obstacleGrid[0].length-1){
            return 1;
        }
        if(i >= obstacleGrid.length || j >= obstacleGrid.length){
            return 0;
        }
        if(obstacleGrid[i][j] == 1){
            return 0;
        }
        int step1 = process(obstacleGrid, i,j+1);
        int step2 = process(obstacleGrid,i+1,j);
        return step1+step2;
    }
    //动态规划
    private static int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int[m+1][n+1];
        if(obstacleGrid[0][0] == 1){
            return 0;
        }
        dp[0][1] = 1;
        for(int i=1;i<m+1;i++)
        {
            for(int j=1;j<n+1;j++)
            {
                if(obstacleGrid[i-1][j-1] != 1){
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return dp[m][n];
    }
}
