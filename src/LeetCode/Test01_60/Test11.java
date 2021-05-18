package LeetCode.Test01_60;

import LeetCode.Utils.Utils;

/**
 * @title: Test11
 * @Author: Lux_er
 * @Date: 2021/3/25 0025 下午 9:46
 * @Description:
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器。
 */
public class Test11 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        int n = utils.inputNumber();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = utils.inputNumber();
        }
        int res = maxArea(arr);
        System.out.println(res);
    }

    private static int maxArea(int[] arr) {
        int i = 0;
        int j = arr.length-1;
        int res = 0;
        res = (j - i) * (arr[i] < arr[j] ? arr[i] : arr[j]);
        while(i != j){
            if(arr[i] <= arr[j]){
                i++;
                res = Math.max(res, (j-i)*(arr[i] < arr[j] ? arr[i] : arr[j]));
            }else{
                j--;
                res = Math.max(res, (j-i)*(arr[i] < arr[j] ? arr[i] : arr[j]));
            }
        }
        return res;
    }
}
