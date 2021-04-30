package Other.Zuo.BaseImprove;

/**
 * @title: RobotWalk
 * @Author: Lux_er
 * @Date: 2021/4/28 0028 上午 9:42
 * @Description:
 */
public class RobotWalk {
    public static int walkWays1(int N,int P,int S,int K){
        return f1(N,P,K,S);//暴力递归
    }
    // 一共是1~N这么多位置,固定参数
    // 最终目的地是E,固定参数
    // 还剩rest步需要走
    // 当前在cur位置
    // 返回方法数
    private static int f1(int N, int E, int rest, int cur) {
        if(rest == 0){
            return cur == E ? 1 : 0;
        }
        // 走到下标为1的位置,只能往右边走
        if(cur == 1){
            return f1(N,E,rest-1, 2);
        }
        // 走到下标为N的位置,只能往N-1位置走
        if(cur == N){
            return f1(N,E,rest-1,N-1);
        }
        return f1(N,E,rest-1,cur-1)+f1(N,E,rest-1,cur+1);
    }
    // 添加记忆化搜索的dp
    public static int walkWays2(int N,int E,int S,int K){
        int[][] dp = new int[K+1][N+1];
        for (int i = 0; i <= K; i++) {
            for (int j = 0; j <= N; j++) {
                dp[i][j] = -1;
            }
        }
        return f2(N,E,K,S,dp);
    }

    // 一共是1~N这么多位置,固定参数
    // 最终目的地是E,固定参数
    // 还剩rest步需要走
    // 当前在cur位置
    // 返回方法数
    private static int f2(int N, int E, int rest, int cur,int[][] dp) {
        if(dp[rest][cur] != -1){
            return dp[rest][cur];
        }
        // 建立缓存
        if(rest == 0){
            dp[rest][cur] = cur == E ? 1 : 0;
            return dp[rest][cur];
        }
        // 走到下标为1的位置,只能往右边走
        if(cur == 1){
            dp[rest][cur] = f1(N,E,rest-1, 2);
        }
        // 走到下标为N的位置,只能往N-1位置走
        else if(cur == N){
            dp[rest][cur] = f1(N,E,rest-1,N-1);
        }else{
            dp[rest][cur] =  f1(N,E,rest-1,cur-1)+f1(N,E,rest-1,cur+1);
        }
        return dp[rest][cur];
    }
}
