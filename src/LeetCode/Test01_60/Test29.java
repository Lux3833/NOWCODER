package LeetCode.Test01_60;
import java.util.Scanner;

/**
 * @title: Test29
 * @Author: Lux_er
 * @Date: 2021/3/18 0018 下午 6:58
 * @Description:
 * 给定两个整数，被除数dividend和除数divisor。将两数相除，
 * 要求不使用乘法、除法和 mod 运算符。
 * 返回被除数dividend除以除数divisor得到的商。
 * 整数除法的结果应当截去（truncate）其小数部分，
 * 例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2

 */
public class Test29 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int dividend = scanner.nextInt();
        int divisor = scanner.nextInt();
        int res = divide(dividend,divisor);
        System.out.println(res);
    }

    private static int divide(int dividend, int divisor) {
        if(divisor == 1) return dividend;
        if(divisor == -1) return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE:-dividend;
        long res = 0; //返回值
        int time = 1;//叠加的次数
        long divid = dividend;
        long divis = divisor;
        int isPositive = 1;//判断正负号
        if(divid < 0){
            divid = -divid;
            isPositive = -isPositive;
        }
        if(divis < 0){
            divis = -divis;
            isPositive = -isPositive;
        }
        long increment = divis;
        while(increment <= divid) {
            if (increment + increment > divid) {
                res += time;
                divid -= increment;
                increment = divis;
                time = 1;
                continue;//很重要
            }
            increment += increment;
            time += time;
        }
        return (int) (isPositive == 1 ? res : -res);
    }
}
