package LeetCode.Test01_60;
import LeetCode.Utils.Utils;

import java.util.Arrays;
/**
 * @title: Test31
 * @Author: Lux_er
 * @Date: 2021/3/18 0018 下午 7:42
 * @Description:
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中
 * 下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须 原地 修改，只允许使用额外常数空间。
 */
public class Test31 {
    public static void main(String args[]){
        Utils utils = new Utils();
        int[] nums = utils.inputNums();
        nextPermutation(nums);
        utils.printNums(nums);
    }

    private static void nextPermutation(int[] nums) {
        if(nums.length <= 1){
            return;
        }
        int i,j;
        for(i = nums.length-1;i > 0;i--){
            if(nums[i] > nums[i-1]){
                break;
            }
        }
        j = i-1;
        if(j >= 0){
            for (int k = nums.length-1; k >= i ; k--) {
                if(nums[k] > nums[j]){
                    int temp = 0;
                    temp = nums[j];
                    nums[j] = nums[k];
                    nums[k] = temp;
                    break;
                }
            }
            Arrays.sort(nums,i,nums.length);
        }else{
            Arrays.sort(nums);
        }
    }
}
