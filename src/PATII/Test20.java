package PATII;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author - Lx
 * @date - 2020/10/22 - 22:08
 * @Description:
 * 题目描述
 * 给定一个正整数数列，和正整数p，设这个数列中的最大值是M，最小值是m，如果M <= m * p，则称这个数列是完美数列。
 *
 * 现在给定参数p和一些正整数，请你从中选择尽可能多的数构成一个完美数列。
 *
 * 输入描述:
 * 输入第一行给出两个正整数N和p，其中N（<= 105）是输入的正整数的个数，p（<= 109）是给定的参数。第二行给出N个正整数，每个数
 * 不超过109。
 *
 *
 * 输出描述:
 * 在一行中输出最多可以选择多少个数可以用它们组成一个完美数列。
 *
 * 输入例子:
 * 10 8
 * 2 3 20 4 5 1 6 7 8 9
 *
 * 输出例子:
 * 8
 */
public class Test20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int p = scanner.nextInt();
        int[] arr = new int[N];
        for(int i = 0;i < N;i++){
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        int length = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + length; j < N; j++) {
                if (arr[j] > arr[i] * p)
                    break;
                length++;
            }
        }
        System.out.print(length);
    }
}
