package Other.Zuo.BaseImprove;

/**
 * @title: CoinsMin
 * @Author: Lux_er
 * @Date: 2021/4/28 0028 上午 10:23
 * @Description:
 */
public class CoinsMin {
    public static int min1(int[] arr, int aim) {
        return process1(arr, 0, aim);
    }

    // index 当前选择的硬币下标
    // rest 还需要收集多少钱
    // 返回获得目标硬币金额的最少硬币数
    private static int process1(int[] arr, int index, int rest) {
        if (rest < 0) {
            return -1;
        }
        if (rest == 0) {
            return 0;
        }
        if (index == arr.length) {
            return -1;
        }
        int p1 = process1(arr, index + 1, rest);
        int p2Next = process1(arr, index + 1, rest - arr[index]);
        if (p1 == -1 && p2Next == -1) {
            return -1;
        } else {
            if (p1 == -1) {
                return p2Next + 1;
            }
            if (p2Next == -1) {
                return p1;
            }
            return Math.min(p1, p2Next + 1);
        }
    }

    public static int min2(int[] arr, int aim) {
        int[][] dp = new int[arr.length + 1][aim + 1];
        for (int i = 0; i <= arr.length; i++) {
            for (int j = 0; j <= aim; j++) {
                dp[i][j] = -2;//-2表示没有算过
            }
        }
        return process2(arr, 0, aim, dp);
    }

    // index 当前选择的硬币下标
    // rest 还需要收集多少钱
    // 返回获得目标硬币金额的最少硬币数
    private static int process2(int[] arr, int index, int rest, int[][] dp) {
        if (rest < 0) {
            return -1;
        }
        if (dp[index][rest] != -2) {
            return dp[index][rest];
        }
        if (rest == 0) {
            dp[index][rest] = 0;
        } else if (index == arr.length) {
            dp[index][rest] = -1;
        } else {
            int p1 = process2(arr, index + 1, rest, dp);
            int p2Next = process2(arr, index + 1, rest - arr[index], dp);
            if (p1 == -1 && p2Next == -1) {
                dp[index][rest] = -1;
            } else {
                if (p1 == -1) {
                    dp[index][rest] = p2Next + 1;
                } else if (p2Next == -1) {
                    dp[index][rest] = p1;
                } else {
                    dp[index][rest] = Math.min(p1, p2Next + 1);
                }
            }
        }
        return dp[index][rest];
    }

}
