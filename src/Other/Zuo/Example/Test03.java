package Other.Zuo.Example;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * @title: Test03
 * @Author: Lux_er
 * @Date: 2021/5/7 0007 上午 10:08
 * @Description:
 * 给定一个非负数组arr,和一个正数m
 * 返回arr的所有子序列中累加和%m之后的最大值
 * 1）如果arr中每个数字不大，怎么做这道题？
 * 2）如果arr中m的值很小，怎么做这道题？
 * 3）如果arr的长度很短，但是arr每个数字比较大并且m比较大呢？
 */
public class Test03 {
    // 适用于arr中每个数字不大
    public static int max1(int[] arr,int m){
        HashSet<Integer> set = new HashSet<>();
        process1(arr,0,0,set);
        int max = 0;
        for (Integer sum : set) {
            max = Math.max(max, sum % m);
        }
        return max;
    }
    // 能形成多少个不同的累加和，全部存到set里  O(2^n)
    private static void process1(int[] arr, int index, int sum, HashSet<Integer> set) {
        if(index == arr.length){
            set.add(sum);
        }else{
            process1(arr, index+1, sum, set);
            process1(arr, index+1, sum+arr[index],set);
        }
    }
    // dp[i][j],表示arr[0...i]的数字任意选，能否使累加和等于j O(N * sum)
    // 该方法适用于arr中m不大的情况
    public static int max2(int[] arr,int m){
        int sum = 0;
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }
        boolean[][] dp = new boolean[N][sum+1];
        for (int i = 0; i < N; i++) {
            dp[i][0] = true;
        }
        dp[0][arr[0]] = true;
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i-1][j];// 第一种决策，不使用当前位置值
                if(j - arr[i] >= 0){
                    // 第二种决策，使用当前位置或者不使用当前位置的值
                    dp[i][j] = dp[i][j] | dp[i-1][j-arr[i]];
                }
            }
        }
        int ans = 0;
        for (int i = 0; i <= sum; i++) {
            if(dp[N-1][i]){
                ans = Math.max(ans, i % m);
            }
        }
        return ans;
    }

    public static int max3(int[] arr,int m){
        int N = arr.length;
        boolean[][] dp = new boolean[N][m];
        for (int i = 0; i < N; i++) {
            dp[i][0] = true;
        }
        dp[0][arr[0] % m] = true;
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i-1][j];
                int cur = arr[i] % m;
                // 两个if只会中一个
                if(j -cur >= 0){
                    dp[i][j] = dp[i][j] | dp[i-1][j-cur];
                }
                if(m+j - cur < m){
                    dp[i][j] = dp[i][j] | dp[i-1][m+j-cur];
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            if(dp[N-1][i]){
                ans = i;
            }
        }
        return ans;
    }
    // 如果arr的累加和很大，m也很大
    // 但是arr的长度相对不大
    public static int max4(int[] arr,int m){
        if(arr.length == 1){
            return arr[0] % m;
        }
        int mid = (arr.length-1) / 2;
        TreeSet<Integer> sortSet1 = new TreeSet<>();
        process4(arr,0,0,mid,m,sortSet1);
        TreeSet<Integer> sortSet2 = new TreeSet<>();
        process4(arr,mid+1,0,arr.length-1,m,sortSet2);
        int ans = 0;
        for (Integer left : sortSet1) {
            ans = Math.max(ans, left+sortSet2.floor(m-1-left));
        }
        return ans;
    }

    private static void process4(int[] arr, int index, int sum, int end, int m, TreeSet<Integer> sortSet) {
        if(index == end+1){
            sortSet.add(sum % m);
        }else{
            process4(arr, index+1, sum, end, m, sortSet);
            process4(arr, index+1, sum+arr[index],end, m, sortSet);
        }
    }

}
