package Other.Zuo.Base.ForceRecursion;

/**
 * @title: Knapsack
 * @Author: Lux_er
 * @Date: 2021/4/25 0025 上午 9:24
 * @Description:
 * 给定两个长度都为N的数组weights和values,
 * weights[i]和values[i]分别代表i号物品的重量和价值。
 * 给定一个正数bag,表示一个载重bag的袋子，
 * 你装的物品不能超过这个重量。
 * 返回你能装下最多的价值是多少？
 */
public class Knapsack {
    public static int process(int[] weights,int[] values,int index,int alreadyW,int bag){
        if(alreadyW > bag){
            return -1;//没有可行方案
        }
        //重量没超
        if(index == weights.length){
            return 0;
        }
        //没有加index位置上的重物，后续能产生的价值
        int p1 = process(weights,values,index+1,alreadyW,bag);
        //加了当前重物，后续能产生的价值
        int p2next = process(weights, values, index+1, alreadyW+weights[index],bag);
        int p2 = -1;
        if(p2next != -1){
            p2 = values[index] + p2next;
        }
        return Math.max(p1,p2);
    }
    // 动态规划
    public static int dpWay(int[] w,int[] v,int bag){
        int N = w.length;
        int[][] dp = new int[N+1][bag+1];
        for (int index = N-1; index >= 0; index--) {
            for (int rest = 0; rest <= bag; rest++) {
                int p1 = dp[index+1][rest];
                int p2 = -1;
                if(rest >= w[index]){
                    p2 = v[index]+dp[index+1][rest-w[index]];
                }
                dp[index][rest] = Math.max(p1,p2);
                }
            }
        return dp[0][bag];
    }
}
