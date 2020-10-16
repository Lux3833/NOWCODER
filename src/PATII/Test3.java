package PATII;

    import java.util.Scanner;

/**
 * @author - Lx
 * @date - 2020/10/15 - 0:07
 * @Description:
 * 题目描述
 * 令Pi表示第i个素数。现任给两个正整数M <= N <= 10000，请输出PM到PN的所有素数。
 *
 * 输入描述:
 * 输入在一行中给出M和N，其间以空格分隔。
 *
 *
 * 输出描述:
 * 输出从PM到PN的所有素数，每10个数字占1行，其间以空格分隔，但行末不得有多余空格。
 *
 * 输入例子:
 * 5 27
 *
 * 输出例子:
 * 11 13 17 19 23 29 31 37 41 43
 * 47 53 59 61 67 71 73 79 83 89
 * 97 101 103
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        boolean flag = true;
        int index = 0;
        int count = 0;
        scanner.close();

        for(int i = 2;i < Integer.MAX_VALUE;i++){
            int temp = (int) Math.sqrt(i);
            for(int j = 1;j <= temp;j++){
                if(i % j == 0 && j != 1){
                    flag = false;
                    break;
                }
            }
            if(flag){
                index++;
                if(index >= M && index <= N){
                    System.out.print(i);
                    count++;
                    if(count % 10 == 0){
                        System.out.println();
                    }else if(count == N - M + 1){
                        return;
                    }else{
                        System.out.print(" ");
                    }
                }
            }else{
                flag = true;
            }
        }

//        for(int i = M;i <= N;i++){
//            int temp = (int)Math.sqrt(i);
//            for(int j = 2;j <= temp;j++){
//                if(i % j == 0){
//                    flag = false;
//                    break;
//                }
//            }
//            if(flag){
//                System.out.print(i);
//                count++;
//                if(count == 10){
//                    System.out.println();
//                    count = 0;
//                }else{
//                    System.out.print(" ");
//                }
//            }else{
//                flag = true;
//            }
//        }
    }
}
