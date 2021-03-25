package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @title: Test15
 * @Author: Lux_er
 * @Date: 2021/3/25 0025 下午 9:57
 * @Description:
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，
 * 注意：答案中不可以包含重复的三元组。
 */
public class Test15 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        int n = utils.inputNumber();
        int[] nums = new int[n];
        List<List<Integer>> list = new ArrayList<>();
        list = threeSum(nums);
        System.out.println(list);
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        if(nums.length < 3 || nums == null){
            return list;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) break;//若当前数字大于0,则总和必大于0
            if(i > 0 && nums[i] == nums[i-1]) continue;//去重
            int L = i+1;
            int R = nums.length-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while(L < R && nums[L] == nums[L+1]) L++;
                    while(L < R && nums[R] == nums[R-1]) R--;
                    L++;
                    R--;
                }
                else if(sum < 0) L++;
                else if(sum > 0) R--;
            }
        }
        return list;
    }
}
