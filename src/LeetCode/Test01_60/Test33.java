package LeetCode.Test01_60;
import LeetCode.Utils.Utils;

import java.util.Arrays;
/**
 * @title: Test33
 * @Author: Lux_er
 * @Date: 2021/3/19 0019 上午 9:41
 * @Description:
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
 * （下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7]
 * 在下标 3 处经旋转后可能变为[4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，
 * 如果 nums 中存在这个目标值 target ，则返回它的索引，否则返回-1。
 */
public class Test33 {
    public static void main(String args[]){
        Utils utils = new Utils();
        int[] nums = utils.inputNums();
        int target = utils.inputNumber();
        int res = search(nums,target);
        System.out.println(res);
    }

    private static int search(int[] nums, int target) {
        if(nums.length == 0 || nums == null){
            return -1;
        }
        if(nums.length == 1){
            return nums[0] == target ? 0 : -1;
        }
        int index = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i+1] < nums[i]){
                index = i;
                break;
            }
        }
        if(nums[index] >= target && nums[0] <= target){
            int res = Arrays.binarySearch(nums,0,index+1,target);
            return res < 0 ? -1 : res;
        }else if(nums[index+1] <= target && nums[nums.length-1] >= target){
            int res = Arrays.binarySearch(nums,index+1,nums.length,target);
            return res < 0 ? -1 : res;
        }
        return -1;
    }
}
