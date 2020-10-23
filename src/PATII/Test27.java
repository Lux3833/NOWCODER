package PATII;

import java.util.Scanner;

/**
 * @author - Lx
 * @date - 2020/10/23 - 17:56
 * @Description:
 * 题目描述
 * 如果你是哈利·波特迷，你会知道魔法世界有它自己的货币系统 —— 就如海格告诉哈利的：“十七个银西可(Sickle)兑一个加隆(Galleon)，二
 *
 *  十九个纳特(Knut)兑一个西可，很容易。”现在，给定哈利应付的价钱P和他实付的钱A，你的任务是写一个程序来计算他应该被找的零钱。
 *
 * 输入描述:
 * 输入在1行中分别给出P和A，格式为“Galleon.Sickle.Knut”，其间用1个空格分隔。这里Galleon是[0, 107]]区间内的整数，Sickle是[0,
 * 17)区间内的整数，Knut是[0, 29)区间内的整数。
 *
 *
 * 输出描述:
 * 在一行中用与输入同样的格式输出哈利应该被找的零钱。如果他没带够钱，那么输出的应该是负数。
 *
 * 输入例子:
 * 10.16.27 14.1.28
 *
 * 输出例子:
 * 3.2.1
 */
public class Test27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        String[] p = str1.split("\\.");
        String[] a = str2.split("\\.");
        Integer p1 = Integer.parseInt(p[0]);
        Integer p2 = Integer.parseInt(p[1]);
        Integer p3 = Integer.parseInt(p[2]);
        Integer a1 = Integer.parseInt(a[0]);
        Integer a2 = Integer.parseInt(a[1]);
        Integer a3 = Integer.parseInt(a[2]);

        StringBuilder sb = new StringBuilder();
        int amountA = a1*17*29+a2*29+a3;
        int amountP = p1*17*29+p2*29+p3;
        int res = amountA - amountP;
        if(res < 0){
            sb.append("-");
        }
        res = Math.abs(res);
        int galleon = 0;
        int sickle = 0;
        int knut = 0;
        galleon = res / (17*29);
        if(galleon == 0){
            sb.append("0.");
            sickle = res / 29;
            if(sickle == 0){
                sb.append("0."+res);
            }else{
                knut = res % 29;
                sb.append(sickle+"."+knut);
            }
        }else{
            res = res % (17*29);
            sb.append(galleon+".");
            sickle = res / 29;
            if(sickle == 0){
                sb.append("0."+res);
            }else{
                knut = res % 29;
                sb.append(sickle+"."+knut);
            }
        }
        System.out.print(sb);
    }
}
