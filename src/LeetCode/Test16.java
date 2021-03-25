package LeetCode;

import java.util.Arrays;

/**
 * @title: Test16
 * @Author: Lux_er
 * @Date: 2021/3/25 0025 下午 10:00
 * @Description:
 * 给定一个包括n 个整数的数组nums和 一个目标值target。
 * 找出nums中的三个整数，使得它们的和与target最接近。返回这三个数的和。
 * 假定每组输入只存在唯一答案。
 */
public class Test16 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        int n = utils.inputNumber();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = utils.inputNumber();
        }
        int target = utils.inputNumber();
        int res = threeSum(nums,target);
        System.out.println(res);
    }

    private static int threeSum(int[] arr, int target) {
        if(arr == null || arr.length < 3){
            return 0;
        }
        Arrays.sort(arr);
        int close = getDistance(arr[0]+arr[1]+arr[2],target);
        int sum = 0;
        int res = arr[0]+arr[1]+arr[2];
        for (int i = 0; i < arr.length; i++) {
            if(i > 0 && arr[i] == arr[i-1]) continue;
            int L = i+1;
            int R = arr.length-1;
            while (L < R) {
                sum = arr[i]+arr[L]+arr[R];
                if(close > getDistance(sum, target)){
                    res = sum;
                    close = getDistance(sum, target);
                }
                if(sum > target) R--;
                else if(sum < target) L++;
                else return sum;
            }
        }
        return res;
    }

    private static int getDistance(int i, int target) {
        int res = 0;
        return  res = i > target ? i - target : target - i;
    }
}
