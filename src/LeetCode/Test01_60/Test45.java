package LeetCode.Test01_60;

import LeetCode.Utils.Utils;

/**
 * @title: Test45
 * @Author: Lux_er
 * @Date: 2021/3/21 0021 上午 11:02
 * @Description:
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 */
public class Test45 {
    public static void main(String args[]){
        Utils utils = new Utils();
        int[] nums = utils.inputNums();
        int count = jump(nums);
        System.out.println(count);
    }

    private static int jump(int[] nums) {
        if(nums == null || nums.length < 2 || nums[0] == 0){
            return 0;
        }
        if(nums.length-1 <= nums[0]){
            return 1;
        }
        return countJump(nums,0,nums[0],0);
    }

    private static int countJump(int[] nums, int index, int val, int count) {
        if(index + val >= nums.length-1){
            return ++count;
        }else{
            int indexOfMax = 0;
            int valOfMax = 0;
            for (int i = index+1; i < index+val+1 && i < nums.length; i++) {
                if(nums[i]+i > indexOfMax+valOfMax){
                    indexOfMax = i;
                    valOfMax = nums[i];
                }
            }
            count++;
            return countJump(nums,indexOfMax,valOfMax,count);
        }

    }
}
