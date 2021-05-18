package LeetCode.Test01_60;

import LeetCode.Utils.Utils;

import java.util.Arrays;

/**
 * @title: Test26
 * @Author: Lux_er
 * @Date: 2021/3/26 0026 上午 9:03
 * @Description:
 * 给你一个有序数组nums,请你原地删除重复出现的元素，使每个元素只出现一次 ，
 * 返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组 并在使用 O(1)
 * 额外空间的条件下完成。
 */
public class Test26 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        int n = utils.inputNumber();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = utils.inputNumber();
        }
        int len = removeDuplicates(nums);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]+" ");
        }
    }

    private static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int p,q;//p指向不重复元素下标，q向后移动直到等于数组长度
        p = 0;
        q = 1;
        while (q < nums.length) {
            if(nums[p] != nums[q]){
                nums[p+1] = nums[q];
                p++;
            }
            q++;
        }
        return p+1;
    }
}
