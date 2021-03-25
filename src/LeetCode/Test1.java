package LeetCode;

import java.util.Scanner;

/**
 * @author - Lx
 * @date - 2020/10/24 - 12:14
 * @Description:
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] nums = new int[N];
        for(int i = 0;i < N;i++){
            nums[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();

        twoSum(nums,target);
    }

    private static void twoSum(int[] nums, int target) {
        int index1 = 0;
        int index2 = 0;
        int temp = 0;
        for(int i = 0;i < nums.length;i++){
                index1 = i;
                temp = target - nums[i];
                index2 = getNext(temp,nums,i);
                if(index2 != -1){
                    break;
            }
        }
        if(index2 == -1){
            index1 = index2 = 0;
        }
        System.out.print("["+index1+","+index2+"]");
    }

    private static int getNext(int temp, int[] nums,int start) {
        int next = -1;
        for(int i = start+1;i < nums.length;i++){
            if(temp == nums[i]){
                next = i;
                break;
            }
        }
        return next;
    }
}
