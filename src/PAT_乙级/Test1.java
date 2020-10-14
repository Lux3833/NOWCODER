package PAT_乙级;

import java.util.Scanner;

/*A+B和C
 *
 * 题目描述
给定区间[-2的31次方, 2的31次方]内的3个整数A、B和C，请判断A+B是否大于C。

输入描述:
输入第1行给出正整数T(<=10)，是测试用例的个数。随后给出T组测试用例，每组占一行，顺序给出A、B和C。整数间以空格分隔。

输出描述:
对每组测试用例，在一行中输出“Case #X: true”如果A+B>C，否则输出“Case #X: false”，其中X是测试用例的编号（从1开始）。

输入例子:
4
1 2 3
2 3 4
2147483647 0 2147483646
0 -2147483648 -2147483647

输出例子:
Case #1: false
Case #2: true
Case #3: true
Case #4: false
 * */
public class Test1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long a = 0;
        long b = 0;
        long c = 0;
        boolean[] result = new boolean[n];
        for(int i = 0;i < n;i++) {
            a = scanner.nextLong();
            b = scanner.nextLong();
            c = scanner.nextLong();

            boolean flag = (a+b)>c ? true : false;
            result[i] = flag;
        }
        for(int j = 0;j < n;j++) {
            if(result[j]) {
                System.out.println("Case #"+(j+1)+": true");
            }else {
                System.out.println("Case #"+(j+1)+": false");
            }
        }
    }

}
//注意：
/*
 * 关键是处理溢出问题，溢出情况有：
  a和b都是正数，a+b  >= 2^32;
  a和b都是负数，a+b  <= -2^32;

  因此溢出只出现在a b 同号，a b异号的话直接按 (a+b) > c 来算就可以。

  对于a b同号，也有两种处理方法：

  1.b c 同号， 将 (a+b) > c 转换成 a > (c - b)， 此时 （c - b）必定不会出现溢出；


  1.b c 异号，由于式子左边同号，相加后符号不变，式子右边跟左边异号，因此不需要计算即可知道大小关系。
 * */

