package LeetCode.Test01_60;

import LeetCode.Utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @title: Test18
 * @Author: Lux_er
 * @Date: 2021/3/25 0025 下午 10:10
 * @Description:
 * 给定一个包含n 个整数的数组nums和一个目标值target，
 * 判断nums中是否存在四个元素 a，b，c和 d，使得a + b + c + d的值
 * 与target相等？找出所有满足条件且不重复的四元组。
 * 注意：答案中不可以包含重复的四元组。
 */
public class Test18 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        int n = utils.inputNumber();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = utils.inputNumber();
        }
        int target = utils.inputNumber();
        List<List<Integer>> list = new ArrayList<>();
        list = fourSum(nums,target);
        System.out.println(list);
    }

    private static List<List<Integer>> fourSum(int[] arr, int target) {
        List<List<Integer>> list = new ArrayList<>() ;
        if(arr == null || arr.length < 4){
            return list;
        }
        Arrays.sort(arr);
        int len = arr.length;
        //第一次循环
        for (int i = 0; i < len-3; i++) {//注意要len-3
            if(i > 0 && arr[i] == arr[i-1]){
                continue;
            }
            if(arr[i]+arr[i+1]+arr[i+2]+arr[i+3] > target){//剪枝
                break;
            }
            if (arr[i] + arr[len - 3] + arr[len - 2] + arr[len - 1] < target) {//剪枝
                continue;
            }
            //第二次循环
            for (int j = i+1; j < len-2; j++) {
                if(j > i+1 && arr[j] == arr[j-1]){
                    continue;
                }
                if(arr[i]+arr[j]+arr[j+1]+arr[j+2] > target){//剪枝
                    break;
                }
                if(arr[i]+arr[j]+arr[len-2]+arr[len-1] < target){//剪枝
                    continue;
                }
                int left = j+1;
                int right = len-1;
                while(left < right){
                    int sum = arr[i]+arr[j]+arr[left]+arr[right];
                    if(sum == target){
                        list.add(Arrays.asList(arr[i],arr[j],arr[left],arr[right]));
                        while(left < right && arr[left] == arr[left+1])
                            left++;
                        while(left < right && arr[right] == arr[right-1])
                            right--;
                        left++;
                        right--;
                    }
                    else if(sum < target) left++;
                    else if(sum > target) right--;
                }
            }
        }
        return list;
    }
}
