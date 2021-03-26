package LeetCode;
/**
 * @title: Test53
 * @Author: Lux_er
 * @Date: 2021/3/11 0011 下午 6:55
 * @Description:
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class Test53 {
    public static void main(String args[]){
        Utils utils = new Utils();
        int[] nums = utils.inputNums();
        int max = maxSubArray(nums);
        System.out.println(max);
    }

    private static int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
