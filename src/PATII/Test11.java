package PATII;

import java.util.Scanner;

/**
 * @author - Lx
 * @date - 2020/10/16 - 18:31
 * @Description:
 * 题目描述
 * 给定一个k位整数N = dk-1*10k-1 + ... + d1*101 + d0 (0<=di<=9, i=0,...,k-1, dk-1>0)，请编写程序统计每种不同的个位数字出现的次数。例如：给定N = 100311，则有2个0，3个1，和1个3。
 *
 * 输入描述:
 * 每个输入包含1个测试用例，即一个不超过1000位的正整数N。
 *
 *
 * 输出描述:
 * 对N中每一种不同的个位数字，以D:M的格式在一行中输出该位数字D及其在N中出现的次数M。要求按D的升序输出。
 *
 * 输入例子:
 * 100311
 *
 * 输出例子:
 * 0:2
 * 1:3
 * 3:1
 */
public class Test11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char[] arr = str.toCharArray();
        int[] count = new int[10];
        for(int i = 0;i < arr.length;i++){
            switch (arr[i]){
                case '0':
                    count[0]++;
                    break;
                case '1':
                    count[1]++;
                    break;
                case '2':
                    count[2]++;
                    break;
                case '3':
                    count[3]++;
                    break;
                case '4':
                    count[4]++;
                    break;
                case '5':
                    count[5]++;
                    break;
                case '6':
                    count[6]++;
                    break;
                case '7':
                    count[7]++;
                    break;
                case '8':
                    count[8]++;
                    break;
                case '9':
                    count[9]++;
                    break;
            }
        }
        for(int i = 0;i < count.length;i++){
            if(count[i] == 0){
                continue;
            }
            System.out.println(i+":"+count[i]);
        }
    }
}
