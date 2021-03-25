package LeetCode;

import java.util.Scanner;

/**
 * @author - Lx
 * @date - 2020/10/24 - 19:39
 * @Description:
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int max = 0;
        int[] arr = new int[200];
        int left = 0;
        for(int i = 0;i < str.length();i++){
            arr[str.charAt(i)]++;
            while (arr[str.charAt(i)] > 1){
                arr[str.charAt(left++)]--;
            }
            if(i-left+1 > max){
                max = i - left + 1;
            }
        }
        System.out.print(max);
    }
}
