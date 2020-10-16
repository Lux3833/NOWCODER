package PATII;

import java.util.Scanner;

/**
 * @author - Lx
 * @date - 2020/10/15 - 23:21
 * @Description:
 * 题目描述
 * 大家应该都会玩“锤子剪刀布”的游戏：
 * 现给出两人的交锋记录，请统计双方的胜、平、负次数，并且给出双方分别出什么手势的胜算最大。
 *
 * 输入描述:
 * 输入第1行给出正整数N（<=105），即双方交锋的次数。随后N行，每行给出一次交锋的信息，即甲、乙双方同时给出的的手势。C代表“锤子”、J代表“剪刀”、B代
 * 表“布”，第1个字母代表甲方，第2个代表乙方，中间有1个空格。
 *
 *
 * 输出描述:
 * 输出第1、2行分别给出甲、乙的胜、平、负次数，数字间以1个空格分隔。第3行给出两个字母，分别代表甲、乙获胜次数最多的手势，中间有1个空格。如果解不唯
 * 一，则输出按字母序最小的解。
 *
 * 输入例子:
 * 10
 * C J
 * J B
 * C B
 * B B
 * B C
 * C C
 * C B
 * J B
 * B C
 * J J
 *
 * 输出例子:
 * 5 3 2
 * 2 3 5
 * B B
 */
public class Test8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        char[] A = new char[N];
        char[] B = new char[N];
        int[] consequenceA = new int[3];
        int[] consequenceB = new int[3];
        int[] poseA = new int[3];
        int[] poseB = new int[3];

        for(int i = 0;i < N;i++){
//            String str = scanner.nextLine();
//            A[i] = str.substring(0,1).charAt(0);
//            B[i] = str.substring(2).charAt(0);
              A[i] = scanner.next().charAt(0);
              B[i] = scanner.next().charAt(0);
        }
        for(int i = 0;i < N;i++){
            if(A[i] == 'C' && B[i] == 'J' || A[i] == 'J' && B[i] == 'B' || A[i] == 'B' && B[i] == 'C'){
                consequenceA[0]++;
                consequenceB[2]++;
                switch (A[i]){
                    case 'C':
                        poseA[1]++;
                        break;
                    case 'J':
                        poseA[2]++;
                        break;
                    case 'B':
                        poseA[0]++;
                        break;
                }
            }else if(A[i] == 'C' && B[i] == 'B' || A[i] == 'J' && B[i] == 'C' || A[i] == 'B' && B[i] == 'J'){
                consequenceA[2]++;
                consequenceB[0]++;
                switch (B[i]){
                    case 'C':
                        poseB[1]++;
                        break;
                    case 'J':
                        poseB[2]++;
                        break;
                    case 'B':
                        poseB[0]++;
                        break;
                }
            }else{
                consequenceA[1]++;
                consequenceB[1]++;
            }
        }

        for(int i:consequenceA){
            System.out.print(i+" ");
        }
        System.out.println();

        for(int j:consequenceB){
            System.out.print(j+" ");
        }
        System.out.println();

        int temp = 0;
        for(int i = 0;i < 3;i++){
            if(poseA[temp] < poseA[i]){
                temp = i;
            }
        }
        switch (temp){
            case 0:
                System.out.print("B ");
                break;
            case 1:
                System.out.print("C ");
                break;
            case 2:
                System.out.print("J ");
                break;
        }
        temp = 0;
        for(int i = 0;i < 3;i++){
            if(poseB[temp] < poseB[i]){
                temp = i;
            }
        }
        switch (temp){
            case 0:
                System.out.print("B");
                break;
            case 1:
                System.out.print("C");
                break;
            case 2:
                System.out.print("J");
                break;
        }
    }
}
