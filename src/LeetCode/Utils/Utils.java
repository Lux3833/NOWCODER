package LeetCode.Utils;

import java.util.List;
import java.util.Scanner;

/**
 * @title: Utils
 * @Author: Lux_er
 * @Date: 2021/3/25 0025 下午 9:27
 * @Description:
 */
public class Utils {
    public int[] inputNums(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        return nums;
    }
    public char inputCharacter(){
        Scanner scanner = new Scanner(System.in);
        char ch = scanner.next().charAt(0);
        return ch;
    }
    public int inputNumber(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        return n;
    }
    public String inputStr(){
        Scanner scanner = new Scanner(System.in);
        return  scanner.next();
    }
    public void printNums(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }
    public String[] inputStrs(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = scanner.next();
        }
        return strs;
    }
    public double intputDouble(){
        Scanner scanner = new Scanner(System.in);
        double res = scanner.nextDouble();
        return res;
    }
    public void printIntNum(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }
    public void printIntMatrix(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public void printListInteger(List<Integer> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }
}
