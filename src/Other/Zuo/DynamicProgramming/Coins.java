package Other.Zuo.DynamicProgramming;

/**
 * @title: Coins
 * @Author: Lux_er
 * @Date: 2021/5/2 0002 下午 12:21
 * @Description:
 * 给定一数组的硬币面值,这些硬币没有重复面值,且都是正数,每种面值可以重复选取,再给定
 * 一个目标金额,请给出取到该金额的所有方案
 */
public class Coins {
    // arr中都是正数且无重复值,返回组成aim的方法数
    public static int ways(int[] arr,int aim){
        if(arr == null || arr.length == 0 || aim < 0){
            return 0;
        }
        return process1(arr,0,aim);
    }

    private static int process1(int[] arr, int index, int rest) {
        if(index == arr.length){
            return rest == 0 ? 1 : 0;
        }
        int ways = 0;
        for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
            ways += process1(arr, index+1, rest-zhang * arr[index]);
        }
        return ways;
    }
    // 带记忆化搜索
    private static int way2(int[] arr, int aim) {
        if(arr == null || arr.length == 0 || aim < 0){
            return 0;
        }
        int[][] dp = new int[arr.length+1][aim+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return process2(arr,0,aim,dp);
    }
    // 若index和rest的参数组合是没算过的,dp[index][rest] == -1
    // 若index和rest的参数组合是算过的,  dp[index][rest] > -1
    private static int process2(int[] arr, int index, int rest, int[][] dp) {
        if(dp[index][rest] != -1){
            return dp[index][rest];
        }
        if(index == arr.length){
            dp[index][rest] = rest == 0 ? 1 : 0;
        }
        int ways = 0;
        for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
            ways += process2(arr, index+1, rest-zhang * arr[index],dp);
        }
        dp[index][rest] = ways;
        return ways;
    }
    // 带枚举的动态规划
    public static int ways3(int[] arr,int aim){
        if(arr == null || arr.length == 0 || aim < 0){
            return 0;
        }
        int N = arr.length;
        int[][] dp = new int[N+1][aim+1];
        dp[N][0] = 1;
        for (int index = N-1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                int ways = 0;
                for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
                    ways += dp[index+1][rest-zhang * arr[index]];
                }
                dp[index][rest] = ways;
            }
        }
        return dp[0][aim];
    }
    // 去重枚举的动态规划
    public static int ways4(int[] arr,int aim){
        if(arr == null || arr.length == 0 || aim < 0){
            return 0;
        }
        int N = arr.length;
        int[][] dp = new int[N+1][aim+1];
        dp[N][0] = 1;
        for (int index = N-1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
               dp[index][rest] = dp[index+1][rest];
               if(rest - arr[index] >= 0){
                   dp[index][rest] += dp[index+1][rest - arr[index]];
               }
            }
        }
        return dp[0][aim];
    }
}
