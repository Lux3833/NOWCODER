package Other.Zuo.Base;

/**
 * @title: Demo02
 * @Author: Lux_er
 * @Date: 2021/3/31 0031 下午 6:15
 * @Description:
 * 用递归求出数组中的最大值
 */
public class Demo02 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        int[] nums = utils.inputNums();
        int max = getMax(nums);
        System.out.println(max);
    }

    private static int getMax(int[] nums) {
        return process(nums,0,nums.length-1);
    }

    private static int process(int[] nums, int L, int R) {
        if(L == R){
            return nums[L];
        }
        int mid = L + ((R - L) >> 1);
        int leftMax = process(nums, L, mid);
        int rightMax = process(nums,mid+1, R);
        return Math.max(leftMax, rightMax);
    }
}
