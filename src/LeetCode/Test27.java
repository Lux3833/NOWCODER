package LeetCode;

/**
 * @title: Test27
 * @Author: Lux_er
 * @Date: 2021/3/26 0026 上午 9:06
 * @Description:
 * 给你一个数组 nums和一个值 val，你需要原地移除所有数值等于val的元素，
 * 并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class Test27 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        int n = utils.inputNumber();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = utils.inputNumber();
        }
        int val = utils.inputNumber();
        int len = removeElement(nums,val);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]+" ");
        }
    }

    private static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
