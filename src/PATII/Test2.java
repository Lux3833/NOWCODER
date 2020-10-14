package PATII;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author - Lx
 * @date - 2020/10/14 - 23:28
 * @Description:
 * 题目描述
 * 给定一系列正整数，请按要求对数字进行分类，并输出以下5个数字：
 *
 * A1 = 能被5整除的数字中所有偶数的和；
 * A2 = 将被5除后余1的数字按给出顺序进行交错求和，即计算n1-n2+n3-n4...；
 * A3 = 被5除后余2的数字的个数；
 * A4 = 被5除后余3的数字的平均数，精确到小数点后1位；
 * A5 = 被5除后余4的数字中最大数字。
 *
 * 输入描述:
 * 每个输入包含1个测试用例。每个测试用例先给出一个不超过1000的正整数N，随后给出N个不超过1000的待分类的正整数。数字间以空格分隔。
 *
 *
 * 输出描述:
 * 对给定的N个正整数，按题目要求计算A1~A5并在一行中顺序输出。数字间以空格分隔，但行末不得有多余空格。
 * 若其中某一类数字不存在，则在相应位置输出“N”。
 *
 * 输入例子:
 * 13 1 2 3 4 5 6 7 8 9 10 20 16 18
 *
 * 输出例子:
 * 30 11 2 9.7 9
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0;i < n;i++){
            a[i] = scanner.nextInt();
        }
        scanner.close();
        long A1 = 0;
        long A2 = 0;
        int A3 = 0;
        double A4 = 0.0;
        int A5 = 0;
        int flag = 1;
        int countOfA4 = 0;
        boolean existOfA2 = false;

        for(int l : a){
            int remainder = (int)(l % 5);
            switch (remainder){
                case 0:
                    if(l % 2 == 0){
                        A1 = A1 + l;
                    }
                    break;
                case 1:
                    A2 = A2 + l * flag;
                    flag = -1 * flag;
                    existOfA2 = true;
                    break;
                case 2:
                    A3++;
                    break;
                case 3:
                    A4 = A4 + l;
                    countOfA4++;
                    break;
                case 4:
                    if(A5 < l){
                        A5 = l;
                    }
                    break;
            }
        }
        if(A1 == 0){
            System.out.print("N ");
        }else{
            System.out.print(A1+" ");
        }
        if(existOfA2){
            System.out.print(A2+" ");
        }else{
            System.out.print("N ");
        }
        if(A3 == 0){
            System.out.print("N ");
        }else{
            System.out.print(A3+" ");
        }
        if(A4 == 0){
            System.out.print("N ");
        }else{
            DecimalFormat df = new DecimalFormat("#.0");
            System.out.print(df.format(A4*1.0/countOfA4)+" ");
        }
        if(A5 == 0){
            System.out.print("N");
        }else{
            System.out.print(A5);
        }
    }
}
