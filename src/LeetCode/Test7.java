package LeetCode;

/**
 * @title: Test7
 * @Author: Lux_er
 * @Date: 2021/3/25 0025 下午 9:36
 * @Description:
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围[−231, 231− 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 */
public class Test7 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        int num = utils.inputNumber();
        int res = reverse(num);
        System.out.println(res);
    }

    private static int reverse(int num) {
        long res = 0;
        while(num != 0){
            int reminder = num % 10;
            res = res * 10 + reminder;
            if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
                return 0;
            }
            num = num / 10;
        }
        return (int)res;
    }
}
