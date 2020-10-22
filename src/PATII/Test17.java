package PATII;

import java.util.Scanner;

/**
 * @author - Lx
 * @date - 2020/10/22 - 19:58
 * @Description:
 * 题目描述
 * 本题要求你写个程序把给定的符号打印成沙漏的形状。例如给定17个“*”，要求按下列格式打印
 *
 *  *****
 *   ***
 *    *
 *   ***
 *  *****
 *  所谓“沙漏形状”，是指每行输出奇数个符号；各行符号中心对齐；相邻两行符号数差2；符号数先从大到小顺序递减到1，再从小到大顺序递
 *  增；首尾符号数相等。
 *
 *  给定任意N个符号，不一定能正好组成一个沙漏。要求打印出的沙漏能用掉尽可能多的符号。
 *
 * 输入描述:
 * 输入在一行给出1个正整数N（<=1000）和一个符号，中间以空格分隔。
 *
 *
 * 输出描述:
 * 首先打印出由给定符号组成的最大的沙漏形状，最后在一行中输出剩下没用掉的符号数。
 *
 * 输入例子:
 * 19 *
 *
 * 输出例子:
 * *****
 *  ***
 *  *
 *  ***
 * *****
 * 2
 */
public class Test17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        String sign = scanner.next();
        scanner.close();

        int n = 1;
        while(2*n*n-1 <= amount){
            n++;
        }
        n--;
        int res = amount - 2*n*n + 1;

        int h = 2*n-1;
        //下三角
        for(int i = 0;i < n;i++){
            for(int j = 0;j < i;j++){
                System.out.print(" ");
            }
            for(int j = 0;j < h-2*i;j++){
                System.out.print(sign);
            }
            for(int j = 0;j < i;j++){
                System.out.print(" ");
            }
            System.out.println();
        }
        //上三角
            for(int i = 0;i < n-1;i++){
                for(int j = 1;j < n-1-i;j++){
                    System.out.print(" ");
                }
                for(int j = 0;j < 2*i+3;j++){
                    System.out.print(sign);
                }
                for(int j = 1;j < n-1-i;j++){
                    System.out.print(" ");
                }
                System.out.println();
            }
        System.out.print(res);
    }
}
