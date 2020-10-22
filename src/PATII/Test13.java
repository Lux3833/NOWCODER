package PATII;

import java.util.Scanner;

/**
 * @author - Lx
 * @date - 2020/10/17 - 21:57
 * @Description:
 * 题目描述
 * 给定数字0-9各若干个。你可以以任意顺序排列这些数字，但必须全部使用。目标是使得最后得到的数尽可能小（注意0不能做首位）。例如：
 * 给定两个0，两个1，三个5，一个8，我们得到的最小的数就是10015558。
 *
 * 现给定数字，请编写程序输出能够组成的最小的数。
 *
 * 输入描述:
 * 每个输入包含1个测试用例。每个测试用例在一行中给出10个非负整数，顺序表示我们拥有数字0、数字1、……数字9的个数。整数间用一个空
 * 格分隔。10个数字的总个数不超过50，且至少拥有1个非0的数字。
 *
 *
 * 输出描述:
 * 在一行中输出能够组成的最小的数。
 *
 * 输入例子:
 * 2 2 0 0 0 3 0 0 1 0
 *
 * 输出例子:
 * 10015558
 */
public class Test13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr2 = new int[10];
        for(int i = 0;i < 10;i++){
            arr2[i] = scanner.nextInt();
        }
        if(arr2[0] == 0){
            for(int i = 0;i < 10;i++){
                if(arr2[i] != 0){
                    for(int j = 0;j < arr2[i];j++){
                        System.out.print(i);
                    }
                }
            }
        }else{
            int index = 0;
            for(int i = 1;i < 10;i++){
                if(arr2[i] != 0){
                    index = i;
                    System.out.print(i);
                    for(int j = 0;j < arr2[0];j++){
                        System.out.print(0);
                    }
                    arr2[i]--;
                    break;
                }
            }
            for(int k = index;k < 10;k++){
                if(arr2[k] != 0){
                    for(int w = 0;w < arr2[k];w++){
                        System.out.print(k);
                    }
                }
            }
        }
    }
}
