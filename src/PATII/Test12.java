package PATII;

import java.util.Scanner;

/**
 * @author - Lx
 * @date - 2020/10/16 - 23:05
 * @Description:
 * 题目描述
 * 输入两个非负10进制整数A和B(<=230-1)，输出A+B的D (1 < D <= 10)进制数。
 *
 * 输入描述:
 * 输入在一行中依次给出3个整数A、B和D。
 *
 *
 * 输出描述:
 * 输出A+B的D进制数。
 *
 * 输入例子:
 * 123 456 8
 *
 * 输出例子:
 * 1103
 */
public class Test12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int scale = scanner.nextInt();
        long C = A + B;
        long divide = 0;
        long reminder = 0;
        int index = 0;
        long[] arr = new long[100];
        if(C < scale){
            System.out.print(C);
        }else{
            while(C >= scale){
                reminder = C % scale;
                arr[index] = reminder;
                index++;
                divide = C / scale;
                C = divide;
            }
            arr[index] = C;
        }
        for(int i = index;i >= 0;i--){
            System.out.print(arr[i]);
        }
    }
}
