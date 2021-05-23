package LeetCode.Test01_60;

import LeetCode.Utils.Utils;

/**
 * @title: Test34
 * @Author: Lux_er
 * @Date: 2021/3/19 0019 上午 10:07
 * @Description:
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。
 * 找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 */
public class Test34 {
    public static void main(String args[]){
        Utils utils = new Utils();
        int[] nums = utils.inputNums();
        int target = utils.inputNumber();
        int[] res = searchRange(nums,target);
        utils.printNums(res);
    }

    private static int[] searchRange(int[] nums, int target) {
        int leftIndex = binarySearch(nums,target,true);
        int rightIndex = binarySearch(nums,target,false);
        if(leftIndex < rightIndex && rightIndex < nums.length
                && nums[leftIndex] == target && nums[rightIndex] == target){
            return new int[]{leftIndex,rightIndex};
        }
        return new int[]{-1,-1};
    }

    private static int binarySearch(int[] nums, int target, boolean lower) {
        int leftIndex = 0,rightIndex = nums.length-1,ans = nums.length;
        while(leftIndex < rightIndex){
            int mid = (leftIndex + rightIndex) / 2;
            if(nums[mid] > target || (lower && nums[mid] >= target)){
                rightIndex = mid - 1;
                ans = mid;
            }else{
                leftIndex = mid + 1;
            }
        }
        return ans;
    }
}
