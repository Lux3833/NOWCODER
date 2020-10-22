package PATII;

import java.util.Scanner;

/**
 * @author - Lx
 * @date - 2020/10/22 - 19:55
 * @Description: 题目描述
 * 要获得一个C语言程序的运行时间，常用的方法是调用头文件time.h，其中提供了clock()函数，可以捕捉从程序开始运行到clock()被调用时所
 * 耗费的时间。这个时间单位是clock tick，即“时钟打点”。同时还有一个常数CLK_TCK，给出了机器时钟每秒所走的时钟打点数。于是为了获
 * 得一个函数f的运行时间，我们只要在调用f之前先调用clock()，获得一个时钟打点数C1；在f执行完成后再调用clock()，获得另一个时钟打点
 * 数C2；两次获得的时钟打点数之差(C2-C1)就是f运行所消耗的时钟打点数，再除以常数CLK_TCK，就得到了以秒为单位的运行时间。
 * <p>
 * 这里不妨简单假设常数CLK_TCK为100。现给定被测函数前后两次获得的时钟打点数，请你给出被测函数运行的时间。
 * <p>
 * 输入描述:
 * 输入在一行中顺序给出2个整数C1和C2。注意两次获得的时钟打点数肯定不相同，即C1 < C2，并且取值在[0, 107]
 * <p>
 * <p>
 * 输出描述:
 * 在一行中输出被测函数运行的时间。运行时间必须按照“hh:mm:ss”（即2位的“时:分:秒”）格式输出；不足1秒的时间四舍五入到秒。
 * <p>
 * 输入例子:
 * 123 4577973
 * <p>
 * 输出例子:
 * 12:42:59
 */

public class Test16 {
    private static final double CLK_TCK = 100.0;
    private static final int MINUTE = 60;
    private static final int HOURS = 3600;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int c1 = in.nextInt();
        int c2 = in.nextInt();
        double time = (c2 - c1) / CLK_TCK;
        int h = (int) time / HOURS;
        time %= HOURS;
        int m = (int) time / MINUTE;
        time %= MINUTE;
        System.out.printf("%02d:%02d:%02.0f\n", h, m, time);
    }
}
