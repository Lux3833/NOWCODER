package LeetCode.Test61_120;

import LeetCode.Utils.Utils;

import java.util.Arrays;

/**
 * @title: Test81
 * @Author: Lux_er
 * @Date: 2021/5/19 0019 上午 10:34
 * @Description:搜索旋转排序数组II
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。
 * 如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
 * 示例：
 * 输入：nums = [2,5,6,0,0,1,2], target = 0
 * 输出：true
 */
public class Test81 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        int[] nums = utils.inputNums();
        int target = utils.inputNumber();
        System.out.println(search(nums,target));
    }
    public static boolean search(int[] nums, int target) {
        if(nums.length == 0 || nums == null){
            return false;
        }
        if(nums.length == 1){
            return nums[0] == target ? true : false;
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
            return res < 0 ? false : true;
        }else if(nums[index+1] <= target && nums[nums.length-1] >= target){
            int res = Arrays.binarySearch(nums,index+1,nums.length,target);
            return res < 0 ? false : true;
        }
        return false;
    }
    /*
     *本题是需要使用二分查找，怎么分是关键，举个例子：
    第一类
    1011110111 和 1110111101 这种。此种情况下 nums[start] == nums[mid]，分不清到底是前面有序还是后面有序，此时 start++ 即可。相当于去掉一个重复的干扰项。
    第二类
    22 33 44 55 66 77 11 这种，也就是 nums[start] < nums[mid]。此例子中就是 2 < 5；
    这种情况下，前半部分有序。因此如果 nums[start] <=target<nums[mid]，则在前半部分找，否则去后半部分找。
    第三类
    66 77 11 22 33 44 55 这种，也就是 nums[start] > nums[mid]。此例子中就是 6 > 2；
    这种情况下，后半部分有序。因此如果 nums[mid] <target<=nums[end]。则在后半部分找，否则去前半部分找。
     */
    public static boolean search2(int[] nums,int target){
        if (nums == null || nums.length == 0) {
            return false;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[start] == nums[mid]) {
                start++;
                continue;
            }
            //前半部分有序
            if (nums[start] < nums[mid]) {
                //target在前半部分
                if (nums[mid] > target && nums[start] <= target) {
                    end = mid - 1;
                } else {  //否则，去后半部分找
                    start = mid + 1;
                }
            } else {
                //后半部分有序
                //target在后半部分
                if (nums[mid] < target && nums[end] >= target) {
                    start = mid + 1;
                } else {  //否则，去后半部分找
                    end = mid - 1;

                }
            }
        }
        //一直没找到，返回false
        return false;
    }
}
