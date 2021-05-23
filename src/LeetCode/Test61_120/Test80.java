package LeetCode.Test61_120;

import LeetCode.Utils.Utils;

/**
 * @title: Test80
 * @Author: Lux_er
 * @Date: 2021/5/18 0018 下午 6:07
 * @Description:删除有序数组中的重复项 II
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 示例：
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 不需要考虑数组中超出新长度后面的元素。
 */
public class Test80 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        int[] nums = utils.inputNums();
        System.out.println(removeDuplicates(nums));
    }
    public static int removeDuplicates(int[] nums) {
        if(nums.length<2)
            return nums.length;
        int slow=2;
        for(int fast=2;fast<nums.length;fast++)
        {
            if(nums[fast]==nums[slow-2])
            {
                continue;
            }
            else {
                nums[slow++]=nums[fast];
            }
        }
        return slow;
    }
}
