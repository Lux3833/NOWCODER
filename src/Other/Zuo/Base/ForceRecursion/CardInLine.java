package Other.Zuo.Base.ForceRecursion;

/**
 * @title: CardInLine
 * @Author: Lux_er
 * @Date: 2021/4/25 0025 上午 9:06
 * @Description:
 * 给定一个整型数组arr, 代表数值不同的纸牌排成一条线，
 * 玩家A和玩家B依次拿走每张纸牌，
 * 规定玩家A先拿，玩家B后拿，
 * 但是每个玩家每次只能拿走最左或最右的纸牌，
 * 玩家A和玩家B都绝顶聪明，请返回最后获胜者的分数。
 */
public class CardInLine {
    private static int win(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        return Math.max(f(nums,0,nums.length-1), s(nums,0,nums.length-1));
    }
    private static int f(int[] nums, int L, int R) {
        if(L == R){
            return nums[L];
        }
        return Math.max(nums[L]+s(nums,L+1, R),
                nums[R]+s(nums,L,R-1));
    }
    private static int s(int[] nums, int L, int R) {
        if(L == R){
            return 0;
        }
        return Math.min(f(nums,L+1,R),f(nums, L,R-1));
    }
    // 动态规划
    public static int win2(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int N = arr.length;
        int[][] f = new int[N][N];
        int[][] s = new int[N][N];
        for (int i = 0; i < N; i++) {
            f[i][i] = arr[i];
        }
        for (int i = 1; i < N; i++) {
            int L = 0;
            int R = i;
            while(L < N && R < N){
                f[L][R] = Math.max(arr[L]+s[L+1][R],arr[R]+s[L][R-1]);
                s[L][R] = Math.min(f[L+1][R],f[L][R-1]);
                L++;
                R++;
            }
        }
        return Math.max(f[0][N-1],s[0][N-1]);
    }
}
