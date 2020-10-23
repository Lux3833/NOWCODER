package PATII;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author - Lx
 * @date - 2020/10/23 - 18:22
 * @Description:
 * 题目描述
 * 本题要求读入N名学生的成绩，将获得某一给定分数的学生人数输出。
 *
 * 输入描述:
 * 输入在第1行给出不超过105的正整数N，即学生总人数。随后1行给出N名学生的百分制整数成绩，中间以空格分隔。最后1行给出要查询的分
 * 数个数K（不超过N的正整数），随后是K个分数，中间以空格分隔。
 *
 *
 * 输出描述:
 * 在一行中按查询顺序给出得分等于指定分数的学生人数，中间以空格分隔，但行末不得有多余空格。
 *
 * 输入例子:
 * 10
 * 60 75 90 55 75 99 82 90 75 50
 * 3 75 90 88
 *
 * 输出例子:
 * 3 2 0
 */
public class Test28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
       // int[] stu = new int[num];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i < num;i++){
            //stu[i] = scanner.nextInt();
            list.add(scanner.nextInt());
        }
        int checkNum = scanner.nextInt();
        int[] checkScore = new int[checkNum];
        for(int i = 0;i < checkNum;i++){
            checkScore[i] = scanner.nextInt();
        }
        scanner.close();
        int[] amounts = new int[checkNum];
        int index = 0;
        int count = 0;
        for(int i = 0;i < checkNum;i++){
            index++;
            if(list.contains(checkScore[i])){
                count = ++amounts[i];
                list.remove(list.indexOf(checkScore[i]));
                i--;
            }
            if(index > count){
                for(int j = 0;j < count;j++){
                    list.add(checkScore[i]);
                }
                index = 0;
            }
        }
        for(int i = 0;i < checkNum-1;i++){
            System.out.print(amounts[i]+" ");
        }
        System.out.print(amounts[checkNum-1]);
    }
}
