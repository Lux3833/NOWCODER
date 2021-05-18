package LeetCode.Test01_60;
import java.util.Scanner;
/**
 * @title: Test35
 * @Author: Lux_er
 * @Date: 2021/3/11 0011 下午 4:11
 * @Description:
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 */
public class Test35 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int val = scanner.nextInt();
        int index = searchInsert(arr,val);
        System.out.println(index);
    }

    private static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = nums.length-1;
        int ans = n;
        while (left <= right) {
            int mid = (right-left)/2+left;
            if(target <= nums[mid]){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }
}
