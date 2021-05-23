package LeetCode.Test61_120;

import LeetCode.Utils;

/**
 * @title:
 * @Author:Administrator
 * @Date:A2021/5/15 10:22
 * @Description:加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 示例：
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 */
public class Test66 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        int n = utils.inputNumber();
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            digits[i] = utils.inputNumber();
        }
        int[] res = plusOne(digits);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }
    public static int[] plusOne(int[] digits) {
        if(digits.length == 0 || digits == null){
            return digits;
        }
        int len = digits.length;
        if(digits[len-1] != 9){
            digits[len-1] = digits[len-1]+1;
            return digits;
        }
        boolean flag = false;
        digits[len-1] = 10;
        for (int i = len-1;i >= 0; i--) {
            if(digits[i] == 10){
                digits[i] = 0;
                if(i - 1 >= 0){
                    digits[i-1] = digits[i-1]+1;
                }else{
                    flag = true;
                }
            }
        }
        if(flag){
            int[] res = new int[len+1];
            res[0] = 1;
            for (int i = 1; i < res.length; i++) {
                res[i] = digits[i-1];
            }
            return res;
        }
        return digits;
    }
    // 大佬解法
    public static int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
