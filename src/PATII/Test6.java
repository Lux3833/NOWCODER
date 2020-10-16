package PATII;

import java.util.Scanner;

/**
 * @author - Lx
 * @date - 2020/10/15 - 22:59
 * @Description:
 * 题目描述
 * 正整数A的“DA（为1位整数）部分”定义为由A中所有DA组成的新整数PA。例如：给定A = 3862767，DA = 6，则A的“6部分”PA是66，因为A中有2个6。
 *
 *  现给定A、DA、B、DB，请编写程序计算PA + PB。
 *
 * 输入描述:
 * 输入在一行中依次给出A、DA、B、DB，中间以空格分隔，其中0 < A, B < 1010。
 *
 *
 * 输出描述:
 * 在一行中输出PA + PB的值。
 *
 * 输入例子:
 * 3862767 6 13530293 3
 *
 * 输出例子:
 * 399
 */
public class Test6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int DA = scanner.nextInt();
        int B = scanner.nextInt();
        int DB = scanner.nextInt();
        int PA = 0;
        int PB = 0;
        String strA = A + "";
        String strB = B + "";
        char[] arrA = strA.toCharArray();
        char[] arrB = strB.toCharArray();
        for(int i = 0;i < arrA.length;i++){
            if(arrA[i] - '0' == DA){
                PA = PA * 10 + DA;
            }
        }
        for(int j = 0;j < arrB.length;j++){
            if(arrB[j] - '0' == DB){
                PB = PB * 10 + DB;
            }
        }
        System.out.print(PA+PB);
    }
}
