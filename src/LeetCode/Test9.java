package LeetCode;

/**
 * @title: Test9
 * @Author: Lux_er
 * @Date: 2021/3/25 0025 下午 9:43
 * @Description:
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 例如，121 是回文，而 123 不是。
 */
public class Test9 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        int num = utils.inputNumber();
        boolean res = isPalindrome(num);
        System.out.println(res);
    }

    private static boolean isPalindrome(int num) {
        if(num < 0){
            return false;
        }else if(num >= 0 && num <= 9){
            return true;
        }
        int temp = 0;
        int val = 0;
        int account = num;
        while(account > 0){
            temp = account % 10;
            val = val * 10 + temp;
            account = account / 10;
        }
        if(num == val){
            return true;
        }else{
            return false;
        }
    }
}
