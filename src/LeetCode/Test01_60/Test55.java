package LeetCode.Test01_60;

import LeetCode.Utils.Utils;

/**
 * @title: Test55
 * @Author: Lux_er
 * @Date: 2021/4/27 0027 下午 8:52
 * @Description:跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 */
public class Test55 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        int[] nums = utils.inputNums();
        boolean res = cap(nums);
        System.out.println(res);
    }

    private static boolean cap(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
