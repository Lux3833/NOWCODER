package PATII;

import java.util.Scanner;

/**
 * @author - Lx
 * @date - 2020/10/23 - 17:08
 * @Description:
 * 题目描述
 * 美国总统奥巴马不仅呼吁所有人都学习编程，甚至以身作则编写代码，成为美国历史上首位编写计算机代码的总统。2014年底，为庆祝“计算
 *
 *  机科学教育周”正式启动，奥巴马编写了很简单的计算机代码：在屏幕上画一个正方形。现在你也跟他一起画吧！
 *
 * 输入描述:
 * 输入在一行中给出正方形边长N（3<=N<=20）和组成正方形边的某种字符C，间隔一个空格。
 *
 *
 * 输出描述:
 * 输出由给定字符C画出的正方形。但是注意到行间距比列间距大，所以为了让结果看上去更像正方形，我们输出的行数实际上是列数的50%
 * （四舍五入取整）。
 *
 * 输入例子:
 * 10 a
 *
 * 输出例子:
 * aaaaaaaaaa
 * a a
 * a a
 * a a
 * aaaaaaaaaa
 */
public class Test26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int side = scanner.nextInt();
        String icon = scanner.next();

        for(int i = 0;i < side;i++){
            System.out.print(icon);
        }
        System.out.println();
        int high = (side % 2 == 0) ? (side / 2) : (side / 2 + 1);
        while (high - 2 > 0){
            System.out.print(icon);
            for(int i = 1;i < side - 1;i++){
                System.out.print(" ");
            }
            System.out.print(icon);
            high--;
            System.out.println();
        }
        for(int i = 0;i < side;i++){
            System.out.print(icon);
        }
    }
}
